package com.api.solaris.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrcamentoDTO {
    private long id;
    private double custo;
    private double potenciaInversor;
    private String tipoFase;
    private int qtdModulos;
    private int consumoCliente;
    private LocalDate dataSolicitacao;
}
