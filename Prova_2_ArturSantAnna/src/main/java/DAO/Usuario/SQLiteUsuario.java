/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import model.Usuario;

/**
 *
 * @author artur
 */
public class SQLiteUsuario extends DatabaseUsuario{

    private static SQLiteUsuario _unicaInstancia;

    public static SQLiteUsuario getInstance() {
        if (_unicaInstancia == null) {
            _unicaInstancia = new SQLiteUsuario();
        }
        return _unicaInstancia;
    } //Aplicação do design pattern Singleton
    
    public SQLiteUsuario() {
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
