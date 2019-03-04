/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Proveedor;
import ferreteria.sv.edu.unab.Dominio.Usuario;
import java.util.List;
import java.util.function.Consumer;
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
public class UsuarioN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Usuario>> listadoUsuarios=()->{
        LOG.log(Level.INFO,"[UsuarioN][INIT]->Listado de Usuarios");
        
        Query query=em.createNamedQuery("Usuario.findAll");
        List<Usuario> listado=query.getResultList();
        return listado;
    };
    public Consumer<Usuario> guardarUsuario= u->{
        LOG.log(Level.INFO,"[UsuarioN][INIT]->Guardar Usuario");
        try {
            em.getTransaction().begin();
            em.persist(u);                      
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    };
    public Consumer<Usuario> eliminarUsuario=u->{
        LOG.log(Level.INFO,"[UsuarioN][INIT]->Remover Usuario");
        try{
            em.getTransaction().begin();
            Usuario user = em.find(Usuario.class, u.getNombre());
            em.remove(user);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    };
    
}
