package dev.funcionarios.CadastroDeFuncionarios.Cargos;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Cargos {

    DESENVOLVEDOR_FRONT_END("Desenvolvedor Front-End"),
    DESENVOLVEDOR_BACK_END("Desenvolvedor Back-End"),
    DESENVOLVEDOR_FULLSTACK("Desenvolvedor Fullstack"),
    DESENVOLVEDOR_JUNIOR("Desenvolvedor Junior"),
    DESENVOLVEDOR_PLENO("Desenvolvedor Pleno"),
    DESENVOLVEDOR_SENIOR("Desenvolvedor Senior"),
    ANALISTA_DE_DADOS("Analista De Dados"),
    UX_UI_DESIGNER("UX UI Designer"),
    TECH_LEAD("Tech Lead"),
    CIENTISTA_DE_DADOS("Cientista De Dados"),
    RH("Recursos Humanos (RH)"),
    MARKETING("Marketing"),
    RECEPCIONISTA("Recepcionista"),
    CONTABILIDADE("Contabilidade"),
    CEO("CEO");


    private String descricao;

    Cargos(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
