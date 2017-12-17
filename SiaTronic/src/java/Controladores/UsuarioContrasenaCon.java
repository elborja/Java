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

/**
 *
 * @author Administrador
 */
@Named(value = "usuarioContrasenaCon")
@SessionScoped
public class UsuarioContrasenaCon implements Serializable {

    /**
     * Creates a new instance of UsuarioContrasenaCon
     */
    public UsuarioContrasenaCon() {
    }
    
    @EJB
    UsuarioContrasenaFacade usuariocontrasenafacade;
    UsuarioContrasena usuariocontrasena = new UsuarioContrasena();
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();

    public UsuarioContrasenaFacade getUsuariocontrasenafacade() {
        return usuariocontrasenafacade;
    }

    public void setUsuariocontrasenafacade(UsuarioContrasenaFacade usuariocontrasenafacade) {
        this.usuariocontrasenafacade = usuariocontrasenafacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public String registrarUsuarioContrasena(){
        usuariocontrasenafacade.create(usuariocontrasena);
        return "RegistrarUsuarioContrasena";
    }
    
    public List <UsuarioContrasena> listarUsuarioContrasena(){
        usuariocontrasenafacade.findAll();
        return usuariocontrasenafacade.findAll();
    }
    
    
}



