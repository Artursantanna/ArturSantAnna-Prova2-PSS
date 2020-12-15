/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.Imagem;
import model.Usuario;
import view.telainicial.ITelaInicial;

/**
 *
 * @author artur
 */
public class ExibiImagens {

    public void exibir(ITelaInicial telaInicial, Usuario usuarioLogado) {
        colocarImagem(1, telaInicial.getjLabelFoto1());
        colocarImagem(2, telaInicial.getjLabelFoto2());
        colocarImagem(3, telaInicial.getjLabelFoto3());
        colocarImagem(4, telaInicial.getjLabelFoto4());
        colocarImagem(5, telaInicial.getjLabelFoto5());
        colocarImagem(6, telaInicial.getjLabelFoto6());
        colocarImagem(7, telaInicial.getjLabelFoto7());
        colocarImagem(8, telaInicial.getjLabelFoto8());
    }

    private void colocarImagem(int numeroImagem, JButton labelImagem) {

        if (ArrayListImagem.getInstance().getNumeroImagems() == 0) {

        } else {
            if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                Imagem miniatura = ArrayListImagem.getInstance().getImagem(numeroImagem);
                File fileArquivo = miniatura.getArquivo();
                BufferedImage imagemBuffer = miniatura.getImagemMiniatura();
                labelImagem.setIcon(new ImageIcon(imagemBuffer));
            }
        }
    }

}
