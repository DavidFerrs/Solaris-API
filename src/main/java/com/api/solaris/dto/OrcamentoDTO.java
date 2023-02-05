package com.api.solaris.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrcamentoDTO {
    private long id;
    private String tipoMedia;
    private double mediaConsumo;
    private String tipoFase;
    private double economiaMensal;
    private double economiaAnual;
    private double potenciaInversor;
    private int qtdModulos;
    private double custo;
    private int taxaDeRetorno;
    private LocalDate dataSolicitacao;
}
