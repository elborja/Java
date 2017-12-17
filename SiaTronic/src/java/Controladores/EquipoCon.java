/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.Equipo;
import Entidades.EstadoIncidente;
import Entidades.Factura;
import Entidades.Incidente;
import Entidades.Inventario;
import Entidades.ParteReparacion;
import Entidades.Prioridad;
import Entidades.Proveedor;
import Entidades.Sucursal;
import Entidades.TipoEquipo;
import Entidades.TipoServicio;
import Facades.ClienteFacade;
import Facades.EquipoFacade;
import Facades.InventarioFacade;
import Facades.ParteReparacionFacade;
import Facades.PrioridadFacade;
import Facades.ProveedorFacade;
import Facades.SucursalFacade;
import Facades.TipoEquipoFacade;
import Facades.TipoServicioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "equipoCon")
@SessionScoped
public class EquipoCon implements Serializable {

    /**
     * Creates a new instance of EquipoCon
     */
    
    

    
    public EquipoCon() {
    }
    
             
    
    @EJB
    EquipoFacade equipofacade;
    Equipo equipo = new Equipo();
    
    
    @EJB
    Incidente incidentefacade;
    Incidente incidente = new Incidente ();
    
    @EJB
    InventarioFacade inventariofacade;
    Inventario inventario = new Inventario ();
    
   
    
    @EJB
    SucursalFacade sucursalfacade;
    Sucursal sucursal = new Sucursal ();
    
    @EJB
    TipoEquipoFacade tipoequipofacade;
    TipoEquipo tipoequipo = new TipoEquipo ();

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoEquipo getTipoequipo() {
        return tipoequipo;
    }

    public void setTipoequipo(TipoEquipo tipoequipo) {
        this.tipoequipo = tipoequipo;
    }
    
    

   
    
    
    public String registrar (){
        equipofacade.create(equipo);
        return "RegistrarEquipo";
    }
    
    public List <Equipo> listarEquipo(){
        return equipofacade.findAll(); 
    }
    
    public List <Sucursal> listarSucursal(){
        return sucursalfacade.findAll();
    }
    
    public List <TipoEquipo> listarTipoEquipo(){
        return tipoequipofacade.findAll();
    }
    
    
}
