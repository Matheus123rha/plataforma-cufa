package com.cufa.atualizaroportunidades.controller;

import com.cufa.atualizaroportunidades.model.Oportunidade;
import com.cufa.atualizaroportunidades.service.OportunidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private final OportunidadeService service;

    public OportunidadeController(OportunidadeService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public Oportunidade atualizar(
            @PathVariable Long id,
            @RequestBody Oportunidade dadosAtualizados) {

        Oportunidade oportunidade = service.atualizar(id, dadosAtualizados);

        if (oportunidade == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Oportunidade não encontrada");
        }

        return oportunidade;
    }

    @PostMapping
    public Oportunidade cadastrar(@RequestBody Oportunidade oportunidade) {
    return service.cadastrar(oportunidade);
}

}