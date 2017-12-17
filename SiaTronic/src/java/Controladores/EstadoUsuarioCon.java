/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.EstadoUsuario;
import Entidades.Usuario;
import Facades.EstadoUsuarioFacade;
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
@Named(value = "estadoUsuarioCon")
@SessionScoped
public class EstadoUsuarioCon implements Serializable {

    /**
     * Creates a new instance of EstadoUsuarioCon
     */
    public EstadoUsuarioCon() {
    }
    
    @EJB
    EstadoUsuarioFacade estadousuariofacade;
    EstadoUsuario estadousuario = new EstadoUsuario();
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();

    public EstadoUsuario getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(EstadoUsuario estadousuario) {
        this.estadousuario = estadousuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String registrarEstadoUsuario(){
        estadousuariofacade.create(estadousuario);
        return "RegistrarEstadoUsuario";
    }
    
   public List <EstadoUsuario> listarEstadoUsuario(){
        return estadousuariofacade.findAll();
    }
    
}
