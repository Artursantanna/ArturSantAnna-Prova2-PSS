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
public abstract class DatabaseSolicitacao {

    

    public abstract boolean adicionarSolicitacao(Solicitacao solicitacao);

    public abstract boolean removerSolicitacao(Solicitacao solicitacao);

    public abstract Solicitacao getSolicitacao(int codeSolicitacao);

    public abstract void imprimeTudo();

    public abstract int getNumeroSolicitacoes();

    public abstract ArrayList<Solicitacao> getSolicitacoes();

}
