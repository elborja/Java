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
@Table(name = "tipo_servicio")
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t")
    , @NamedQuery(name = "TipoServicio.findByIdServicio", query = "SELECT t FROM TipoServicio t WHERE t.idServicio = :idServicio")
    , @NamedQuery(name = "TipoServicio.findByServicio", query = "SELECT t FROM TipoServicio t WHERE t.servicio = :servicio")})
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVICIO")
    private Integer idServicio;
    @Size(max = 45)
    @Column(name = "SERVICIO")
    private String servicio;
    @OneToMany(mappedBy = "idServicio")
    private Collection<Incidente> incidenteCollection;

    public TipoServicio() {
    }

    public TipoServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
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
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoServicio[ idServicio=" + idServicio + " ]";
    }
    
}
