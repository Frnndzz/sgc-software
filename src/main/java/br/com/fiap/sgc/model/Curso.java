package br.com.fiap.sgc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String descricao;

    @Column(nullable = false, length = 3)
    private int qtdAulas;

    @ManyToMany(mappedBy = "cursos")
    private List<Funcionario> funcionarios = new ArrayList<>();
}
