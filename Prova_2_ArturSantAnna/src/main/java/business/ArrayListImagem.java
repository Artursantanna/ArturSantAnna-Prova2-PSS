/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.Imagens.DatabaseImagem;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Imagem;

/**
 *
 * @author artur
 */
public class ArrayListImagem extends DatabaseImagem {

    ArrayList<Imagem> imagens = new ArrayList<>();

    private static ArrayListImagem _unicaInstancia;

    public static ArrayListImagem getInstance() {
        if (_unicaInstancia == null) {
            _unicaInstancia = new ArrayListImagem();
        }
        return _unicaInstancia;
    } //Aplicação do design pattern Singleton

    public ArrayListImagem() {
    }

    public void setImagens(ArrayList<Imagem> usuarios) {
        this.imagens = usuarios;
    }

    @Override
    public boolean adicionarImagem(Imagem imagem) {
        if (imagens.add(imagem)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removerImagem(Imagem imagem) {
        if (imagens.remove(imagem)) {
            return true;
        }
        return false;
    }

    @Override
    public Imagem getImagem(int codeImagem) {
        Imagem a = null;
        for (Imagem imagem : imagens) {
            if (imagem.getCodigo() == codeImagem) {
                a = imagem;
                break;
            }
        }
        return a;
    }

    @Override
    public void imprimeTudo() {
        imagens.forEach(imagem -> {
            System.out.println(imagem.getNome());
        });

    }

    @Override
    public int getNumeroImagems() {
        int numeroImagems = 0;
        for (Imagem imagem : imagens) {
            numeroImagems++;
        }
        return numeroImagems;
    }

    public int getUltimoCodigo() {
        int keyCode = 0;
        for (Imagem imagemVerifica : imagens) {
            keyCode = imagemVerifica.getCodigo();
        }
        return keyCode;
    }

    @Override
    public ArrayList<Imagem> getImagems() {
        return imagens;
    }

    @Override
    public void update(Imagem imagem) throws SQLException {
    }

}
