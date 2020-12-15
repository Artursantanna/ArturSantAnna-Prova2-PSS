/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DAO.DatabaseSQLite;
import DAO.Imagens.DatabaseImagem;
import DAO.Imagens.LerPastaImagem;
import DAO.Imagens.SQLiteImagem;
import DAO.Solicitacao.DatabaseSolicitacao;
import DAO.Solicitacao.SQLiteSolicitacao;
import DAO.Usuario.DatabaseUsuario;
import DAO.Usuario.SQLiteUsuario;
import business.ArrayListImagem;
import business.ArrayListSolicitacao;
import business.ArrayListUsuario;
import business.ManipularImagem;
import business.TratadorDePermissoes;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Imagem;
import model.Notificacao;
import model.Solicitacao;
import model.Usuario;
import presenter.Login.LoginPresenter;

/**
 *
 * @author artur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection conexao = DatabaseSQLite.getInstance().getConnection();
        
        DatabaseUsuario daoUsuario = SQLiteUsuario.getInstance();
        ArrayListUsuario listaUsuario = ArrayListUsuario.getInstance();
        listaUsuario.setUsuarios(daoUsuario.getUsuarios());

        DatabaseImagem daoImagem = SQLiteImagem.getInstance();
        ArrayListImagem listaImagem = ArrayListImagem.getInstance();
        listaImagem.setImagens(daoImagem.getImagems());

        DatabaseSolicitacao daoSolicitacao = SQLiteSolicitacao.getInstance();
        ArrayListSolicitacao listaSolicitacao = ArrayListSolicitacao.getInstance();
        listaSolicitacao.setSolicitacoes(daoSolicitacao.getSolicitacoes());

        //listaUsuario.adicionarUsuario(new Usuario("a", "", true));
        //listaUsuario.adicionarUsuario(new Usuario("Artur", "0000", true));
        //listaUsuario.adicionarUsuario(new Usuario("u", "", false));
        
        //listaUsuario.getUsuario("a").addNotificacao(new Notificacao("u", "compartilhou a imagem-1 com você."));
        //listaSolicitacao.adicionarSolicitacao(new Solicitacao("u", 2));

        new LerPastaImagem().lerPasta();
        
        //listaUsuario.getUsuario("u").getFotosPermitidas().add(ArrayListImagem.getInstance().getImagem(2));

        new TratadorDePermissoes().adicionarPermissaoAdmin();

        new LoginPresenter().iniciar();
    }

}
