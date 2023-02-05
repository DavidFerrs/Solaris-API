package com.api.solaris.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Data
public class ClienteDTO {

    private UUID id;

    private String nome;

    private String tipo;

    private Long cpfCnpj;

    private Long cep;

    private String endereco;

    private String numero;

    private String cidade;

    private String estado;

    private String email;

    private String complemento;

    private String senha;

    private String celular;


}
