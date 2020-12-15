/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Usuario;
import presenter.manterusuario.PresenterManterUsuario;
import view.manterusuario.ManterUsuarioView;
import view.manterusuario.editarusuario.EditarUsuarioView;

/**
 *
 * @author artur
 */
public class EditarUsuario {

    public void exibirUsuario(EditarUsuarioView editarUsuario, ManterUsuarioView manterUsuario, ArrayListUsuario listaUsuario) {
        int linha = manterUsuario.getLinhaTabela();
        JTable tabela = manterUsuario.getTabelaManterUsuario();

        String nome;
        String senha;
        boolean admin;

        if (linha == -1) {
            nome = "";
            senha = "";
            admin = false;
        } else {
            nome = tabela.getValueAt(linha, 0).toString();
            System.out.println(nome);
            Usuario usuario = listaUsuario.getUsuario(nome);
            senha = usuario.getSenha();
            admin = usuario.isAdministrador();
        }

        editarUsuario.setCampoNome(nome);
        editarUsuario.setCampoSenha(senha);
        editarUsuario.setCampoAdmin(admin);
    }

    public void editarUsuario(EditarUsuarioView editarUsuario, ArrayListUsuario listaUsuario, Usuario usuarioLogado) {
        String campoNome = editarUsuario.getCampoNome().getText();
        String campoSenha = editarUsuario.getCampoSenha().getText();
        boolean campoAdmin = editarUsuario.getCampoAdmin().isSelected();

        listaUsuario.removerUsuario(listaUsuario.getUsuario(campoNome));
        if (this.verificaNome(campoNome)) {
            listaUsuario.adicionarUsuario(new Usuario(campoNome, campoSenha, campoAdmin));
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
            new PresenterManterUsuario().resetar(usuarioLogado);
            editarUsuario.dispose();
        }else{
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
