package com.cufa.cadastrofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cufa")
@EntityScan(basePackages = "com.cufa")
@EnableJpaRepositories(basePackages = "com.cufa")
public class CadastroFacilApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastroFacilApplication.class, args);
    }
}