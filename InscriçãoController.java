package com.cufa.inscricaoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oportunidades")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping("/{id}/inscricoes")
     public ResponseEntity<void> cadastrarInscricao(
         @PathVariable("id") Long oportunidadeId,
         @RequestBody InscricaoRequestDTO request) {
            inscricaoService.criarInscricao(oportunidadeId, request);

            return ResponseEntity.status(HttpStatus.CREATED).build();
         }
    
    }
