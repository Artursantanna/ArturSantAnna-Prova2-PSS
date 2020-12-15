/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author artur
 */
public abstract class DatabaseUsuario {

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public abstract boolean adicionarUsuario(Usuario usuario);

    public abstract boolean removerUsuario(Usuario usuario);

    public abstract Usuario getUsuario(String nomeUsuario);

    public abstract void imprimeTudo();

    public abstract int getNumeroUsuarios();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
