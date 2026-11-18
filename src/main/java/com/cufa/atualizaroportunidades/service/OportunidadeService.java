package com.cufa.atualizaroportunidades.service;

import com.cufa.atualizaroportunidades.model.Oportunidade;
import com.cufa.atualizaroportunidades.repository.OportunidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OportunidadeService {

    private final OportunidadeRepository repository;

    public OportunidadeService(OportunidadeRepository repository) {
        this.repository = repository;
    }

    public Oportunidade cadastrar(Oportunidade oportunidade) {
        return repository.save(oportunidade);
    }

    public Oportunidade atualizar(Long id, Oportunidade dadosAtualizados) {
        Optional<Oportunidade> oportunidadeExistente = repository.findById(id);

        if (oportunidadeExistente.isEmpty()) {
            return null;
        }

        Oportunidade oportunidade = oportunidadeExistente.get();

        oportunidade.setTitulo(dadosAtualizados.getTitulo());
        oportunidade.setDescricao(dadosAtualizados.getDescricao());
        oportunidade.setModalidade(dadosAtualizados.getModalidade());
        oportunidade.setLocal(dadosAtualizados.getLocal());
        oportunidade.setDataInicio(dadosAtualizados.getDataInicio());
        oportunidade.setDataFim(dadosAtualizados.getDataFim());
        oportunidade.setPublicoAlvo(dadosAtualizados.getPublicoAlvo());
        oportunidade.setQuantidadeVagas(dadosAtualizados.getQuantidadeVagas());

        return repository.save(oportunidade);
    }
}