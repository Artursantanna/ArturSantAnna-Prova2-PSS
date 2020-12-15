/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JOptionPane;
import model.Usuario;
import presenter.manterusuario.PresenterManterUsuario;
import view.manterusuario.criarusuario.CriarUsuarioView;

/**
 *
 * @author artur
 */
public class CriarUsuario {

    public void criarUsuario(CriarUsuarioView criarUsuario, ArrayListUsuario listaUsuario, Usuario usuarioLogado) {
        String campoNome = criarUsuario.getCampoNome().getText();
        String campoSenha = criarUsuario.getCampoSenha().getText();
        boolean campoAdmin = criarUsuario.getCampoAdmin().isSelected();

        if (this.verificaNome(campoNome)) {
            listaUsuario.adicionarUsuario(new Usuario(campoNome, campoSenha, campoAdmin));
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
            new PresenterManterUsuario().resetar(usuarioLogado);
            criarUsuario.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário já existente.");
        }
    }

    public boolean verificaNome(String nome) {
        boolean resposta = false;
        for (Usuario usuario : ArrayListUsuario.getInstance().getUsuarios()) {
            if (usuario.getNome().equals(nome)) {
                resposta = false;
                break;
            } else {
                resposta = true;
            }
        }
        return resposta;
    }

}
