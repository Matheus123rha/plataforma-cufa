package com.cufa.inscricoesoportunidades.controller;

import com.cufa.inscricoesoportunidades.model.Oportunidade;
import com.cufa.inscricoesoportunidades.repository.OportunidadeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private final OportunidadeRepository oportunidadeRepository;

    public OportunidadeController(OportunidadeRepository oportunidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
    }

    @PostMapping
    public ResponseEntity<Oportunidade> cadastrar(
            @RequestBody Oportunidade oportunidade) {

        Oportunidade salva = oportunidadeRepository.save(oportunidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}