/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Incidente;
import Entidades.Prioridad;
import Facades.IncidenteFacade;
import Facades.PrioridadFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "prioridadCon")
@SessionScoped
public class PrioridadCon implements Serializable {

    /**
     * Creates a new instance of PrioridadCon
     */
    public PrioridadCon() {
    }
    
    @EJB
    PrioridadFacade prioridadfacade;
    Prioridad prioridad = new Prioridad();
    
    @EJB
    IncidenteFacade incidentefacade;
    Incidente incidente = new Incidente();

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }
    
    public String registrarPrioridad(){
        prioridadfacade.create(prioridad);
        return "RegistrarPrioridad";
    }
    
    public List <Prioridad> listarPrioridad(){
        return prioridadfacade.findAll();
    }
    
    
}
