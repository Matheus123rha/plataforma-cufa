package com.cufa.inscricoes.service;

import com.cufa.inscricoes.dto.InscricaoRequestDTO;
import com.cufa.inscricoes.model.Inscricao;
import com.cufa.inscricoes.model.Oportunidade;
import com.cufa.inscricoes.model.Participante;
import com.cufa.inscricoes.repository.InscricaoRepository;
import com.cufa.inscricoes.repository.OportunidadeRepository;
import com.cufa.inscricoes.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscricaoService {

    private final ParticipanteRepository participanteRepository;
    private final OportunidadeRepository oportunidadeRepository;
    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(
            ParticipanteRepository participanteRepository,
            OportunidadeRepository oportunidadeRepository,
            InscricaoRepository inscricaoRepository) {

        this.participanteRepository = participanteRepository;
        this.oportunidadeRepository = oportunidadeRepository;
        this.inscricaoRepository = inscricaoRepository;
    }

    @Transactional
    public Inscricao criarInscricao(InscricaoRequestDTO dto) {

        Participante participante = participanteRepository.findByCpf(dto.cpf())
                .orElseGet(() -> participanteRepository.save(
                        new Participante(
                                dto.nome(),
                                dto.cpf(),
                                dto.email(),
                                dto.telefone()
                        )
                ));

        Oportunidade oportunidade = oportunidadeRepository.findById(dto.oportunidadeId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Oportunidade não encontrada."
                ));

        if (inscricaoRepository.existsByParticipanteIdAndOportunidadeId(
                participante.getId(), oportunidade.getId())) {
            throw new IllegalStateException("Participante já inscrito nesta oportunidade.");
        }

        if (inscricaoRepository.countByOportunidadeId(oportunidade.getId())
                >= oportunidade.getQuantidadeVagas()) {
            throw new IllegalStateException("Não há vagas disponíveis.");
        }

        return inscricaoRepository.save(
                new Inscricao(participante, oportunidade)
        );
    }
}