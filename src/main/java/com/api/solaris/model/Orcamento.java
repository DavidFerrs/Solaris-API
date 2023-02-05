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

    private String tipoMedia;
    private double mediaConsumo;
    private String tipoFase;

    private int taxaDeRetorno;
    private double economiaMensal;
    private double economiaAnual;
    private double potenciaInversor;
    private int qtdModulos;

    private double custo;
    private LocalDate dataSolicitacao;

    public Orcamento(String tipoMedia, int taxaDeRetorno, double mediaConsumo, String tipoFase, double economiaMensal, double economiaAnual, double potenciaInversor, int qtdModulos, double custo, LocalDate dataSolicitacao) {
        this.tipoMedia = tipoMedia;
        this.mediaConsumo = mediaConsumo;
        this.tipoFase = tipoFase;
        this.economiaMensal = economiaMensal;
        this.economiaAnual = economiaAnual;
        this.potenciaInversor = potenciaInversor;
        this.qtdModulos = qtdModulos;
        this.custo = custo;
        this.taxaDeRetorno = taxaDeRetorno;
        this.dataSolicitacao = dataSolicitacao;
    }
}
