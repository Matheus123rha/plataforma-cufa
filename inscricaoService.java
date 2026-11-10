package com.cufa.incricoes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@servece
public class InscricaoService {

    private final ParticipanteRepository participanteRepository;

    public InscricaoService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    @Transactional
    public void criarInscricao(Long oportunidadeId, InscricaoRequestDTO dto) {
        paarticipanteRepository.findByCpf(dto.cpf())
        .orElseGet(() -> {
            Partecipante novo = new Partecipante(dto.nome(), dto.cpf(), dto.email(), dto.telefone());
            return participanteRepository.save(novo);
        })
    }
