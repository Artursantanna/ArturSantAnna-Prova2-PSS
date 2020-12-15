/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.manterusuario.criarusuario;

import business.ArrayListUsuario;
import business.CriarUsuario;
import java.awt.event.ActionEvent;
import model.Usuario;
import presenter.manterusuario.PresenterManterUsuario;
import view.manterusuario.criarusuario.CriarUsuarioView;

/**
 *
 * @author artur
 */
public class PresenterCriarUsuario {

    CriarUsuarioView criarUsuario = new CriarUsuarioView();

    public void inicial(Usuario usuarioLogado) {
        criarUsuario.setVisible(true);

        criarUsuario.getBotaoCriarUsuario().addActionListener((ActionEvent e) -> {
            new CriarUsuario().criarUsuario(criarUsuario, ArrayListUsuario.getInstance(), usuarioLogado);
        });

        criarUsuario.getBotaoCancelar().addActionListener((ActionEvent e) -> {
            new PresenterManterUsuario().resetar(usuarioLogado);
            criarUsuario.dispose();
        });

    }

}
