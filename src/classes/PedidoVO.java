package classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Thiago
 */
public class PedidoVO {    // Pedido onde fica o produto , como se fosse a prateleira em livros

    private Long id;
    private String nome;
    private String descricao;
    private ArrayList<ProdutoVO> produtos;
   

    public PedidoVO() {

    }

    public PedidoVO(Long id) {
        this.id = id;
        this.descricao = descricao;
        produtos = new ArrayList<ProdutoVO>();
    }
    
    

    public PedidoVO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        produtos = new ArrayList<ProdutoVO>();
    }

    public PedidoVO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        produtos = new ArrayList<ProdutoVO>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ArrayList<ProdutoVO> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoVO> produtos) {
        this.produtos = produtos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int adicionarProdutoVO(ProdutoVO produto) {
        produtos.add(produto);
        return 1;
    }

    public int removerProduto(ProdutoVO produto) {
        int contador = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                if (produtos.remove(produtos.get(i))) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public ProdutoVO pesquisar(long id) {

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                return produtos.get(i);
            }
        }
       return null;
    }

    public int atualizar(ProdutoVO produto) {
        ProdutoVO temp = null;
        int numeroRegistrosAlterados = 0;
        for (int i = 0; i < produtos.size(); i++) {
            temp = produtos.get(i);
            if (temp.getId() == produto.getId()) {
                temp.setNomeProduto(produto.getNomeProduto());
                temp.setDescricaoProduto(descricao);
                temp.setPreco(produto.getPreco());
                temp.setQuantidade(i);
                temp.setDataHoraCriacao(LocalTime.MIN);
                numeroRegistrosAlterados = 1;
            }
        }
        return numeroRegistrosAlterados;
    }

    public void imprimirProdutos() {

        ProdutoVO temp = null;
        System.out.println("Produto do Gerenciajo: " + id + "descricao: " + descricao);
        for (int i = 0; i < produtos.size(); i++) {
            temp = produtos.get(i);
            System.out.println(temp.toString());
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.descricao);
        hash = 19 * hash + Objects.hashCode(this.produtos);
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
        final PedidoVO other = (PedidoVO) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.produtos, other.produtos);
    }
    


    @Override
    public String toString() {
        return "PedidoVO{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", produtos=" + produtos + '}';
    }
    

}
