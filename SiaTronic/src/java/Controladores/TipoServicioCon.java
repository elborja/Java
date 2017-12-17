/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.TipoServicio;
import Entidades.Usuario;
import Facades.TipoServicioFacade;
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
@Named(value = "tipoServicioCon")
@SessionScoped
public class TipoServicioCon implements Serializable {

    /**
     * Creates a new instance of TipoServicioCon
     */
    public TipoServicioCon() {
    }
    
    @EJB
    TipoServicioFacade tiposerviciofacade;
    TipoServicio tiposervicio = new TipoServicio();
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String registrarTipoServicio(){
        tiposerviciofacade.create(tiposervicio);
        return "RegistrarTipoServicio";
    }
    
    public List <TipoServicio> listarTipoServicio(){
        return tiposerviciofacade.findAll();
    }
    
}
