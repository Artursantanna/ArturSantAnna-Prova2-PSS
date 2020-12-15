/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DAO.Usuario.DatabaseUsuario;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author artur
 */
public class ArrayListUsuario extends DatabaseUsuario{
    
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    private static ArrayListUsuario _unicaInstancia;

    public static ArrayListUsuario getInstance() {
        if (_unicaInstancia == null) {
            _unicaInstancia = new ArrayListUsuario();
        }
        return _unicaInstancia;
    } //Aplicação do design pattern Singleton
    
    public ArrayListUsuario() {
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
        @Override
    public boolean adicionarUsuario(Usuario usuario) {
        if (usuarios.add(usuario)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removerUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            return true;
        }
        return false;
    }

    @Override
    public Usuario getUsuario(String nome) {
        Usuario a = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().compareTo(nome) == 0) {
                a = usuario;
                break;
            }
        }
        return a;
    }

    @Override
    public void imprimeTudo() {
        usuarios.forEach(usuario -> {
            System.out.println(usuario.getNome());
        });

    }

    @Override
    public int getNumeroUsuarios() {
        int numeroUsuarios = 0;
        for (Usuario usuario : usuarios) {
            numeroUsuarios++;
        }
        return numeroUsuarios;
    } 
    
}
