/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Imagem;
import model.Solicitacao;
import presenter.verificarsolicitacao.PresenterVerificarSolicitacao;
import view.verificarsolicitacao.VerificarSolicitacaoView;

/**
 *
 * @author artur
 */
public class ManipularSolicitacao {

    public void exibir(VerificarSolicitacaoView solicitacao) {
        DefaultTableModel model = (DefaultTableModel) solicitacao.getTabelaSolicitacoes().getModel();

        int contador = 0;
        for (Solicitacao solicitacaoSolicitada : ArrayListSolicitacao.getInstance().getSolicitacoes()) {
            model.setRowCount(model.getRowCount() + 1);
            solicitacao.getTabelaSolicitacoes().setValueAt(solicitacaoSolicitada.getIndentificador(), contador, 0);
            solicitacao.getTabelaSolicitacoes().setValueAt(solicitacaoSolicitada.getNomeUsuario(), contador, 1);
            int numeroFoto = solicitacaoSolicitada.getNumeroFoto();
            Imagem imagem = ArrayListImagem.getInstance().getImagem(numeroFoto);
            solicitacao.getTabelaSolicitacoes().setValueAt(imagem.getNome(), contador, 2);
            contador++;
        }
    }

    public void aceitar(VerificarSolicitacaoView solicitacao) {
        JTable tabela = solicitacao.getTabelaSolicitacoes();
        int linha = tabela.getSelectedRow();
        if (linha > -1) {
            int numeroSolicitacao = Integer.parseInt(tabela.getValueAt(linha, 0).toString());

            ArrayListSolicitacao.getInstance().removerSolicitacao(ArrayListSolicitacao.getInstance().getSolicitacao(numeroSolicitacao));
            solicitacao.dispose();
            new PresenterVerificarSolicitacao().inicial();
        }
    }

    public void remover(VerificarSolicitacaoView solicitacao) {
        JTable tabela = solicitacao.getTabelaSolicitacoes();
        int linha = tabela.getSelectedRow();
        if (linha > -1) {
            int numeroSolicitacao = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
            ArrayListSolicitacao.getInstance().removerSolicitacao(ArrayListSolicitacao.getInstance().getSolicitacao(numeroSolicitacao));
            solicitacao.dispose();
            new PresenterVerificarSolicitacao().inicial();
        }
    }
}
