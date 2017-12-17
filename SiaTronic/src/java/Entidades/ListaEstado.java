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
@Table(name = "lista_estado")
@NamedQueries({
    @NamedQuery(name = "ListaEstado.findAll", query = "SELECT l FROM ListaEstado l")
    , @NamedQuery(name = "ListaEstado.findByIdEstadoIn", query = "SELECT l FROM ListaEstado l WHERE l.idEstadoIn = :idEstadoIn")
    , @NamedQuery(name = "ListaEstado.findByEstado", query = "SELECT l FROM ListaEstado l WHERE l.estado = :estado")})
public class ListaEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_IN")
    private Integer idEstadoIn;
    @Size(max = 45)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idEstadoIn")
    private Collection<EstadoIncidente> estadoIncidenteCollection;

    public ListaEstado() {
    }

    public ListaEstado(Integer idEstadoIn) {
        this.idEstadoIn = idEstadoIn;
    }

    public Integer getIdEstadoIn() {
        return idEstadoIn;
    }

    public void setIdEstadoIn(Integer idEstadoIn) {
        this.idEstadoIn = idEstadoIn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<EstadoIncidente> getEstadoIncidenteCollection() {
        return estadoIncidenteCollection;
    }

    public void setEstadoIncidenteCollection(Collection<EstadoIncidente> estadoIncidenteCollection) {
        this.estadoIncidenteCollection = estadoIncidenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoIn != null ? idEstadoIn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaEstado)) {
            return false;
        }
        ListaEstado other = (ListaEstado) object;
        if ((this.idEstadoIn == null && other.idEstadoIn != null) || (this.idEstadoIn != null && !this.idEstadoIn.equals(other.idEstadoIn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ListaEstado[ idEstadoIn=" + idEstadoIn + " ]";
    }
    
}
