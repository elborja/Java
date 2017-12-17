/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Incidente;
import Entidades.Inventario;
import Entidades.ParteReparacion;
import Facades.IncidenteFacade;
import Facades.InventarioFacade;
import Facades.ParteReparacionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "parteReparacionCon")
@SessionScoped
public class ParteReparacionCon implements Serializable {

    /**
     * Creates a new instance of ParteReparacionCon
     */
    public ParteReparacionCon() {
    }
    
    @EJB
    ParteReparacionFacade partereparacionfacade;
    ParteReparacion partereparacion = new ParteReparacion ();
    
    @EJB
    IncidenteFacade incidentefacade;
    Incidente incidente = new Incidente ();
    
    @EJB
    InventarioFacade inventariofacade;
    Inventario inventario = new Inventario();

    public ParteReparacion getPartereparacion() {
        return partereparacion;
    }

    public void setPartereparacion(ParteReparacion partereparacion) {
        this.partereparacion = partereparacion;
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

    
        public String registrarPartereparacion(){
        partereparacion.setParteSerie(inventariofacade.find(inventario.getSerie()));
        partereparacion.setNumIncidente(incidentefacade.find(incidente.getNumIncidente()));
        partereparacionfacade.create(partereparacion);
        partereparacion = new ParteReparacion();
        
        return "Registrarpartes";
    }
        
        
       
    
    public List <ParteReparacion> listarParteraparacion(){
        return partereparacionfacade.findAll();
    }
    
     public List <Incidente> listarIncientes(){
        return incidentefacade.findAll();
    }
     
      public List <Inventario> listarInventario(){
        return inventariofacade.findAll();
    }
    
    public String actualizarPartereparacion(ParteReparacion objpartereparacion){
        partereparacion = objpartereparacion;
      return "ActualizarPartes";
    }
    public String actualizarPartereparacion (){
        partereparacion.setParteSerie(inventariofacade.find(inventario.getSerie()));
        partereparacion.setNumIncidente(incidentefacade.find(incidente.getNumIncidente()));
       partereparacionfacade.edit(partereparacion);
      return "ListarPartes";
      } 
    
     public String eliminarPartereparcion (ParteReparacion objpartereparacion){
        partereparacion = objpartereparacion;
        partereparacionfacade.remove(partereparacion);
        return "ListarPartes";
    }
        
    
}
