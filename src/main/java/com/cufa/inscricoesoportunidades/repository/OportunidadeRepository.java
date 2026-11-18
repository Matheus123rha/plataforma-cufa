package com.cufa.inscricoesoportunidades.repository;

import com.cufa.inscricoesoportunidades.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}
