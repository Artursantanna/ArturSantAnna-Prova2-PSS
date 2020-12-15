/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Usuario;
import view.telainicial.ITelaInicial;

/**
 *
 * @author artur
 */
public class EscreveRodape {

    public void escreve(ITelaInicial telaInicial, Usuario usuarioLogado, String permissao) {
        String nomeRodape = telaInicial.getLabelNomeUsuario().getText();
        nomeRodape = nomeRodape + usuarioLogado.getNome();
        telaInicial.getLabelNomeUsuario().setText(nomeRodape);

        String permissaoRodape = telaInicial.getLabelPermissao().getText();
        permissaoRodape = permissaoRodape + " " + permissao;
        telaInicial.getLabelPermissao().setText(permissaoRodape);
    }

}
