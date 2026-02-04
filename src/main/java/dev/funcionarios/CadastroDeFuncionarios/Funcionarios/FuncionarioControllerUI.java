package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/funcionarios/ui")
@AllArgsConstructor
public class FuncionarioControllerUI {


    private final FuncionarioService funcionarioService;

    private final ObjectMapper objectMapper;

    private final FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper;


    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<FuncionarioModel> funcionariosModel = funcionarioRepository
                .findAll(org.springframework.data.domain.Sort.by("id")
                .ascending());
        List<FuncionarioDTO> funcionarios = funcionariosModel.stream()
                .map(funcionarioMapper::map)
                .toList();
        model.addAttribute("funcionarios", funcionarios);

        return "listarFuncionarios";
    }


    @GetMapping("/demitir/{id}")
    public String demitirFuncionarioPorId(@PathVariable Long id) {
        funcionarioService.demitirFuncionarioPorId(id);

        return "redirect:/funcionarios/ui/listar";
    }


    @GetMapping("/listar/{id}")
    public String listarFuncionarioPorId(@PathVariable Long id, Model model) {
        FuncionarioDTO funcionario = funcionarioService.listarFuncionarioPorId(id);
        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario);

            return "detalhesFuncionario";
        } else  {
            model.addAttribute("mensagem", "funcionario não encontrado!");

            return "listarFuncionarios";
        }
    }


    @GetMapping("/adicionar")
    public String formularioAddFuncionario(Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO());

        return "adicionarFuncionario";
    }


    @PostMapping("/salvar")
    public String salvarFuncionario(@Valid @ModelAttribute("funcionario") FuncionarioDTO funcionario,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        if (result.hasErrors()) {
            return "adicionarFuncionario";
        }
        try {
            funcionarioService.criarFuncionario(funcionario);
            redirectAttributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
            return "redirect:/funcionarios/ui/listar";
        } catch (Exception e) {
            model.addAttribute("mensagemErro", "Erro ao salvar: " + e.getMessage());
            return "adicionarFuncionario";
        }
    }


    @GetMapping("/atualizar/{id}")
    public String abrirPaginaEditar(@PathVariable Long id, Model model) {
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        FuncionarioDTO funcionarioDTO = funcionarioMapper.map(funcionario);
        model.addAttribute("funcionarioDTO", funcionarioDTO);

        return "atualizarFuncionario";
    }

    @PatchMapping("/atualizar/{id}")
    public String atualizarParcial(@PathVariable Long id, @ModelAttribute("funcionarioDTO") FuncionarioDTO funcionarioDTO, RedirectAttributes ra) {
        Map<String, Object> campos = objectMapper.convertValue(funcionarioDTO, Map.class);
        campos.remove("id");
        funcionarioService.atualizarFuncionarioParcial(id, campos);
        ra.addFlashAttribute("mensagem", "Funcionário atualizado com sucesso!");

        return "redirect:/funcionarios/ui/listar";
    }





}




