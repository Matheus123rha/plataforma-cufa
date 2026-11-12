package br.com.cufaesteio.consultaoportunidades.controller;

import br.com.cufaesteio.consultaoportunidades.entity.Oportunidade;
import br.com.cufaesteio.consultaoportunidades.repository.OportunidadeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private final OportunidadeRepository oportunidadeRepository;

    public OportunidadeController(OportunidadeRepository oportunidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
    }

    @GetMapping
    public List<Oportunidade> listarTodas() {
        return oportunidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> buscarPorId(@PathVariable Long id) {
        return oportunidadeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

