
package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;



/**
 *
 * @author Thiago
 */
public class Venda {
    
    private Long id;
    private Cliente cliente;
    private Usuario usuario;
    private BigDecimal totalVenda;
    private BigDecimal valorPago;
    private BigDecimal desconto;
    private BigDecimal troco;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime ultimaAtualizacao;

    public Venda() {
    }

    public Venda(Long id, Cliente cliente, Usuario usuario, BigDecimal totalVenda, BigDecimal valorPago, BigDecimal desconto, BigDecimal troco, LocalDateTime dataHoraCriacao, LocalDateTime ultimaAtualizacao) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.totalVenda = totalVenda;
        this.valorPago = valorPago;
        this.desconto = desconto;
        this.troco = troco;
        this.dataHoraCriacao = dataHoraCriacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    
    
    
}
