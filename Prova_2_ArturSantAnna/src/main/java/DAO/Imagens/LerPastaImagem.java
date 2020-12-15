/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Imagens;

import business.ArrayListImagem;
import business.imagembuilder.ImagemBuilderConcreto;
import business.imagembuilder.ImagemDiretor;
import java.io.File;
import model.Imagem;

/**
 *
 * @author artur
 */
public class LerPastaImagem {

    File diretorio = new File(".\\src\\main\\java\\imagens");

    File arquivos[];

    public void lerPasta() {
        arquivos = diretorio.listFiles();

        for (int i = 0; i < arquivos.length/2; i++) {
            String caminho = arquivos[i].getAbsolutePath();
            String caminhoImagem = "";
            String caminhoMiniatura = "";
            if (caminho.contains("miniatura")) {
                caminhoMiniatura = caminho;
            }
            if (caminho.contains("imagem")) {
                caminhoImagem = caminho;
            }
            Imagem imagem = new ImagemDiretor().build(new ImagemBuilderConcreto(), caminhoImagem, caminhoMiniatura);
            ArrayListImagem.getInstance().adicionarImagem(imagem);
        }
    }

}
