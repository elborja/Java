/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.Equipo;
import Entidades.Sucursal;
import Facades.ClienteFacade;
import Facades.EquipoFacade;
import Facades.SucursalFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "sucursalCon")
@SessionScoped
public class SucursalCon implements Serializable {

    /**
     * Creates a new instance of SucursalCon
     */
    public SucursalCon() {
    }
    
    @EJB
    SucursalFacade sucursalfacade;
    Sucursal sucursal = new Sucursal();
    
    @EJB
    ClienteFacade clientefacade;
    Cliente cliente = new  Cliente();
    
    @EJB
    EquipoFacade equipofacade;
    Equipo equipo = new Equipo();

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public String registrarSucursal(){
        sucursalfacade.create(sucursal);
        return "RegistrarSucursal";
    }
    public List <Sucursal> listarSucursal(){
        return sucursalfacade.findAll();
    }
    
    public List <Cliente> listarCliente(){
        return clientefacade.findAll();
    }
    
    
}
