package com.cufa.inscricoes.controller;

import com.cufa.inscricoes.dto.InscricaoRequestDTO;
import com.cufa.inscricoes.model.Inscricao;
import com.cufa.inscricoes.service.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<Inscricao> criarInscricao(
            @RequestBody InscricaoRequestDTO request) {

        Inscricao inscricao = inscricaoService.criarInscricao(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }
}