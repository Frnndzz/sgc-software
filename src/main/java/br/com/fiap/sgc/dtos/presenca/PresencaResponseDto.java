package br.com.fiap.sgc.dtos;

import br.com.fiap.sgc.model.Presenca;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PresencaResponseDto {

    private Long id;
    private String funcionarioNome;
    private String cursoNome;
    private LocalDateTime dataPresenca;

    public PresencaResponseDto toDto(Presenca presenca) {
        this.id = presenca.getId();
        this.funcionarioNome = presenca.getFuncionario().getNome();
        this.cursoNome = presenca.getCurso().getNome();
        this.dataPresenca = presenca.getDataPresenca();
        return this;
    }
}
