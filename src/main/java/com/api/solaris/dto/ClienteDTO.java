package com.api.solaris.dto;

import java.util.UUID;

public class ClienteDTO {

    private UUID id;

    private Long cpf;

    private String nome;

    private Integer idade;

    private String password;

//    private List<RoleDTO> roles;

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

    public String getPassword() {
        return password;
    }

//    public List<RoleDTO> getRoles() {
//        return roles;
//    }
}
