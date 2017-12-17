/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Administrador
 */
@Named(value = "permisoRolCon")
@SessionScoped
public class PermisoRolCon implements Serializable {

    /**
     * Creates a new instance of PermisoRolCon
     */
    public PermisoRolCon() {
    }
    
}
