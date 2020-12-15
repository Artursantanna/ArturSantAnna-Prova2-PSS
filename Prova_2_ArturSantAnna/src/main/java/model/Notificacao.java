/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author artur
 */
public class Notificacao {
    
    private final String nomeUsuario;
    private final String descricao;

    public Notificacao(String nomeUsuario, String descricao) {
        this.nomeUsuario = nomeUsuario;
        this.descricao = descricao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getDescricao() {
        return descricao;
    }  
    
}
