/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.Usuario.DatabaseUsuario;
import javax.swing.JOptionPane;
import model.Usuario;
import presenter.telaprincipaladministrador.PresenterTelaPrincipalAdministrador;
import presenter.telaprincipalusuario.PresenterTelaPrincipalUsuario;
import view.login.LoginView;

/**
 *
 * @author artur
 */
public class VerificaLogin {
    
    private Usuario usuarioLogado = null;

    public VerificaLogin() {
    }

    private static boolean verificaNome(String nome, DatabaseUsuario data) {
        Usuario usuario = data.getUsuario(nome);
        if (usuario == null) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean verificaSenha(String nome, String senha, DatabaseUsuario data) {
        Usuario usuario = data.getUsuario(nome);
        if (usuario == null) {
            return false;
        } else {
            if (usuario.getSenha().equals(senha)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean verifica(String nome, String senha, DatabaseUsuario data) {
        boolean condicionalNome = verificaNome(nome, data);
        System.out.println("VN" + condicionalNome);
        boolean condicionalSenha = verificaSenha(nome, senha, data);
        System.out.println("VS" + condicionalSenha);
        if (condicionalNome == true && condicionalSenha == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean verificaPrimeiroLogin(DatabaseUsuario data) {
        int quantosUsuarios = data.getNumeroUsuarios();
        if (quantosUsuarios > 0) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean verificaAdministrador(String nome, DatabaseUsuario data) {
        Usuario usuario = data.getUsuario(nome);
        if (usuario == null) {
            return false;
        } else {
            if (usuario.isAdministrador()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void verifica(LoginView view, ArrayListUsuario listaUsuario) {
        String campoNome = view.getCamponome().getText();
        String campoSenha = view.getCamposenha().getText();

        if (VerificaLogin.verificaPrimeiroLogin(listaUsuario)) {
            listaUsuario.adicionarUsuario(new Usuario(campoNome, campoSenha, true));
            usuarioLogado = listaUsuario.getUsuario(campoNome);
            new PresenterTelaPrincipalAdministrador().inicial(usuarioLogado);
        } else {
            if (VerificaLogin.verifica(campoNome, campoSenha, listaUsuario)) {
                if (VerificaLogin.verificaAdministrador(campoNome, listaUsuario)) {
                    System.out.println("Admin " + listaUsuario.getUsuario(campoNome).getNome());
                    usuarioLogado = listaUsuario.getUsuario(campoNome);
                    new PresenterTelaPrincipalAdministrador().inicial(usuarioLogado);
                } else {
                    usuarioLogado = listaUsuario.getUsuario(campoNome);
                    new PresenterTelaPrincipalUsuario().inicial(usuarioLogado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e Senha não conferem\nDesligando Sistema");
                System.exit(0);
            }
        }
        view.setVisible(false);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

}
