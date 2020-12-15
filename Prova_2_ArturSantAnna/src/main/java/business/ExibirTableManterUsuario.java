/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.manterusuario.ManterUsuarioView;

/**
 *
 * @author artur
 */
public class ExibirTableManterUsuario {

    public void exibir(ManterUsuarioView manterUsuario, Usuario usuarioLogado) {
        DefaultTableModel model = (DefaultTableModel) manterUsuario.getTabelaManterUsuario().getModel();

        int contador = 0;
        for (Usuario usuario : ArrayListUsuario.getInstance().getUsuarios()) {
            if (usuario.getNome().equals(usuarioLogado.getNome())) {

            } else {
                model.setRowCount(model.getRowCount() + 1);
                manterUsuario.getTabelaManterUsuario().setValueAt(usuario.getNome(), contador, 0);
                manterUsuario.getTabelaManterUsuario().setValueAt(usuario.isAdministrador(), contador, 1);
                contador++;
            }
        }
    }

}
