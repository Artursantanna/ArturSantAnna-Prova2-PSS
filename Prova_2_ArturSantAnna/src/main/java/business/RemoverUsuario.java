/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.manterusuario.ManterUsuarioView;

/**
 *
 * @author artur
 */
public class RemoverUsuario {

    public void removerUsuario(ManterUsuarioView manterUsuario, ArrayListUsuario listaUsuario) {
        JTable tabela = manterUsuario.getTabelaManterUsuario();
        int linha = manterUsuario.getLinhaTabela();
        if (linha == -1) {

        } else {
            String nome = tabela.getValueAt(linha, 0).toString();
            listaUsuario.removerUsuario(listaUsuario.getUsuario(nome));
            JOptionPane.showMessageDialog(null, "Usuario removido!");
        }

    }

}
