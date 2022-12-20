package com.api.solaris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dataSolicitacao;
    private double custo;
    private double potenciaInversor;
    private String tipoFase;
    private int qtdModulos;
    private int consumoCliente;

    public Orcamento(double potenciaInversor, String tipoFase, int consumoCliente) {
        this.potenciaInversor = potenciaInversor;
        this.tipoFase = tipoFase;
        this.consumoCliente = consumoCliente;
        this.dataSolicitacao = LocalDate.now();
        this.qtdModulos = consumoCliente / 31;
    }

}
