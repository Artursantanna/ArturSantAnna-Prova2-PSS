/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author artur
 */
public class MeiaImagem {

    private BufferedImage imagem;
    private BufferedImage imagemMiniatura;
    private File arquivo;

    public MeiaImagem(BufferedImage imagem, BufferedImage imagemMiniatura) {
        this.imagem = imagem;
        this.imagemMiniatura = imagemMiniatura;
        this.arquivo = null;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public BufferedImage getImagemMiniatura() {
        return imagemMiniatura;
    }

    public void setImagemMiniatura(BufferedImage imagemMiniatura) {
        this.imagemMiniatura = imagemMiniatura;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }   

}
