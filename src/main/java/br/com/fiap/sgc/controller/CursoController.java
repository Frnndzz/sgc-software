package br.com.fiap.sgc.controller;

import br.com.fiap.sgc.dtos.curso.CursoRequestCreateDto;
import br.com.fiap.sgc.dtos.curso.CursoResponseDto;
import br.com.fiap.sgc.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> list() {
        List<CursoResponseDto> dtos = cursoService.listarCursos()
                .stream()
                .map(e -> new CursoResponseDto().toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity<CursoResponseDto> create(@RequestBody CursoRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new CursoResponseDto().toDto(
                                cursoService.cadastrarCurso(dto.toModel()))
                );
    }
}
