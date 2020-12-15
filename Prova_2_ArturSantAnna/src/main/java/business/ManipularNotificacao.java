/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Notificacao;
import model.Usuario;
import presenter.vernotificacao.PresenterVerNotificacao;
import view.vernotificacoes.VerNotificacaoView;

/**
 *
 * @author artur
 */
public class ManipularNotificacao {

    public void exibir(VerNotificacaoView notificacao, Usuario usuarioLogado) {

        DefaultTableModel model = (DefaultTableModel) notificacao.getTableNotificacao().getModel();

        ArrayList<Notificacao> notificacoes = ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getNotificacoes();

        int contador = 0;
        for (Notificacao usuarioNotificacao : notificacoes) {
            model.setRowCount(model.getRowCount() + 1);
            notificacao.getTableNotificacao().setValueAt(usuarioNotificacao.getNomeUsuario(), contador, 0);
            notificacao.getTableNotificacao().setValueAt(usuarioNotificacao.getDescricao(), contador, 1);
            contador++;
        }
    }

    public void removerTodas(VerNotificacaoView notificacao, Usuario usuarioLogado) {
        ArrayList<Notificacao> notificacoes = ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getNotificacoes();
        ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getNotificacoes().removeAll(notificacoes);
        notificacao.dispose();
        new PresenterVerNotificacao().inicial(usuarioLogado);
    }

}
