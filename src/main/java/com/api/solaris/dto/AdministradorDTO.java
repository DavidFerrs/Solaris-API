package com.api.solaris.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdministradorDTO {

    private Long id;

    private String nome;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

}
