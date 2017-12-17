/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.Equipo;
import Entidades.EstadoUsuario;
import Entidades.RolUsuario;
import Entidades.TipoDocumento;
import Entidades.Usuario;
import Entidades.UsuarioContrasena;
import Facades.ClienteFacade;
import Facades.EquipoFacade;
import Facades.EstadoUsuarioFacade;
import Facades.RolUsuarioFacade;
import Facades.TipoDocumentoFacade;
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
@Named(value = "usuarioCon")
@SessionScoped
public class UsuarioCon implements Serializable {

    /**
     * Creates a new instance of UsuarioCon
     */
    public UsuarioCon() {
    }
    
    
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();
    
    @EJB
    EquipoFacade equipofacade;
    Equipo equipo = new Equipo();
    
    @EJB
    RolUsuarioFacade rolusuariofacade;
    RolUsuario rolusuario = new RolUsuario();

    @EJB
    TipoDocumentoFacade tipodocumentofacade;
    TipoDocumento tipodocumento;
    
    @EJB
    EstadoUsuarioFacade estadousuariofacade;
    Entidades.EstadoUsuario estadousuario = new Entidades.EstadoUsuario();
    
    @EJB
    ClienteFacade clientefacade;
    Cliente cliente = new Cliente();
    
    @EJB
    UsuarioContrasenaFacade usuariocontrasenafacade;
    UsuarioContrasena usuariocontrasena = new UsuarioContrasena();
    
    
    public UsuarioContrasena getUsuarioContrasena() {
        return usuariocontrasena;
    }

    public void setUsuarioContrasena(UsuarioContrasena usuariocontrasena) {
        this.usuariocontrasena = usuariocontrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public RolUsuario getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(RolUsuario rolusuario) {
        this.rolusuario = rolusuario;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Entidades.EstadoUsuario getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(Entidades.EstadoUsuario estadousuario) {
        this.estadousuario = estadousuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    public String registrarUsuario (){
        usuariofacade.create(usuario);
        return "RegistrarUsuario";
        
    }
    
    public List <Usuario> listarUsuario(){
       return  usuariofacade.findAll();
    }
    
    public List <TipoDocumento> listarTipoDocumento(){
        return tipodocumentofacade.findAll();
    }
    
    public List <EstadoUsuario> listarEstadoUsuario(){
        return estadousuariofacade.findAll();
    }
    
    public List <UsuarioContrasena> listarUsuarioContrasena(){
        return usuariocontrasenafacade.findAll();
    }
    
    
}
