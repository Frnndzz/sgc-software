package br.com.fiap.sgc.dtos.curso;

import br.com.fiap.sgc.model.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import br.com.fiap.sgc.model.Curso;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CursoRequestCreateDto {

    private String nome;
    private String descricao;
    private int qtdAulas;
    private List<Funcionario> funcionarios;


    private static final ModelMapper modelMapper = new ModelMapper();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso toModel() {
        return modelMapper.map(this, Curso.class);
    }

}
