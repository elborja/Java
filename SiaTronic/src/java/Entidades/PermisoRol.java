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
@Table(name = "permiso_rol")
@NamedQueries({
    @NamedQuery(name = "PermisoRol.findAll", query = "SELECT p FROM PermisoRol p")
    , @NamedQuery(name = "PermisoRol.findByIdPermisorol", query = "SELECT p FROM PermisoRol p WHERE p.idPermisorol = :idPermisorol")})
public class PermisoRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERMISOROL")
    private Integer idPermisorol;
    @JoinColumn(name = "ID_PERMISO", referencedColumnName = "ID_PERMISO")
    @ManyToOne(optional = false)
    private Permiso idPermiso;
    @JoinColumn(name = "ROL_IDROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private Rol rolIdrol;

    public PermisoRol() {
    }

    public PermisoRol(Integer idPermisorol) {
        this.idPermisorol = idPermisorol;
    }

    public Integer getIdPermisorol() {
        return idPermisorol;
    }

    public void setIdPermisorol(Integer idPermisorol) {
        this.idPermisorol = idPermisorol;
    }

    public Permiso getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Permiso idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisorol != null ? idPermisorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoRol)) {
            return false;
        }
        PermisoRol other = (PermisoRol) object;
        if ((this.idPermisorol == null && other.idPermisorol != null) || (this.idPermisorol != null && !this.idPermisorol.equals(other.idPermisorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PermisoRol[ idPermisorol=" + idPermisorol + " ]";
    }
    
}
