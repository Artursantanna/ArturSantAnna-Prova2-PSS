/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.manterusuario;

import business.ArrayListUsuario;
import business.ExibirTableManterUsuario;
import business.RemoverUsuario;
import java.awt.event.ActionEvent;
import model.Usuario;
import presenter.manterusuario.criarusuario.PresenterCriarUsuario;
import presenter.manterusuario.editarusuario.PresenterEditarUsuario;
import view.manterusuario.ManterUsuarioView;

/**
 *
 * @author artur
 */
public class PresenterManterUsuario {

    ManterUsuarioView manterUsuario = new ManterUsuarioView();
    int cont = 0;

    public void inicial(Usuario usuarioLogado) {
        manterUsuario.setVisible(true);
        new ExibirTableManterUsuario().exibir(manterUsuario, usuarioLogado);

        manterUsuario.getBotaoCriar().addActionListener((ActionEvent e) -> {
            new PresenterCriarUsuario().inicial(usuarioLogado);
            manterUsuario.dispose();
        });

        manterUsuario.getBotaoRemover().addActionListener((ActionEvent e) -> {
            new RemoverUsuario().removerUsuario(manterUsuario, ArrayListUsuario.getInstance());
            manterUsuario.dispose();
            new PresenterManterUsuario().inicial(usuarioLogado);
        });

        manterUsuario.getBotaoEditar().addActionListener((ActionEvent e) -> {
            new PresenterEditarUsuario().inicial(manterUsuario, usuarioLogado);
            manterUsuario.dispose();
        });

    }

    public void resetar(Usuario usuarioLogado) {
        ManterUsuarioView manterUsuarioResetar = new ManterUsuarioView();
        new PresenterManterUsuario().inicial(usuarioLogado);
    }

}
