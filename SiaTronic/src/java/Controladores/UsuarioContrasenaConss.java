/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Usuario;
import Entidades.UsuarioContrasena;
import Facades.UsuarioContrasenaFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
/*import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;*/

/**
 *
 * @author Administrador
 */
@Named(value = "usuarioContrasenaCon")
@SessionScoped
public class UsuarioContrasenaConss implements Serializable {

    /**
     * Creates a new instance of UsuarioContrasenaCon
     */
    
     public UsuarioContrasenaConss() {
    }
    
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();
    
    @EJB
    UsuarioContrasenaFacade usuariocontrasenafacade;
    
    UsuarioContrasena usuariocontrasena = new UsuarioContrasena();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioContrasena getUsuariocontrasena() {
        return usuariocontrasena;
    }

    public void setUsuariocontrasena(UsuarioContrasena usuariocontrasena) {
        this.usuariocontrasena = usuariocontrasena;
    }

public String registrarUsuarioContrasena(){
    usuariocontrasenafacade.create(usuariocontrasena);
    return "RegistrarUsuarioContrasena";
}

public List <UsuarioContrasena> listarUsuarioContrasena(){
    return usuariocontrasenafacade.findAll();
}

}
