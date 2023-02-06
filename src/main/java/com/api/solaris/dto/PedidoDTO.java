package com.api.solaris.dto;

import com.api.solaris.model.Orcamento;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDTO {
    private long id;
    private String Status;
    private long orcamentoId;
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
    private String nomeCliente;
    private boolean pedidoGerado;
    private OrcamentoDTO orcamento;
}
