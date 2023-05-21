
package models;

import java.time.LocalDateTime;
import java.util.Date;


//Essa classe vai controlar os usuarios, onde será criado os usuarios pela interface (view)

public class Usuario {
    
    private long id;
    private String nome;
    private String senha;
    private String usuario;
    private Perfil perfil;
    private boolean estado;
    private LocalDateTime dataHoraCricao;
    private LocalDateTime ultimoLogin;
    
    //Estado caso queria desabilitar aquele usuário
    public Usuario(){
        this.estado = true;
    }

    public Usuario(long id, String nome, String senha, String usuario, Perfil perfil, LocalDateTime dataHoraCricao, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.perfil = perfil;
        this.dataHoraCricao = dataHoraCricao;
        this.ultimoLogin = ultimoLogin;
        this.estado = true;
    }

  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataHoraCricao() {
        return dataHoraCricao;
    }

    public void setDataHoraCricao(LocalDateTime dataHoraCricao) {
        this.dataHoraCricao = dataHoraCricao;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }
    
    
    //Caso depois queira passar isso para interface para implementar visualmente
    public void reset(){
        this.estado = true;
    }
    
    public void mudarEstado(){
        this.estado = !true;
    }
    
    
}
  
