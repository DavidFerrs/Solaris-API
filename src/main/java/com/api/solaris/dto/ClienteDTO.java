package com.api.solaris.dto;

import java.util.UUID;

public class ClienteDTO {

    private UUID id;

    private Long cpf;

    private String nome;

    private Integer idade;

    public UUID getId() {
        return id;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

}
