/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Equipo;
import Entidades.EstadoIncidente;
import Entidades.Factura;
import Entidades.Incidente;
import Entidades.Prioridad;
import Entidades.TipoServicio;
import Facades.EquipoFacade;
import Facades.EstadoIncidenteFacade;
import Facades.FacturaFacade;
import Facades.IncidenteFacade;
import Facades.ParteReparacionFacade;
import Facades.PrioridadFacade;
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
@Named(value = "incidenteCon")
@SessionScoped
public class IncidenteCon implements Serializable {

    /**
     * Creates a new instance of IncidenteCon
     */
    public IncidenteCon() {
    }
    
    @EJB
    PrioridadFacade prioridadfacade;
    Prioridad prioridad = new Prioridad();
    
    @EJB
    TipoServicioFacade tiposerviciofacade;
    TipoServicio tiposervicio = new TipoServicio();
    
    @EJB
    IncidenteFacade incidentefacade;
    Incidente incidente = new Incidente ();
    
    @EJB
    ParteReparacionFacade partereparacionfacade;
    ParteReparacion partereparacion = new ParteReparacion ();
    
    @EJB
    EstadoIncidenteFacade estadoincidentefacade;
    EstadoIncidente estadoincidente = new EstadoIncidente();
    
    @EJB
    FacturaFacade facturafacade;
    Factura factura = new Factura ();
    
    @EJB
    EquipoFacade equipofacade;
    Equipo equipo = new Equipo();

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public ParteReparacion getPartereparacion() {
        return partereparacion;
    }

    public void setPartereparacion(ParteReparacion partereparacion) {
        this.partereparacion = partereparacion;
    }

    public EstadoIncidente getEstadoincidente() {
        return estadoincidente;
    }

    public void setEstadoincidente(EstadoIncidente estadoincidente) {
        this.estadoincidente = estadoincidente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
    
    public String registrarIncidente(){
        incidentefacade.create(incidente);
        return "RegistrarIncidente";
    }
    
    public List <Incidente> listarIncidente(){
        return incidentefacade.findAll();
    }
    
    public String consultarIncidente(Incidente objincidente){
        incidentefacade.find(incidente);
        return "ConsultarIncidente";
        
    }
    
    public String eliminarIncidente (Incidente objincidente){
        incidente = objincidente;
        incidentefacade.remove(incidente);
        return "ListarIncidente";
    }
    
    public String actualizarIncidente (Incidente objincidente){
        incidente = objincidente;
        incidentefacade.edit(incidente);
        return "ActualizarIncidente";  
    }
    
    public String actualizarIncidente1 (){
        incidentefacade.edit(incidente);
        return "listarIncidentes";
    }
    
    public List <Prioridad> listarPrioridad(){
       return prioridadfacade.findAll();
    }
    
    public List <TipoServicio> listarTipoServicio(){
        return tiposerviciofacade.findAll();
    }
    
    public List <Equipo> listarEquipo(){
        return equipofacade.findAll();
    }
}
