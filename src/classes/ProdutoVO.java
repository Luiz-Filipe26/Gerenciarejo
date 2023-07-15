package classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thiago
 */
public class ProdutoVO {

    private Long id;
    private String nomeProduto;
    private String descricaoProduto;
    private double preco;
    private int quantidade;
    private PedidoVO pedido;
    private Usuario usuario;
    private LocalTime dataHoraCriacao;
    


    public ProdutoVO() {

    }

    public ProdutoVO(Long id, String nomeProduto, String descricaoProduto, double preco, int quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    
    
    public ProdutoVO(Long id, String nomeProduto, String descricaoProduto, double preco, int quantidade, PedidoVO pedido, Usuario usuario, LocalTime dataHoraCriacao) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.usuario = usuario;
        this.dataHoraCriacao = dataHoraCriacao;
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


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoVO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoVO pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

  
    public LocalTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoVO other = (ProdutoVO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProdutoVO{" + "id=" + id + ", nomeProduto=" + nomeProduto + ", descricaoProduto=" + descricaoProduto + ", preco=" + preco + ", quantidade=" + quantidade + ", pedido=" + pedido + ", usuario=" + usuario + ", dataHoraCriacao=" + dataHoraCriacao + '}';
    }
    

    
    
    
}
