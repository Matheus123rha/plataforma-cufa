package com.cufa.inscricoes.repository;

import com.cufa.inscricoes.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    boolean existsByParticipanteIdAndOportunidadeId(
            Long participanteId,
            Long oportunidadeId
    );

    long countByOportunidadeId(Long oportunidadeId);
}