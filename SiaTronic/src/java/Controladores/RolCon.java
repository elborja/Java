/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Entidades.RolUsuario;
import Facades.RolFacade;
import Facades.RolUsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "rolCon")
@SessionScoped
public class RolCon implements Serializable {

    /**
     * Creates a new instance of RolCon
     */
    public RolCon() {
    }
    
    @EJB
    RolFacade rolfacade;
    Rol rol = new Rol();
    
    @EJB
    RolUsuarioFacade rolusuariofacade;
    RolUsuario rolusuario = new RolUsuario();

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolUsuario getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(RolUsuario rolusuario) {
        this.rolusuario = rolusuario;
    }
    
    public String registrarRol(){
        rolfacade.create(rol);
        return "RegistrarRol";
    }
    
    public List <Rol> listarRol(){
        return rolfacade.findAll();
    }
    
    
}
