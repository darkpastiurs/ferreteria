/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.TipoUsuario;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author anton
 */
public class TipoUsuarioN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<TipoUsuario>> listadoTipoUsuario=()->{
        LOG.log(Level.INFO,"[TipoUsuarioN][INIT]->Listado de Tipos de Usuario");
        
        Query query=em.createNamedQuery("TipoUsuario.findAll");
        List<TipoUsuario> listado=query.getResultList();
        return listado;
    };
    
}
