/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.vernotificacao;

import business.ManipularNotificacao;
import java.awt.event.ActionEvent;
import model.Usuario;
import view.vernotificacoes.VerNotificacaoView;

/**
 *
 * @author artur
 */
public class PresenterVerNotificacao {

    VerNotificacaoView notificacao = new VerNotificacaoView();

    public void inicial(Usuario usuarioLogado) {
        notificacao.setVisible(true);
        
        new ManipularNotificacao().exibir(notificacao, usuarioLogado);
        
        notificacao.getApagarNotificações().addActionListener((ActionEvent e) -> {
            new ManipularNotificacao().removerTodas(notificacao, usuarioLogado);
        });

    }

}
