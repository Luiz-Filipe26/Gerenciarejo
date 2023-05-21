package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Thiago
 */
public class Produto {
    
    private Long id;
    private String nomeProduto;
    private String descricaoProduto;
    private BigDecimal preco;
    private Integer quantidade;
    private Categoria categoria;
    private Usuario usuario;
    private LocalDateTime dataHoraCriacao;

    public Produto() {
    }

    public Produto(Long id, String nomeProduto, String descricaoProduto, BigDecimal preco, Integer quantidade, Categoria categoria, Usuario usuario, LocalDateTime dataHoraCriacao) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.usuario = usuario;
        this.dataHoraCriacao = dataHoraCriacao;
    }
    
    public Produto(String nomeProduto, String descricaoProduto, double preco, Integer quantidade, Categoria categoria, Usuario usuario) {
        
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.usuario = usuario;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
    
    
 

    
}
