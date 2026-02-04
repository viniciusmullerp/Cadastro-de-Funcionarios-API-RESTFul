package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper;

    private final ObjectMapper objectMapper;


    // Listar todos os Funcionarios
    public List<FuncionarioDTO> listarFuncionarios() {
        List<FuncionarioModel>  funcionarios = funcionarioRepository.findAll();

        return funcionarios.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }


    // Listar um Funcionario por ID
    public FuncionarioDTO listarFuncionarioPorId(Long id) {
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);

        return funcionarioPorId.map(funcionarioMapper::map).orElse(null);
    }


    // Criar um novo Funcionario
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = funcionarioMapper.map(funcionarioDTO);
        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        return funcionarioMapper.map(funcionarioModel);
    }


    // Demitir Funcionario - Tem que ser um metodo VOID
    public void demitirFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }


    // Atualizar Funcionario por ID
    public FuncionarioDTO atualizarFuncionarioParcial(Long id, Map<String, Object> campos) {
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()) {
            FuncionarioModel funcionarioAtual = funcionarioExistente.get();
            campos.remove("id");
            Map<String, Object> modelMap = objectMapper.convertValue(funcionarioAtual, Map.class);
            modelMap.putAll(campos);

            FuncionarioModel funcionarioAtualizado = objectMapper.convertValue(modelMap, FuncionarioModel.class);

            funcionarioAtualizado = funcionarioRepository.save(funcionarioAtualizado);
            return funcionarioMapper.map(funcionarioAtualizado);
        }
        return null;
    }





}
