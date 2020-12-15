/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Imagens;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Imagem;

/**
 *
 * @author artur
 */
public abstract class DatabaseImagem {

    public abstract boolean adicionarImagem(Imagem imagem) throws SQLException;

    public abstract boolean removerImagem(Imagem imagem) throws SQLException;

    public abstract Imagem getImagem(int codeImagem) throws SQLException;

    public abstract void imprimeTudo();

    public abstract int getNumeroImagems();

    public abstract ArrayList<Imagem> getImagems() throws SQLException;
    
    public abstract void update(Imagem imagem) throws SQLException;

}
