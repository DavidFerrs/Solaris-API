package com.api.solaris.dto;

import com.api.solaris.model.Orcamento;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDTO {
    private Long id;
    private String nomeCliente;

    private LocalDate dataSolicitacao;

    private double custoTotal;

    private String status;

    private Long orcamentoId;

//    private double mediaConsumo;
//    private String tipoFase;
//    private double economiaMensal;
//    private double economiaAnual;
//    private double potenciaInversor;
//    private int qtdModulos;
//    private int taxaDeRetorno;
//    private LocalDate dataSolicitacao;
//    private String nomeCliente;
//    private boolean pedidoGerado;
//    private OrcamentoDTO orcamento;
}
