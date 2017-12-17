/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "prioridad")
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByIdprioridad", query = "SELECT p FROM Prioridad p WHERE p.idprioridad = :idprioridad")
    , @NamedQuery(name = "Prioridad.findByPrioridad", query = "SELECT p FROM Prioridad p WHERE p.prioridad = :prioridad")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRIORIDAD")
    private Integer idprioridad;
    @Size(max = 45)
    @Column(name = "PRIORIDAD")
    private String prioridad;
    @OneToMany(mappedBy = "idPrioridad")
    private Collection<Incidente> incidenteCollection;

    public Prioridad() {
    }

    public Prioridad(Integer idprioridad) {
        this.idprioridad = idprioridad;
    }

    public Integer getIdprioridad() {
        return idprioridad;
    }

    public void setIdprioridad(Integer idprioridad) {
        this.idprioridad = idprioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprioridad != null ? idprioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.idprioridad == null && other.idprioridad != null) || (this.idprioridad != null && !this.idprioridad.equals(other.idprioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Prioridad[ idprioridad=" + idprioridad + " ]";
    }
    
}
