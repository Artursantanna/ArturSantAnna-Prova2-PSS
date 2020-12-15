/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Imagem;
import model.Notificacao;
import model.Usuario;
import view.compartilhar.CompartilharView;

/**
 *
 * @author artur
 */
public class ManipularCompartilhar {

    public void exibir(CompartilharView compartilhar, int numeroImagem, Usuario usuarioLogado) {
        DefaultTableModel model = (DefaultTableModel) compartilhar.getTabelaUsuarios().getModel();

        int contador = 0;
        for (Usuario usuario : ArrayListUsuario.getInstance().getUsuarios()) {
            if (usuario.getNome().equals(usuarioLogado.getNome())) {

            } else {
                model.setRowCount(model.getRowCount() + 1);
                compartilhar.getTabelaUsuarios().setValueAt(usuario.getNome(), contador, 0);
                contador++;
            }
        }

        colocarImagem(numeroImagem, compartilhar.getLabelImagemCompartilha());
    }

    public void compartilhar(CompartilharView compartilhar, int numeroImagem) {
        JTable tabela = compartilhar.getTabelaUsuarios();
        int[] linha = tabela.getSelectedRows();
        if (linha.length > 0) {
            for (int i = 0; i < linha.length; i++) {
                String nome = tabela.getValueAt(linha[i], 0).toString();
                String descricao = "O usuario compartilhou a imagem: " + ArrayListImagem.getInstance().getImagem(numeroImagem).getNome();
                ArrayListUsuario.getInstance().getUsuario(nome).addNotificacao(new Notificacao(nome, descricao));
            }
            JOptionPane.showMessageDialog(null, "Imagem Compartilhada!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuario escolhido.");
        }
        compartilhar.dispose();
    }

    private void colocarImagem(int numeroImagem, JLabel labelImagem) {

        if (ArrayListImagem.getInstance().getNumeroImagems() == 0) {

        } else {
            if (ArrayListImagem.getInstance().getImagem(numeroImagem) != null) {
                Imagem miniatura = ArrayListImagem.getInstance().getImagem(numeroImagem);
                File fileArquivo = miniatura.getArquivo();
                BufferedImage imagemBuffer = miniatura.getImagem();
                labelImagem.setIcon(new ImageIcon(imagemBuffer));
            }
        }
    }
}
