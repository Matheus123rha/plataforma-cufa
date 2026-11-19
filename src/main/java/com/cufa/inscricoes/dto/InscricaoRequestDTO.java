package com.cufa.inscricoes.dto;

public record InscricaoRequestDTO(
        String nome,
        String cpf,
        String email,
        String telefone,
        Long oportunidadeId
) {
}