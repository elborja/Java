/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "estado_incidente")
@NamedQueries({
    @NamedQuery(name = "EstadoIncidente.findAll", query = "SELECT e FROM EstadoIncidente e")
    , @NamedQuery(name = "EstadoIncidente.findByIdEstadoIncidente", query = "SELECT e FROM EstadoIncidente e WHERE e.idEstadoIncidente = :idEstadoIncidente")
    , @NamedQuery(name = "EstadoIncidente.findByFechaModificacion", query = "SELECT e FROM EstadoIncidente e WHERE e.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "EstadoIncidente.findByDescripcion", query = "SELECT e FROM EstadoIncidente e WHERE e.descripcion = :descripcion")})
public class EstadoIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_INCIDENTE")
    private Integer idEstadoIncidente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_ESTADO_IN", referencedColumnName = "ID_ESTADO_IN")
    @ManyToOne
    private ListaEstado idEstadoIn;
    @JoinColumn(name = "NUM_INCIDENTE", referencedColumnName = "NUM_INCIDENTE")
    @ManyToOne
    private Incidente numIncidente;

    public EstadoIncidente() {
    }

    public EstadoIncidente(Integer idEstadoIncidente) {
        this.idEstadoIncidente = idEstadoIncidente;
    }

    public EstadoIncidente(Integer idEstadoIncidente, Date fechaModificacion) {
        this.idEstadoIncidente = idEstadoIncidente;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdEstadoIncidente() {
        return idEstadoIncidente;
    }

    public void setIdEstadoIncidente(Integer idEstadoIncidente) {
        this.idEstadoIncidente = idEstadoIncidente;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ListaEstado getIdEstadoIn() {
        return idEstadoIn;
    }

    public void setIdEstadoIn(ListaEstado idEstadoIn) {
        this.idEstadoIn = idEstadoIn;
    }

    public Incidente getNumIncidente() {
        return numIncidente;
    }

    public void setNumIncidente(Incidente numIncidente) {
        this.numIncidente = numIncidente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoIncidente != null ? idEstadoIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIncidente)) {
            return false;
        }
        EstadoIncidente other = (EstadoIncidente) object;
        if ((this.idEstadoIncidente == null && other.idEstadoIncidente != null) || (this.idEstadoIncidente != null && !this.idEstadoIncidente.equals(other.idEstadoIncidente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EstadoIncidente[ idEstadoIncidente=" + idEstadoIncidente + " ]";
    }
    
}
