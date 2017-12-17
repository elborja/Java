/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Equipo;
import Entidades.TipoEquipo;
import Facades.EquipoFacade;
import Facades.TipoEquipoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "tipoEquipoCon")
@SessionScoped
public class TipoEquipoCon implements Serializable {

    /**
     * Creates a new instance of TipoEquipoCon
     */
    public TipoEquipoCon() {
    }
    
    @EJB
    TipoEquipoFacade tipoequipofacade;
    TipoEquipo tipoequipo = new TipoEquipo ();
    
    @EJB
    EquipoFacade equipofacade;
    Equipo equipo = new Equipo();

    public TipoEquipo getTipoequipo() {
        return tipoequipo;
    }

    public void setTipoequipo(TipoEquipo tipoequipo) {
        this.tipoequipo = tipoequipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
    public String registrarTipoEquipo(){
        tipoequipofacade.create(tipoequipo);
        return "RegistrarTipoEquipo";
    }
    
    public List <TipoEquipo> listarTipoEquipo(){
        return tipoequipofacade.findAll();
    }
    
    
    public String actualizarTipoEquipo (TipoEquipo objtipoequipo){
        tipoequipo = objtipoequipo;
       
        return "ClienteActualizarTipoEquipo";
    }
    public String actualizarTipoEquipo1 (){
      tipoequipofacade.edit(tipoequipo);
      return "ClienteListarTipoEquipo";
      }
    
    public String eliminarTipoEquipo (TipoEquipo objtipoequipo){
        tipoequipo = objtipoequipo;
        tipoequipofacade.remove(tipoequipo);
        return "ClienteListarTipoEquipo";
    }
    
    
    
}
