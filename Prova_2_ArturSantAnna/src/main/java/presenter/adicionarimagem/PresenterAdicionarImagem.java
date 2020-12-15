/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.adicionarimagem;

import business.ManipularAdicionarImagem;
import business.MeiaImagem;
import java.awt.event.ActionEvent;
import model.Usuario;
import view.adicionarimagem.AdicionarImagemView;

/**
 *
 * @author artur
 */
public class PresenterAdicionarImagem {

    AdicionarImagemView enviarImagem = new AdicionarImagemView();
    
    MeiaImagem resultado;

    public void inicial(Usuario usuarioLogado) {
        enviarImagem.setVisible(true);

        enviarImagem.getSelecionarImagem().addActionListener((ActionEvent e) -> {
            resultado = new ManipularAdicionarImagem().selecionar(enviarImagem);
        });

        enviarImagem.getEnviar().addActionListener((ActionEvent e) -> {
            new ManipularAdicionarImagem().enviar(resultado, enviarImagem, usuarioLogado);
        });

        enviarImagem.getCancelar().addActionListener((ActionEvent e) -> {
            new ManipularAdicionarImagem().cancelar(enviarImagem, usuarioLogado);
        });
    }
}
