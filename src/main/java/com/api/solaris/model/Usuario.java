package com.api.solaris.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    protected Set<Role> roles = new HashSet<>();
}