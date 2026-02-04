package dev.funcionarios.CadastroDeFuncionarios.Funcionarios;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    // De DTO para MODEL (Para salvar no banco)
    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO == null) return null;

        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionarioModel.setCpf(funcionarioDTO.getCpf());
        funcionarioModel.setTelefone(funcionarioDTO.getTelefone());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setImgUrl(funcionarioDTO.getImgUrl());
        funcionarioModel.setSalario(funcionarioDTO.getSalario());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());

        return funcionarioModel;
    }

    // De MODEL para DTO (Para retornar ao usuário)
    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {
        if (funcionarioModel == null) return null;

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        // CORREÇÃO: Usar o objeto funcionarioDTO para receber os dados
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setDataNascimento(funcionarioModel.getDataNascimento());
        funcionarioDTO.setCpf(funcionarioModel.getCpf());
        funcionarioDTO.setTelefone(funcionarioModel.getTelefone());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setImgUrl(funcionarioModel.getImgUrl());
        funcionarioDTO.setSalario(funcionarioModel.getSalario());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());

        return funcionarioDTO;
    }
}