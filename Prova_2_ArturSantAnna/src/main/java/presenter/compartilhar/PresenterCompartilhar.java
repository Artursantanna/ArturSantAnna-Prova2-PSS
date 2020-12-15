/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.compartilhar;

import business.ManipularCompartilhar;
import java.awt.event.ActionEvent;
import model.Usuario;
import view.compartilhar.CompartilharView;

/**
 *
 * @author artur
 */
public class PresenterCompartilhar {

    CompartilharView compartilhar = new CompartilharView();
    
    public void inicial(int numeroImagem, Usuario usuarioLogado) {
        compartilhar.setVisible(true);
        
        new ManipularCompartilhar().exibir(compartilhar, numeroImagem, usuarioLogado);

        compartilhar.getCompartilhar().addActionListener((ActionEvent e) -> {
            new ManipularCompartilhar().compartilhar(compartilhar, numeroImagem);
        });
    }
}
