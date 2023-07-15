
package classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class Produto {
    
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Categoria categoria;
    private Integer quantidade;
    private Usuario usuario;
    private LocalDateTime dataHoraCriaco;
    private String categoriaNome;
    private String quantidadeTexto;
    private String categoriaTexto;
    private String dataHora;
    

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, Categoria categoria, Integer quantidade, Usuario usuario, LocalDateTime dataHoraCriaco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.dataHoraCriaco = dataHoraCriaco;
    }
    
    public Produto(String nome, String descricao, String categoria, Integer quantidade, BigDecimal preco){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaNome = categoria;
        this.quantidade = quantidade;
        
    }
    
    public Produto(String nome, String descricao, String categoriaTexto, Integer quantidade, BigDecimal preco, String dataHora){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaTexto = categoriaTexto;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getCategoriaTexto() {
        return categoriaTexto;
    }

    public void setCategoriaTexto(String categoriaTexto) {
        this.categoriaTexto = categoriaTexto;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoriaNome;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setCategoria(String categoriaTexto) {
        this.categoriaTexto = categoriaTexto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraCriaco() {
        return dataHoraCriaco;
    }

    public void setDataHoraCriaco(LocalDateTime dataHoraCriaco) {
        this.dataHoraCriaco = dataHoraCriaco;
    }
    
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria + ", quantidade=" + quantidade + ", usuario=" + usuario + ", dataHoraCriaco=" + dataHoraCriaco + '}';
    }
    
    
}
