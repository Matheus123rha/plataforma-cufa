package br.com.cufaesteio.consultaoportunidades;

import br.com.cufaesteio.consultaoportunidades.entity.Oportunidade;
import br.com.cufaesteio.consultaoportunidades.repository.OportunidadeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadosIniciais {

    @Bean
    CommandLineRunner inserirDados(OportunidadeRepository repository) {
        return args -> {
            repository.save(new Oportunidade(null, "Desenvolvedor Backend Jr",
                    "Vaga para atuar com Java e Spring Boot", "Acme"));

            repository.save(new Oportunidade(null, "Analista de Dados",
                    "Vaga para trabalhar com SQL e Python", "Beta Tech"));

            repository.save(new Oportunidade(null, "Estagiário de Suporte",
                    "Atendimento e suporte técnico", "Gama Sistemas"));
        };
    }
}
