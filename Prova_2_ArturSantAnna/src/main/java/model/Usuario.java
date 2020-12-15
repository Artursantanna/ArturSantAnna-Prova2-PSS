/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import business.ArrayListUsuario;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class Usuario {
    
    private String nome;
    private String senha;
    private boolean administrador;
    ArrayList<Notificacao> notificacoes;
    ArrayList<Imagem> fotosPermitidas;
    
    ArrayListUsuario listaImagem = ArrayListUsuario.getInstance();

    public Usuario(String nome, String senha, boolean administrador) {
        this.nome = nome;
        this.senha = senha;
        this.administrador = administrador;
        this.notificacoes = new ArrayList<>();
        this.fotosPermitidas = new ArrayList<>();
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

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    public void addNotificacao(Notificacao notificacao){
        notificacoes.add(notificacao);
    }

    public ArrayList<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(ArrayList<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }
    
    public void zeraNotificacoes(){
        this.notificacoes.removeAll(notificacoes);
    }

    public ArrayList<Imagem> getFotosPermitidas() {
        return fotosPermitidas;
    }

    public void setFotosPermitidas(ArrayList<Imagem> fotosPermitidas) {
        this.fotosPermitidas = fotosPermitidas;
    }
    
    public void addFotosPermitidas(Imagem imagem){
        fotosPermitidas.add(imagem);
    }
}
