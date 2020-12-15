/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.imagembuilder;

import model.Imagem;

/**
 *
 * @author artur
 */
public interface IImagemBuilder {
    
    public void montaImagem(String caminhoImagem, String caminhoMiniatura);
    
    public Imagem getImagemConstruida();
    
}
