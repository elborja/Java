/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.Factura;
import Entidades.Sucursal;
import Entidades.TipoServicio;
import Entidades.Usuario;
import Facades.ClienteFacade;
import Facades.SucursalFacade;
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
@Named(value = "clienteCon")
@SessionScoped
public class ClienteCon implements Serializable {

    /**
     * Creates a new instance of ClienteCon
     */
    public ClienteCon() {
    }
    
     @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();
    
    @EJB
    ClienteFacade clientefacade;
    Cliente cliente = new Cliente ();
    
    
    
    @EJB
    Factura facturafacade;
    Factura factura = new Factura ();
    
    
    @EJB
    SucursalFacade sucursalfacade;
    Sucursal sucursal = new Sucursal ();
    
    @EJB
    TipoServicioFacade tiposerviciofacade;
    TipoServicio tiposervicio = new TipoServicio();
    
    
    
    
     public TipoServicio getTipoServicio() {
        return tiposervicio;
    }

    public void setTipoServicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    
   

    
    public String registrarCliente(){
        clientefacade.create(cliente);
        return "RegistrarCliente";
    }
    
    public List <Cliente> listarCliente(){
    return clientefacade.findAll();
    }
    
    public List <Usuario> listarUsuario(){
        return usuariofacade.findAll();
    }
    
    public List <TipoServicio> listarTipoServicio(){
        return tiposerviciofacade.findAll();
    }
    
    
}
