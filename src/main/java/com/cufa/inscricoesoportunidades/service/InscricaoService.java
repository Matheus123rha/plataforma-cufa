package com.cufa.inscricoesoportunidades.service;

import com.cufa.inscricoesoportunidades.model.Inscricao;
import com.cufa.inscricoesoportunidades.model.Oportunidade;
import com.cufa.inscricoesoportunidades.repository.InscricaoRepository;
import com.cufa.inscricoesoportunidades.repository.OportunidadeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final OportunidadeRepository oportunidadeRepository;

    public InscricaoService(
            InscricaoRepository inscricaoRepository,
            OportunidadeRepository oportunidadeRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.oportunidadeRepository = oportunidadeRepository;
    }

    public Inscricao realizarInscricao(Long oportunidadeId, String nomeParticipante) {

        Oportunidade oportunidade = oportunidadeRepository.findById(oportunidadeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Oportunidade não encontrada"));

        if (inscricaoRepository.existsByOportunidadeIdAndNomeParticipante(
                oportunidadeId, nomeParticipante)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Participante já inscrito nesta oportunidade");
        }

        long inscricoesRealizadas =
                inscricaoRepository.countByOportunidadeId(oportunidadeId);

        if (inscricoesRealizadas >= oportunidade.getQuantidadeVagas()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Não há vagas disponíveis");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setNomeParticipante(nomeParticipante);
        inscricao.setOportunidade(oportunidade);

        return inscricaoRepository.save(inscricao);
    }
}