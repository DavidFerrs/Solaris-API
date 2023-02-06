package com.api.solaris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inversor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String modelo;

    private String fabricante;

    private Double potencia;

    public Inversor(String modelo, String fabricante, Double potencia) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potencia = potencia;
    }
}
