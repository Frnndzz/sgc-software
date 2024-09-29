package br.com.fiap.sgc.dtos.presenca;

import br.com.fiap.sgc.model.Presenca;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresencaRequestCreateDto {

    private Long cursoId;
    private String crachaFuncionario;

    public Presenca toModel() {
        Presenca presenca = new Presenca();
        // Aqui você pode popular o modelo de Presença, caso necessário.
        // A lógica completa para registrar a presença estará no serviço.
        return presenca;
    }
}
