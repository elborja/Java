/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "parte_reparacion")
@NamedQueries({
    @NamedQuery(name = "ParteReparacion.findAll", query = "SELECT p FROM ParteReparacion p")
    , @NamedQuery(name = "ParteReparacion.findByIdDetalle", query = "SELECT p FROM ParteReparacion p WHERE p.idDetalle = :idDetalle")
    , @NamedQuery(name = "ParteReparacion.findByCantidad", query = "SELECT p FROM ParteReparacion p WHERE p.cantidad = :cantidad")})
public class ParteReparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "NUM_INCIDENTE", referencedColumnName = "NUM_INCIDENTE")
    @ManyToOne(optional = false)
    private Incidente numIncidente;
    @JoinColumn(name = "PARTE_SERIE", referencedColumnName = "SERIE")
    @ManyToOne(optional = false)
    private Inventario parteSerie;

    public ParteReparacion() {
    }

    public ParteReparacion(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Incidente getNumIncidente() {
        return numIncidente;
    }

    public void setNumIncidente(Incidente numIncidente) {
        this.numIncidente = numIncidente;
    }

    public Inventario getParteSerie() {
        return parteSerie;
    }

    public void setParteSerie(Inventario parteSerie) {
        this.parteSerie = parteSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParteReparacion)) {
            return false;
        }
        ParteReparacion other = (ParteReparacion) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ParteReparacion[ idDetalle=" + idDetalle + " ]";
    }
    
}
