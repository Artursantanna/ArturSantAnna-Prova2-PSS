/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JOptionPane;
import model.Usuario;
import presenter.telaprincipaladministrador.PresenterTelaPrincipalAdministrador;
import view.telainicial.administrador.TelaInicialAdministrador;

/**
 *
 * @author artur
 */
public class RemoveImagemAdministrador {

    public void remove(int numeroJButton, TelaInicialAdministrador telaInicial, Usuario usuarioLogado) {
        if (numeroJButton != 0) {
            if (ArrayListImagem.getInstance().getImagem(numeroJButton) != null) {
                ArrayListImagem.getInstance().getImagem(numeroJButton).getArquivo().delete();
                ArrayListImagem.getInstance().getImagem(numeroJButton).getArquivoMiniatura().delete();
                //new TratadorDePermissoes().removeDeTodos();
                ArrayListImagem.getInstance().removerImagem(ArrayListImagem.getInstance().getImagem(numeroJButton));
                JOptionPane.showMessageDialog(null, "Imagem Removida.");
                telaInicial.desligaTela();
                new PresenterTelaPrincipalAdministrador().inicial(usuarioLogado);
            }
        }
    }

}
