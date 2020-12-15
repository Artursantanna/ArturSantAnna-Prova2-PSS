/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.verificarsolicitacao;

import business.ManipularSolicitacao;
import java.awt.event.ActionEvent;
import view.verificarsolicitacao.VerificarSolicitacaoView;

/**
 *
 * @author artur
 */
public class PresenterVerificarSolicitacao {

    VerificarSolicitacaoView solicitacao = new VerificarSolicitacaoView();

    public void inicial() {
        solicitacao.setVisible(true);

        new ManipularSolicitacao().exibir(solicitacao);

        solicitacao.getAceitar().addActionListener((ActionEvent e) -> {
            new ManipularSolicitacao().aceitar(solicitacao);
        });

        solicitacao.getRecusar().addActionListener((ActionEvent e) -> {
            new ManipularSolicitacao().remover(solicitacao);
        });
    }
}
