/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Entidades.RolUsuario;
import Entidades.Usuario;
import Facades.RolFacade;
import Facades.RolUsuarioFacade;
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
@Named(value = "rolUsuarioCon")
@SessionScoped
public class RolUsuarioCon implements Serializable {

    /**
     * Creates a new instance of RolUsuarioCon
     */
    public RolUsuarioCon() {
    }
    
    @EJB
    RolUsuarioFacade rolusuariofacade;
    RolUsuario rolusuario = new RolUsuario();
    
    @EJB
    RolFacade rolfacade;
    Rol rol = new Rol();
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();

    public RolUsuario getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(RolUsuario rolusuario) {
        this.rolusuario = rolusuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String registrarRolUsuario(){
        rolusuariofacade.create(rolusuario);
        return "RegistrarRolUsuario";
    }
    
    public List <RolUsuario> listarRolUsuario(){
        return rolusuariofacade.findAll();
    }
    
    public List <Rol> listarRol(){
        return rolfacade.findAll();
    }
    
    public List <Usuario> listarUsuario(){
        return usuariofacade.findAll();
    }
    
}
