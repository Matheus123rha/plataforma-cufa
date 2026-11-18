package com.cufa.inscricoesoportunidades.repository;

import com.cufa.inscricoesoportunidades.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    long countByOportunidadeId(Long oportunidadeId);

    boolean existsByOportunidadeIdAndNomeParticipante(
            Long oportunidadeId, String nomeParticipante);
}