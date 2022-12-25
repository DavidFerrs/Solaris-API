package com.api.solaris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String modelo;
    private String fabricante;
    private Double potencia;

    public Modulo(String modelo, String fabricate, Double potencia){
        this.fabricante = fabricate;
        this.potencia = potencia;
        this.modelo = modelo;
    }
}