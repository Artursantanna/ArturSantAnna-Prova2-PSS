/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.imagemaberta;

import business.ArrayListImagem;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Imagem;
import view.imagemaberta.ImagemAbertaView;

/**
 *
 * @author artur
 */
public class PresenterImagemAberta {

    ImagemAbertaView telaInicial = new ImagemAbertaView();

    public void inicial(int numeroImagem) {
        telaInicial.setVisible(true);
        System.out.println("PRESENTER IMAGEM ABERTA numeroImagem" + numeroImagem);
        this.colocarImagem(numeroImagem, telaInicial.getLabelImagem());
    }

    private void colocarImagem(int numeroImagem, JLabel labelImagem) {
        System.out.println("COLOCA IMAGEM chamada");
        if (ArrayListImagem.getInstance().getNumeroImagems() == 0) {

        } else {
            if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                Imagem miniatura = ArrayListImagem.getInstance().getImagem(numeroImagem);
                File fileArquivo = miniatura.getArquivo();
                BufferedImage imagemBuffer = miniatura.getImagem();
                labelImagem.setIcon(new ImageIcon(imagemBuffer));
                System.out.println("COLOCA IMAGEM if");
            }
        }
    }

}
