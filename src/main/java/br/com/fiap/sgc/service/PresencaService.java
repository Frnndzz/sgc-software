package br.com.fiap.sgc.service;

import br.com.fiap.sgc.model.Curso;
import br.com.fiap.sgc.model.Funcionario;
import br.com.fiap.sgc.model.Presenca;
import br.com.fiap.sgc.repository.CursoRepository;
import br.com.fiap.sgc.repository.FuncionarioRepository;
import br.com.fiap.sgc.repository.PresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PresencaService {

    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Presenca registrarPresenca(Long cursoId, String crachaFuncionario) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Funcionario funcionario = funcionarioRepository.findByCracha(crachaFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Presenca presenca = new Presenca();
        presenca.setCurso(curso);
        presenca.setFuncionario(funcionario);
        presenca.setDataPresenca(LocalDateTime.now());

        return presencaRepository.save(presenca);
    }

    public List<Presenca> listarPresencas() {
        return presencaRepository.findAll();
    }
}
