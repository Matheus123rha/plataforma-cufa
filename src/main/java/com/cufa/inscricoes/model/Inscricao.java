package com.cufa.inscricoes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "oportunidade_id")
    private Oportunidade oportunidade;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataInscricao;

    protected Inscricao() {
    }

    public Inscricao(Participante participante, Oportunidade oportunidade) {
        this.participante = participante;
        this.oportunidade = oportunidade;
    }

    @PrePersist
    void aoCriar() {
        this.dataInscricao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Oportunidade getOportunidade() {
        return oportunidade;
    }

    public LocalDateTime getDataInscricao() {
        return dataInscricao;
    }
}