package com.api.solaris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(cascade = {CascadeType.ALL})
//    private Orcamento orcamento;

    private String nomeCliente;

    private LocalDate dataSolicitacao;

    private double custoTotal;

    private String status;

    private Long orcamentoId;

    public Pedido(String nomeCliente, LocalDate dataSolicitacao, double custoTotal, String status, Long orcamentoId) {
        this.nomeCliente = nomeCliente;
        this.dataSolicitacao = dataSolicitacao;
        this.custoTotal = custoTotal;
        this.status = status;
        this.orcamentoId = orcamentoId;
    }

    public long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public Long getOrcamentoId() {
        return orcamentoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
