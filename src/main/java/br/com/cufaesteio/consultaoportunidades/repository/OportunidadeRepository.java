package br.com.cufaesteio.consultaoportunidades.repository;

import br.com.cufaesteio.consultaoportunidades.entity.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
}

