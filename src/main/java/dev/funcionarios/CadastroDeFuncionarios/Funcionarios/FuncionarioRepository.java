package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

// LONG do Jpa = Id da classe Model
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {



}
