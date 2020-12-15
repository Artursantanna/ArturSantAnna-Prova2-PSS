/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;
import presenter.telaprincipalusuario.PresenterTelaPrincipalUsuario;
import view.telainicial.ITelaInicial;

/**
 *
 * @author artur
 */
public class RemoveImagemUsuario {

    public void remove(int numeroJButton, ITelaInicial telaInicial, Usuario usuarioLogado) {
        ArrayList<Imagem> imagensPermitidas = ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getFotosPermitidas();
        if (numeroJButton != 0) {
            if (ArrayListImagem.getInstance().getImagem(numeroJButton) != null) {
                if (imagensPermitidas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Você não possui acesso");
                } else {
                    for (Imagem imagemPermitida : imagensPermitidas) {
                        if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroJButton).getCodigo()) {
                            JOptionPane.showMessageDialog(null, "Você não possui acesso");
                        } else {
                            ArrayListImagem.getInstance().getImagem(numeroJButton).getArquivo().delete();
                            ArrayListImagem.getInstance().getImagem(numeroJButton).getArquivoMiniatura().delete();
                            //new TratadorDePermissoes().removeDeTodos();
                            ArrayListImagem.getInstance().removerImagem(ArrayListImagem.getInstance().getImagem(numeroJButton));
                            JOptionPane.showMessageDialog(null, "Imagem Removida.");
                            telaInicial.desligaTela();
                            new PresenterTelaPrincipalUsuario().inicial(usuarioLogado);
                        }
                    }
                }
            }
        }
    }
}
