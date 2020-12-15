/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.manterusuario.editarusuario;

import business.ArrayListUsuario;
import business.EditarUsuario;
import java.awt.event.ActionEvent;
import model.Usuario;
import presenter.manterusuario.PresenterManterUsuario;
import view.manterusuario.ManterUsuarioView;
import view.manterusuario.editarusuario.EditarUsuarioView;

/**
 *
 * @author artur
 */
public class PresenterEditarUsuario {

    EditarUsuarioView editarUsuario = new EditarUsuarioView();
    
    public void inicial(ManterUsuarioView manterUsuario, Usuario usuarioLogado) {
        editarUsuario.setVisible(true);        
        new EditarUsuario().exibirUsuario(editarUsuario, manterUsuario, ArrayListUsuario.getInstance());

        editarUsuario.getBotaoEditarUsuario().addActionListener((ActionEvent e) -> {
            new EditarUsuario().editarUsuario(editarUsuario, ArrayListUsuario.getInstance(), usuarioLogado);
        });

        editarUsuario.getBotaoCancelar().addActionListener((ActionEvent e) -> {
            new PresenterManterUsuario().resetar(usuarioLogado);
            editarUsuario.dispose();
        });

    }

}
