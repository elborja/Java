/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "incidente")
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i")
    , @NamedQuery(name = "Incidente.findByNumIncidente", query = "SELECT i FROM Incidente i WHERE i.numIncidente = :numIncidente")
    , @NamedQuery(name = "Incidente.findByDescripcion", query = "SELECT i FROM Incidente i WHERE i.descripcion = :descripcion")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_INCIDENTE")
    private Integer numIncidente;
    @Size(max = 144)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numIncidente")
    private Collection<ParteReparacion> parteReparacionCollection;
    @JoinColumn(name = "ID_PRIORIDAD", referencedColumnName = "IDPRIORIDAD")
    @ManyToOne
    private Prioridad idPrioridad;
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    @ManyToOne
    private TipoServicio idServicio;
    @JoinColumn(name = "SERIE_EQUIPO", referencedColumnName = "SERIE")
    @ManyToOne
    private Equipo serieEquipo;
    @OneToMany(mappedBy = "numIncidente")
    private Collection<EstadoIncidente> estadoIncidenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncidente")
    private Collection<Factura> facturaCollection;

    public Incidente() {
    }

    public Incidente(Integer numIncidente) {
        this.numIncidente = numIncidente;
    }

    public Integer getNumIncidente() {
        return numIncidente;
    }

    public void setNumIncidente(Integer numIncidente) {
        this.numIncidente = numIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<ParteReparacion> getParteReparacionCollection() {
        return parteReparacionCollection;
    }

    public void setParteReparacionCollection(Collection<ParteReparacion> parteReparacionCollection) {
        this.parteReparacionCollection = parteReparacionCollection;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public TipoServicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(TipoServicio idServicio) {
        this.idServicio = idServicio;
    }

    public Equipo getSerieEquipo() {
        return serieEquipo;
    }

    public void setSerieEquipo(Equipo serieEquipo) {
        this.serieEquipo = serieEquipo;
    }

    public Collection<EstadoIncidente> getEstadoIncidenteCollection() {
        return estadoIncidenteCollection;
    }

    public void setEstadoIncidenteCollection(Collection<EstadoIncidente> estadoIncidenteCollection) {
        this.estadoIncidenteCollection = estadoIncidenteCollection;
    }

    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIncidente != null ? numIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.numIncidente == null && other.numIncidente != null) || (this.numIncidente != null && !this.numIncidente.equals(other.numIncidente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Incidente[ numIncidente=" + numIncidente + " ]";
    }
    
}
