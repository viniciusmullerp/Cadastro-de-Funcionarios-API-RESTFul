package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import dev.funcionarios.CadastroDeFuncionarios.Cargos.Cargos;
import jakarta.persistence.*;
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
@Entity
@Table(name = "cadastro")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String cpf;

    private String telefone;

    private String email;

    private String imgUrl;

    private BigDecimal salario;

    @Enumerated(EnumType.STRING)
    private Cargos cargo;




}
