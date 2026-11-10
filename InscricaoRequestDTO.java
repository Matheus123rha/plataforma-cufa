package com.cufa.inscricoes;

public record InscricaoRequestDTO(
        String nome,
        String cpf,
        String email,
        String telefone
) {}