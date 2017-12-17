/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.EstadoUsuario;
import Entidades.TipoDocumento;
import Entidades.Usuario;
import Facades.EstadoUsuarioFacade;
import Facades.TipoDocumentoFacade;
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
@Named(value = "tipoDocumentoCon")
@SessionScoped
public class TipoDocumentoCon implements Serializable {

    /**
     * Creates a new instance of TipoDocumentoCon
     */
    public TipoDocumentoCon() {
    }
    
    @EJB
    TipoDocumentoFacade tipodocumentofacade;
    TipoDocumento tipodocumento = new TipoDocumento();
    
    @EJB
    UsuarioFacade usuariofacade ;
    Usuario usuario = new Usuario ();
    
    @EJB
    EstadoUsuarioFacade estadousuariofacade;
    EstadoUsuario estadousuario = new EstadoUsuario();

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuario getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(EstadoUsuario estadousuario) {
        this.estadousuario = estadousuario;
    }

    
    
        public String registrarTipoDocumento (){
        tipodocumentofacade.create(tipodocumento);
        return "RegistrarTipoDocumento";
    }
        
        public List <TipoDocumento> ListarTipoDocumento(){
           return tipodocumentofacade.findAll();
        }
    
}
