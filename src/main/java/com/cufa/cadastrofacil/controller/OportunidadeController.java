package com.cufa.cadastrofacil.controller;

import com.cufa.cadastrofacil.model.Oportunidade;
import com.cufa.cadastrofacil.service.OportunidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private final OportunidadeService service;

    public OportunidadeController(OportunidadeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Oportunidade criar(@RequestBody Oportunidade oportunidade) {
        return service.salvar(oportunidade);
        
    }

    @GetMapping
    public java.util.List<Oportunidade> listar() {
         return service.listarTodas();
     }
}