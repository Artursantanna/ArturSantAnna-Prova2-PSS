/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import business.ArrayListSolicitacao;

/**
 *
 * @author artur
 */
public class Solicitacao {

    private int indentificador;
    private final String nomeUsuario;
    private final int numeroFoto;

    ArrayListSolicitacao listaSolicitacoes = ArrayListSolicitacao.getInstance();

    public Solicitacao(String nomeUsuario, int numeroFoto) {
        this.nomeUsuario = nomeUsuario;
        this.numeroFoto = numeroFoto;
        this.setIndentificador(listaSolicitacoes);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getNumeroFoto() {
        return numeroFoto;
    }

    public int getIndentificador() {
        return indentificador;
    }

    private void setIndentificador(ArrayListSolicitacao data) {
        int keyCode = data.getUltimoCodigo();
        keyCode++;
        this.indentificador = keyCode;
    }

}
