/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Imagens;

import DAO.DatabaseSQLite;
import business.ManipularImagem;
import business.imagembuilder.ImagemBuilderConcreto;
import business.imagembuilder.ImagemDiretor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Imagem;

/**
 *
 * @author artur
 */
public class SQLiteImagem extends DatabaseImagem {

    private ArrayList<Imagem> imagens = new ArrayList<>();

    private Connection conexao;

    private static SQLiteImagem _unicaInstancia;

    public static SQLiteImagem getInstance() {
        if (_unicaInstancia == null) {
            _unicaInstancia = new SQLiteImagem();
        }
        return _unicaInstancia;
    } //Aplicação do design pattern Singleton

    private SQLiteImagem() {
        conexao = DatabaseSQLite.getInstance().getConnection();
    }

    @Override
    public boolean adicionarImagem(Imagem imagem) throws SQLException {
        if (imagens.add(imagem)) {
            PreparedStatement stat = conexao.prepareStatement(
                    "insert into Imagem values(?, ?, ?, ?)");
            stat.setInt(1, imagem.getCodigo());
            stat.setString(2, imagem.getNome());
            stat.setString(3, imagem.getArquivo().getAbsolutePath());
            stat.setString(3, imagem.getArquivoMiniatura().getAbsolutePath());

            stat.execute();

            stat.close();

            return true;
        }
        return false;
    }

    @Override
    public boolean removerImagem(Imagem imagem) throws SQLException {
        if (imagens.remove(imagem)) {
            int id = imagem.getCodigo();
            Statement stat = conexao.createStatement();
            stat.executeUpdate("delete from Imagem where Imagem.codigo = " + id);
            stat.close();
            return true;
        }
        return false;
    }

    @Override
    public Imagem getImagem(int codeImagem) throws SQLException {
        Statement stat = conexao.createStatement();
        ResultSet rs = stat.executeQuery("select * from Imagem where Imagem.codigo = " + codeImagem);
        Imagem a = null;
        if (rs.next()) {
            String caminhoImagem = rs.getString("arquivoImagem");
            String caminhoMiniatura = rs.getString("arquivoMiniatura");

            Imagem imagem = new ImagemDiretor().build(new ImagemBuilderConcreto(), caminhoImagem, caminhoMiniatura);

            return imagem;
        }

        stat.close();
        return null;
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

    @Override
    public ArrayList<Imagem> getImagems() throws SQLException {
        ArrayList<Imagem> imagensGet = new ArrayList<>();
        Statement stat = conexao.createStatement();
        ResultSet rs = stat.executeQuery("select * from Imagem");

        while (rs.next()) {
            // read the result set
            String caminhoImagem = rs.getString("arquivoImagem");
            String caminhoMiniatura = rs.getString("arquivoMiniatura");

            Imagem imagem = new ImagemDiretor().build(new ImagemBuilderConcreto(), caminhoImagem, caminhoMiniatura);

            imagensGet.add(imagem);
        }

        return imagensGet;
    }

    @Override
    public void update(Imagem imagem) throws SQLException {
        Statement stat = conexao.createStatement();
        stat.executeUpdate("update Imagem set nome = '" + imagem.getNome() + "' "
                + ", arquivoImagem = " + imagem.getArquivo().getAbsolutePath() + "' "
                + ", arquivoMiniatura = " + imagem.getArquivoMiniatura().getAbsolutePath() 
                + " where Imagem.codigo = " + imagem.getCodigo());

        stat.close();
    }

}
