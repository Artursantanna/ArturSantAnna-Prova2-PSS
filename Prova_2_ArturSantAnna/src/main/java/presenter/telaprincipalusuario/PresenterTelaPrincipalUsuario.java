package presenter.telaprincipalusuario;

import business.ArrayListImagem;
import business.CompartilhaImagemUsuario;
import business.EscreveRodape;
import business.ExibiImagens;
import business.PedirPermissao;
import business.RemoveImagemUsuario;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import model.Usuario;
import presenter.adicionarimagem.PresenterAdicionarImagem;
import presenter.vernotificacao.PresenterVerNotificacao;
import view.telainicial.usuario.TelaInicialUsuario;

public class PresenterTelaPrincipalUsuario {

    TelaInicialUsuario telaInicial = new TelaInicialUsuario();
    ArrayListImagem listaImagem = ArrayListImagem.getInstance();
    JButton JButtonAcao = null;
    int numeroJButton = 0;

    public void inicial(Usuario usuarioLogado) {
        telaInicial.setVisible(true);
        
        new EscreveRodape().escreve(telaInicial, usuarioLogado, "Usuario");

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
        
        new ImagemClickUsuario().doisClics(telaInicial, usuarioLogado);

        telaInicial.getBotaoAddImagem().addActionListener((ActionEvent e) -> {
            new PresenterAdicionarImagem().inicial(usuarioLogado);
            telaInicial.dispose();
        });

        telaInicial.getBotaoRemoverImagem().addActionListener((ActionEvent e) -> {
            new RemoveImagemUsuario().remove(numeroJButton, telaInicial, usuarioLogado);
        });

        telaInicial.getBotaoCompartilhar().addActionListener((ActionEvent e) -> {
            new CompartilhaImagemUsuario().compartilha(numeroJButton, usuarioLogado);
        });

        telaInicial.getBotaoNotificacoes().addActionListener((ActionEvent e) -> {
            new PresenterVerNotificacao().inicial(usuarioLogado);
        });

        telaInicial.getBotaoPedirPermissao().addActionListener((ActionEvent e) -> {
            new PedirPermissao().permitir(numeroJButton, usuarioLogado);
        });
        
        telaInicial.getBotaoDesfazer().addActionListener((ActionEvent e) -> {
            
        });
    }
}