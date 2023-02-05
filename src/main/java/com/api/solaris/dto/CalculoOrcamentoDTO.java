package com.api.solaris.dto;

import lombok.Data;

@Data
public class CalculoOrcamentoDTO {
    private long id;
    private double economiaMensal;
    private double economiaAnual;
    private double potenciaInversor;
    private int qtdModulos;
    private int taxaDeRetorno;

//    public CalculoOrcamentoDTO(long id, double economiaMensal, double economiaAnual, double potenciaInversor, int qtdModulos) {
//        this.id = id;
//        this.economiaMensal = economiaMensal;
//        this.economiaAnual = economiaAnual;
//        this.potenciaInversor = potenciaInversor;
//        this.qtdModulos = qtdModulos;
//    }

//    public long getId() {
//        return id;
//    }
//
//    public double getEconomiaMensal() {
//        return economiaMensal;
//    }
//
//    public double getEconomiaAnual() {
//        return economiaAnual;
//    }
//
//    public double getPotenciaInversor() {
//        return potenciaInversor;
//    }
//
//    public int getQtdModulos() {
//        return qtdModulos;
//    }
}
