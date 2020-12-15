/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Solicitacao;
import model.Usuario;

/**
 *
 * @author artur
 */
public class PedirPermissao {

    public void permitir(int numeroJButton, Usuario usuarioLogado) {
        ArrayList<Imagem> imagensPermitidas = ArrayListUsuario.getInstance().getUsuario(usuarioLogado.getNome()).getFotosPermitidas();
        if (numeroJButton != 0) {
            if (ArrayListImagem.getInstance().getImagem(numeroJButton) != null) {
                if (imagensPermitidas.isEmpty()) {
                    boolean conferencia = true;
                    int codigoImagem = ArrayListImagem.getInstance().getImagem(numeroJButton).getCodigo();
                    String nomeUsuario = usuarioLogado.getNome();
                    for (Solicitacao solicitacao : ArrayListSolicitacao.getInstance().getSolicitacoes()) {
                        if (solicitacao.getNomeUsuario().equals(nomeUsuario)
                                && solicitacao.getNumeroFoto() == codigoImagem) {
                            conferencia = false;
                        }
                    }
                    if (conferencia) {
                        ArrayListSolicitacao.getInstance().adicionarSolicitacao(new Solicitacao(nomeUsuario, codigoImagem));
                        JOptionPane.showMessageDialog(null, "Solicitação realizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Solicitação já realizada.");
                    }
                } else {
                    for (Imagem imagemPermitida : imagensPermitidas) {
                        if (imagemPermitida.getCodigo() != ArrayListImagem.getInstance().getImagem(numeroJButton).getCodigo()) {
                            boolean conferencia = true;
                            int codigoImagem = ArrayListImagem.getInstance().getImagem(numeroJButton).getCodigo();
                            String nomeUsuario = usuarioLogado.getNome();
                            for (Solicitacao solicitacao : ArrayListSolicitacao.getInstance().getSolicitacoes()) {
                                if (solicitacao.getNomeUsuario().equals(nomeUsuario)
                                        && solicitacao.getNumeroFoto() == codigoImagem) {
                                    conferencia = false;
                                }
                            }
                            if (conferencia) {
                                ArrayListSolicitacao.getInstance().adicionarSolicitacao(new Solicitacao(nomeUsuario, codigoImagem));
                                JOptionPane.showMessageDialog(null, "Solicitação realizada.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Solicitação já realizada.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Voce já possui acesso a essa imagem.");
                        }
                    }
                }
            }
        }
    }

}
