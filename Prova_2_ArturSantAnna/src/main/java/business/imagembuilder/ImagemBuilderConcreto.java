/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.imagembuilder;

import business.ManipularImagem;
import java.awt.image.BufferedImage;
import java.io.File;
import model.Imagem;

/**
 *
 * @author artur
 */
public class ImagemBuilderConcreto implements IImagemBuilder{
    
    private Imagem imagemConstruida;
    
    @Override
    public void montaImagem(String caminhoImagem, String caminhoMiniatura){
        BufferedImage imagem, imagemMiniatura; 
        File arquivo, arquivoMiniatura;
        
        arquivo = new File(caminhoImagem);
        arquivoMiniatura = new File(caminhoMiniatura);
        
        imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
        imagemMiniatura = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 60, 60);
        
        imagemConstruida = new Imagem("imagem-1.jpg", arquivo, arquivoMiniatura, imagem, imagemMiniatura);
    }

    public Imagem getImagemConstruida() {
        return imagemConstruida;
    }
    
}
