/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.telaprincipaladministrador;

import business.CompartilhaImagemAdministrador;
import business.EscreveRodape;
import business.ExibiImagens;
import business.RemoveImagemAdministrador;
import java.awt.event.ActionEvent;
import model.Usuario;
import presenter.adicionarimagem.PresenterAdicionarImagem;
import presenter.manterusuario.PresenterManterUsuario;
import presenter.verificarsolicitacao.PresenterVerificarSolicitacao;
import presenter.vernotificacao.PresenterVerNotificacao;
import view.telainicial.administrador.TelaInicialAdministrador;

/**
 *
 * @author artur
 */
public class PresenterTelaPrincipalAdministrador {

    TelaInicialAdministrador telaInicial = new TelaInicialAdministrador();
    int numeroJButton = 0;

    public void inicial(Usuario usuarioLogado) {
        telaInicial.setVisible(true);

        new EscreveRodape().escreve(telaInicial, usuarioLogado, "Administrador");

        new ExibiImagens().exibir(telaInicial, usuarioLogado);

        telaInicial.getjLabelFoto1().addActionListener((ActionEvent e) -> {
            numeroJButton = 1;
        });
        telaInicial.getjLabelFoto2().addActionListener((ActionEvent e) -> {
            numeroJButton = 2;
        });
        telaInicial.getjLabelFoto3().addActionListener((ActionEvent e) -> {
            numeroJButton = 3;
        });
        telaInicial.getjLabelFoto4().addActionListener((ActionEvent e) -> {
            numeroJButton = 4;
        });
        telaInicial.getjLabelFoto5().addActionListener((ActionEvent e) -> {
            numeroJButton = 5;
        });
        telaInicial.getjLabelFoto6().addActionListener((ActionEvent e) -> {
            numeroJButton = 6;
        });
        telaInicial.getjLabelFoto7().addActionListener((ActionEvent e) -> {
            numeroJButton = 7;
        });
        telaInicial.getjLabelFoto8().addActionListener((ActionEvent e) -> {
            numeroJButton = 8;
        });

        new ImagemClick().doisClics(telaInicial, usuarioLogado);

        telaInicial.getBotaoAddImagem().addActionListener((ActionEvent e) -> {
            new PresenterAdicionarImagem().inicial(usuarioLogado);
            telaInicial.dispose();
        });

        telaInicial.getBotaoRemoverImagem().addActionListener((ActionEvent e) -> {
            new RemoveImagemAdministrador().remove(numeroJButton, telaInicial, usuarioLogado);
        });

        telaInicial.getBotaoCompartilhar().addActionListener((ActionEvent e) -> {
            new CompartilhaImagemAdministrador().compartilha(numeroJButton, usuarioLogado);
        });

        telaInicial.getBotaoNotificacoes().addActionListener((ActionEvent e) -> {
            new PresenterVerNotificacao().inicial(usuarioLogado);
        });

        telaInicial.getBotaoVerificarSolicitacao().addActionListener((ActionEvent e) -> {
            new PresenterVerificarSolicitacao().inicial();
        });

        telaInicial.getBotaoManterUsuario().addActionListener((ActionEvent e) -> {
            new PresenterManterUsuario().inicial(usuarioLogado);
        });

        telaInicial.getBotaoDesfazer().addActionListener((ActionEvent e) -> {
            System.out.println("PRESENTER PRINCIPAL numeroImagem" + numeroJButton);
        });
    }

}
