package br.com.fiap.sgc.controller;

import br.com.fiap.sgc.dtos.presenca.PresencaRequestCreateDto;
import br.com.fiap.sgc.dtos.PresencaResponseDto;
import br.com.fiap.sgc.service.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public ResponseEntity<List<PresencaResponseDto>> list() {
        List<PresencaResponseDto> dtos = presencaService.listarPresencas()
                .stream()
                .map(presenca -> new PresencaResponseDto().toDto(presenca))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/registrar")
    public ResponseEntity<PresencaResponseDto> create(@RequestBody PresencaRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new PresencaResponseDto().toDto(
                                presencaService.registrarPresenca(dto.toModel().getId(), dto.toModel().getFuncionario().getCracha()))
                );
    }
}
