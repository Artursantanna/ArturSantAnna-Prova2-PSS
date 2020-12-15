/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Usuario;
import presenter.compartilhar.PresenterCompartilhar;

/**
 *
 * @author artur
 */
public class CompartilhaImagemAdministrador {

    public void compartilha(int numeroJButton, Usuario usuarioLogado) {
        if (numeroJButton != 0) {
            if (ArrayListImagem.getInstance().getImagem(numeroJButton) != null) {
                new PresenterCompartilhar().inicial(numeroJButton, usuarioLogado);
            }
        }
    }
}
