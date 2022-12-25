package com.api.solaris.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Cliente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cpf;

    @Setter
    private int idade;

    public Cliente(Long cpf, String nome, String login, int idade, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
        this.tipo = 1;
        this.senha = senha;
    }
}