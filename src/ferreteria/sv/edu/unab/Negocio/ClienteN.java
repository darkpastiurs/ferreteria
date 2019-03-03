package ferreteria.sv.edu.unab.Negocio;

import java.util.List;
import java.util.function.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import ferreteria.sv.edu.unab.Dominio.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteN{

    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Cliente>> listadoClientes=()->{
        LOG.log(Level.INFO,"[ClienteN][INIT]->Listado de Clientes");
        {
            Query query=em.createNamedQuery("Cliente.findAll");
            List<Cliente> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };

    public Consumer<Cliente> insertarCliente=(c)->{
        LOG.log(Level.INFO,"[ClienteN][INIT]->Insertar Cliente");
        try {
            em.getTransaction().begin();
            em.persist(c);           
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
     public Consumer<Cliente> actualizarCliente=(c)->{
        LOG.log(Level.INFO,"[ClienteN][INIT]->Actualizar Cliente");
        try {
            em.getTransaction().begin();
                Cliente cl=em.find(Cliente.class,c.getId());
                cl.setDatosPersonales(c.getDatosPersonales());
                cl.setDatosMunicipio(c.getDatosMunicipio());
                em.merge(cl);                                     
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
    public Consumer<Cliente> eliminarCliente=(c)->{
        LOG.log(Level.INFO,"[ClienteN][INIT]->Eliminar Cliente");
        try{
            em.getTransaction().begin();
            Cliente cl=em.find(Cliente.class,c.getId());
            em.remove(cl);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
}