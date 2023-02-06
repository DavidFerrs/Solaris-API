package com.api.solaris.dto;

import com.api.solaris.model.Orcamento;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDTO {
    private long id;

    private String nomeCliente;

    private LocalDate dataSolicitacao;

    private double custoTotal;

    private String status;

    private String tipoMedia;
    private double mediaConsumo;
    private String tipoFase;
    private int taxaDeRetorno;
    private double economiaMensal;
    private double economiaAnual;
    private double potenciaInversor;
    private int qtdModulos;

}
