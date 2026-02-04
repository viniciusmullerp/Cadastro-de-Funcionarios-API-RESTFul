package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import dev.funcionarios.CadastroDeFuncionarios.Cargos.Cargos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String telefone;

    private String email;

    private String imgUrl;

    private BigDecimal salario;

    private Cargos cargo;



}
