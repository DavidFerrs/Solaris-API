package com.api.solaris.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@MappedSuperclass
public abstract class Usuario {

    @NotNull
    @Column(unique = true)
    protected String nome;

    @NotNull
    @Column(unique = true)
    protected String login;

    protected int tipo;

    @ElementCollection
    protected List<String> roles;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;

}