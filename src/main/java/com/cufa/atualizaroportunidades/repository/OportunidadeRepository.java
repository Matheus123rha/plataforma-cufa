package com.cufa.atualizaroportunidades.repository;

import com.cufa.atualizaroportunidades.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}