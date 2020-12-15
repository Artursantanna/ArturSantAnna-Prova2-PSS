/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;

/**
 *
 * @author artur
 */
public class TratadorDePermissoes {

    ArrayListUsuario listaUsuario = ArrayListUsuario.getInstance();
    ArrayListImagem listaImagem = ArrayListImagem.getInstance();

    public void removeDeTodos() {
        String nomeUsuario;
        int numeroImagem;
        for (Usuario usuario : listaUsuario.getUsuarios()) {
            for (Imagem imagem : listaImagem.getImagems()) {
                nomeUsuario = usuario.getNome();
                numeroImagem = imagem.getCodigo();
                listaUsuario.getUsuario(nomeUsuario).getFotosPermitidas().remove(listaImagem.getImagem(numeroImagem));
            }
        }
    }

    public void adicionarPermissaoAdmin() {
        String nomeUsuario;
        for (Usuario usuario : listaUsuario.getUsuarios()) {
            int contador = 1;
            for (Imagem imagem : listaImagem.getImagems()) {
                if (usuario.isAdministrador()) {
                    nomeUsuario = usuario.getNome();
                    ArrayListUsuario.getInstance().getUsuario(nomeUsuario).getFotosPermitidas().add(listaImagem.getImagem(contador));
                }
            }
        }
    }

}
