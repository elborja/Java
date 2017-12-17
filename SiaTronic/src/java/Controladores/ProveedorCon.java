/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Inventario;
import Entidades.Proveedor;
import Facades.InventarioFacade;
import Facades.ProveedorFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "proveedorCon")
@SessionScoped
public class ProveedorCon implements Serializable {

    /**
     * Creates a new instance of ProveedorCon
     */
    public ProveedorCon() {
    }
    
    @EJB
    ProveedorFacade proveedorfacade;
    Proveedor proveedor = new Proveedor ();
    
    @EJB
    InventarioFacade inventariofacade;
    Inventario inventario = new Inventario();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public String registrarProveedor(){
        proveedorfacade.create(proveedor);
        return "RegistrarProveedor";
    }
    
    public List <Proveedor> listarProveedor(){
        return proveedorfacade.findAll();
    }
    
    public String actualizarProveedor (Proveedor objproveedor){
        proveedor = objproveedor;
       
        return "ClienteActualizarProveedores";
    }
    public String actualizarProveedor1 (){
      proveedorfacade.edit(proveedor);
      return "ClienteListarproveedores";
      }
    
    public String eliminarProveedor (Proveedor objproveedor){
        proveedor = objproveedor;
        proveedorfacade.remove(proveedor);
        return "ClienteListarProveedores";
    }
    
    
        
    }
    
    
    
    

