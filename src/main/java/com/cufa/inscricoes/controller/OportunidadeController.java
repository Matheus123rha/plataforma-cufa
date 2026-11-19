package com.cufa.inscricoes.controller;

import com.cufa.inscricoes.model.Oportunidade;
import com.cufa.inscricoes.repository.OportunidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private final OportunidadeRepository oportunidadeRepository;

    public OportunidadeController(OportunidadeRepository oportunidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
    }

    @PostMapping
    public ResponseEntity<Oportunidade> criar(
            @RequestBody Oportunidade oportunidade) {

        Oportunidade salva = oportunidadeRepository.save(oportunidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Oportunidade> listar() {
        return oportunidadeRepository.findAll();
    }
}