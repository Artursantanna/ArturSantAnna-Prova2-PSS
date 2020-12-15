/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Solicitacao;

import java.util.ArrayList;
import model.Solicitacao;

/**
 *
 * @author artur
 */
public class SQLiteSolicitacao extends DatabaseSolicitacao{

    ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
    
    private static SQLiteSolicitacao _unicaInstancia;

    public static SQLiteSolicitacao getInstance() {
        if (_unicaInstancia == null) {
            _unicaInstancia = new SQLiteSolicitacao();
        }
        return _unicaInstancia;
    } //Aplicação do design pattern Singleton

    public SQLiteSolicitacao() {
    }

    @Override
    public boolean adicionarSolicitacao(Solicitacao solicitacao) {
        if (solicitacoes.add(solicitacao)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removerSolicitacao(Solicitacao solicitacao) {
        if (solicitacoes.remove(solicitacao)) {
            return true;
        }
        return false;
    }

    @Override
    public Solicitacao getSolicitacao(int indentificador) {
        Solicitacao a = null;
        for (Solicitacao solicitacao : solicitacoes) {
            if (solicitacao.getIndentificador() == indentificador) {
                a = solicitacao;
                break;
            }
        }
        return a;
    }

    @Override
    public void imprimeTudo() {
        solicitacoes.forEach(solicitacao -> {
            System.out.println(solicitacao.getIndentificador());
        });

    }

    @Override
    public int getNumeroSolicitacoes() {
        int numeroSolicitacoes = 0;
        for (Solicitacao solicitacao : solicitacoes) {
            numeroSolicitacoes++;
        }
        return numeroSolicitacoes;
    }

    @Override
    public ArrayList<Solicitacao> getSolicitacoes(){
        return solicitacoes;
    }

}
