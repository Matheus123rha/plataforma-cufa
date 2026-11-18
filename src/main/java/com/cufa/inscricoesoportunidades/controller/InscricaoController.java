package com.cufa.inscricoesoportunidades.controller;

import com.cufa.inscricoesoportunidades.model.Inscricao;
import com.cufa.inscricoesoportunidades.service.InscricaoService;

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

    @PostMapping("/{oportunidadeId}")
    public ResponseEntity<Inscricao> realizarInscricao(
            @PathVariable Long oportunidadeId,
            @RequestParam String nomeParticipante) {

        Inscricao inscricao = inscricaoService.realizarInscricao(
                oportunidadeId, nomeParticipante);

        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }
}