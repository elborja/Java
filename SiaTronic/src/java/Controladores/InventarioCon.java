/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Inventario;
import Entidades.Proveedor;
import Facades.InventarioFacade;
import Facades.ParteReparacionFacade;
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
@Named(value = "inventarioCon")
@SessionScoped
public class InventarioCon implements Serializable {

    /**
     * Creates a new instance of InventarioCon
     */
    
    
    public InventarioCon() {
    }
    
    @EJB 
    InventarioFacade inventariofacade;
    Inventario inventario = new Inventario();
    
    @EJB
    ParteReparacionFacade partereparacionfacade;
    ParteReparacion partereparacion =  new ParteReparacion();
    
    @EJB
    ProveedorFacade proveedorfacade;
    Proveedor proveedor = new Proveedor ();

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public ParteReparacion getPartereparacion() {
        return partereparacion;
    }

    public void setPartereparacion(ParteReparacion partereparacion) {
        this.partereparacion = partereparacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public String registrarInventario (){
       /* inventario.setIdProveedor(proveedorfacade.find(proveedor.getIdProveedor()));
        inventariofacade.create(inventario);
        inventario = new Inventario();*/
       inventariofacade.create(inventario);
        
        return "RegistrarInventario";
    }
    
    public List <Inventario> listarInventario(){
        return inventariofacade.findAll();
    }
    
    public List <Proveedor> listarProveedor(){
       return proveedorfacade.findAll();
    }
    
    
    public String actualizarInventario(Inventario objinventario){
        inventario = objinventario;
      return "ClienteActualizarInventario";
    }
    public String actualizarInventario1 (){
        inventario.setIdProveedor(proveedorfacade.find(proveedor.getIdProveedor()));
       inventariofacade.edit(inventario);
      return "ClienteListarInventario";
      } 
        
    
    
    public String eliminarInventario (Inventario objinventario){
        inventario = objinventario;
        inventariofacade.remove(inventario);
        return "ClienteListarInventarios";
    }
    
    
   
}
