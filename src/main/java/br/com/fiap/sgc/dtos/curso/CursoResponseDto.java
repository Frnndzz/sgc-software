package br.com.fiap.sgc.dtos.curso;

import br.com.fiap.sgc.model.Curso;
import br.com.fiap.sgc.model.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CursoResponseDto {

    private Long id;
    private String nome;
    private String descricao;
    private int qtdAulas;
    private List<Funcionario> funcionarios;


    private static final ModelMapper modelMapper = new ModelMapper();

    public CursoResponseDto toDto(Curso curso) {
        return modelMapper.map(curso, CursoResponseDto.class);
        
    }
}
