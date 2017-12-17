/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Usuario;
import Entidades.UsuarioContrasena;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioContrasenaFacade extends AbstractFacade<UsuarioContrasena> {

    @PersistenceContext(unitName = "SiaTronicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioContrasenaFacade() {
        super(UsuarioContrasena.class);
    }
    
    /*
    public UsuarioContrasena inciarSesion(UsuarioContrasena us){
        UsuarioContrasena usuariocontrasena = null;
        String consulta;
        
        try {
            consulta = "from UsuarioContrasena u where u.usuario= ?1 and u.contrasena= ?2";
        Query query = em.createQuery(consulta);
        query.setParameter(1,us.getUsuario()); en esta linea debe ser Getusurio
        query.setParameter(2, us.getContrasena()); verificar si estos dos sin se llaman asi SETPARAMETER
        
        List<UsuarioContrasena> lista = query.getResultList();
        if(!lista.isEmpty()){
            usuariocontrasena=lista.get(0);
        }
        
        
        } catch (Exception e){
            throw e;
            
        } finally {
            //em.close();
        }
        return usuariocontrasena;
    }
    
    */
    
    
    public UsuarioContrasena iniciarSesion(UsuarioContrasena uc){
        UsuarioContrasena usuariocontrasena = null;
        String consulta;
        try{
            consulta ="FROM UsuarioContrasena u WHERE u.usuario = ?1 and u.contrasena = ?2";
            Query query =em.createQuery(consulta);
            query.setParameter(1,uc.getUsuario());
            query.setParameter(2,uc.getContrasena());
            
            List<UsuarioContrasena> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuariocontrasena = lista.get(0);
            }
        } catch(Exception e){
            throw e;
        } 
        return usuariocontrasena;
    }
    
}
