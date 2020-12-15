/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import business.ArrayListImagem;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author artur
 */
public class Imagem {
    
    private int codigo;
    private String nome;
    private File arquivo;
    private File arquivoMiniatura;
    private BufferedImage imagem;
    private BufferedImage imagemMiniatura;
    
    ArrayListImagem listaImagem = ArrayListImagem.getInstance();

    public Imagem(String nome, File arquivo, File arquivoMiniatura, BufferedImage imagem, BufferedImage imagemMiniatura) {
        this.nome = nome;
        this.arquivo = arquivo;
        this.arquivoMiniatura = arquivoMiniatura;
        this.imagem = imagem;
        this.imagemMiniatura = imagemMiniatura;
        this.setCodigo(listaImagem);
        System.out.println("Imagem Criada");
        System.out.println(codigo);
        System.out.println(nome);
        System.out.println(arquivo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public File getArquivoMiniatura() {
        return arquivoMiniatura;
    }

    public void setArquivoMiniatura(File arquivoMiniatura) {
        this.arquivoMiniatura = arquivoMiniatura;
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

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(ArrayListImagem data) {
        int keyCode = data.getUltimoCodigo();
        keyCode++;
        this.codigo = keyCode;
    }
    
    
    
}
