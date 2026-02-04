package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
public class FuncionarioController {


    private final FuncionarioService funcionarioService;


    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionario) {
        FuncionarioDTO novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario cadastrado com sucesso: " + novoFuncionario.getNome());
    }


    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncionarioPorId(@PathVariable Long id) {
        FuncionarioDTO funcionario = funcionarioService.listarFuncionarioPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com o ID: " + id + " não encontrado no banco de dados!");
        }
    }


    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarFuncionarioPorId(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        FuncionarioDTO funcionario = funcionarioService.atualizarFuncionarioParcial(id,campos);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com o ID: " + id + " não encontrado no banco de dados!");
        }
    }


    @DeleteMapping("/demitir/{id}")
    public ResponseEntity<String> demitirFuncionarioPorId(@PathVariable Long id) {
        if (funcionarioService.listarFuncionarioPorId(id) != null) {
            funcionarioService.demitirFuncionarioPorId(id);
            return ResponseEntity.ok("Funcionario demitido com sucesso!");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com ID: " + id + " não encontrado!");
        }
    }







}
