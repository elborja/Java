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
@Named(value = "permisoCon")
@SessionScoped
public class PermisoCon implements Serializable {

    /**
     * Creates a new instance of PermisoCon
     */
    public PermisoCon() {
    }
    
}
