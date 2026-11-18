package com.cufa.cadastrofacil.service;

import com.cufa.cadastrofacil.model.Oportunidade;
import com.cufa.cadastrofacil.repository.OportunidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class OportunidadeService {

    private final OportunidadeRepository repository;

    public OportunidadeService(OportunidadeRepository repository) {
        this.repository = repository;
    }

    public Oportunidade salvar(Oportunidade oportunidade) {
        return repository.save(oportunidade);
        
    }

    public java.util.List<Oportunidade> listarTodas() {
    return repository.findAll();
}
}