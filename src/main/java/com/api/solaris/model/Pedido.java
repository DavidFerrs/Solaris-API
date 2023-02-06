package com.api.solaris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean pedidoGerado;

    private Long orcamentoId;

    public Pedido(String nomeCliente, LocalDate dataSolicitacao, double custoTotal, String status, String tipoMedia, double mediaConsumo, String tipoFase, int taxaDeRetorno, double economiaMensal, double economiaAnual, double potenciaInversor, int qtdModulos, Long orcamentoId) {
        this.nomeCliente = nomeCliente;
        this.dataSolicitacao = dataSolicitacao;
        this.custoTotal = custoTotal;
        this.status = status;
        this.tipoMedia = tipoMedia;
        this.mediaConsumo = mediaConsumo;
        this.tipoFase = tipoFase;
        this.taxaDeRetorno = taxaDeRetorno;
        this.economiaMensal = economiaMensal;
        this.economiaAnual = economiaAnual;
        this.potenciaInversor = potenciaInversor;
        this.qtdModulos = qtdModulos;
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

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public String getTipoMedia() {
        return tipoMedia;
    }

    public void setTipoMedia(String tipoMedia) {
        this.tipoMedia = tipoMedia;
    }

    public double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    public String getTipoFase() {
        return tipoFase;
    }

    public void setTipoFase(String tipoFase) {
        this.tipoFase = tipoFase;
    }

    public int getTaxaDeRetorno() {
        return taxaDeRetorno;
    }

    public void setTaxaDeRetorno(int taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getEconomiaMensal() {
        return economiaMensal;
    }

    public void setEconomiaMensal(double economiaMensal) {
        this.economiaMensal = economiaMensal;
    }

    public double getEconomiaAnual() {
        return economiaAnual;
    }

    public void setEconomiaAnual(double economiaAnual) {
        this.economiaAnual = economiaAnual;
    }

    public double getPotenciaInversor() {
        return potenciaInversor;
    }

    public void setPotenciaInversor(double potenciaInversor) {
        this.potenciaInversor = potenciaInversor;
    }

    public int getQtdModulos() {
        return qtdModulos;
    }

    public void setQtdModulos(int qtdModulos) {
        this.qtdModulos = qtdModulos;
    }

    public boolean isPedidoGerado() {
        return pedidoGerado;
    }

    public void setPedidoGerado(boolean pedidoGerado) {
        this.pedidoGerado = pedidoGerado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
