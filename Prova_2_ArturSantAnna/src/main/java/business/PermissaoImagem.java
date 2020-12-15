/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Usuario;

/**
 *
 * @author artur
 */
public class PermissaoImagem {
    
    public void addImagensAdmin(Usuario usuario){
        if(usuario.isAdministrador() == true){
            usuario.setFotosPermitidas(ArrayListImagem.getInstance().getImagems());
        }
    }
    
}
