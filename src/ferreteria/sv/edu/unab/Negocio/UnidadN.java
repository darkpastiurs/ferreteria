package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Unidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Unidad>> listadoUnidades=()->{
        LOG.log(Level.INFO,"[UnidadN][INIT]->Listado de Unidades");
        {
            Query query=em.createNamedQuery("Unidad.findAll");
            List<Unidad> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };
    public Consumer<Unidad> guardarUnidad=(u)->{
        LOG.log(Level.INFO,"[UnidadN][INIT]->Guardar Unidad");
        try {
            em.getTransaction().begin();
            if(u.getId()==null){
                em.persist(u);
            }
            else{
                Unidad unidad=em.find(Unidad.class,u.getId());
                unidad.setId(u.getId());
                unidad.setNombre(u.getNombre());
                em.merge(unidad);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
    public Consumer<Unidad> eliminarUnidad=(m)->{
        LOG.log(Level.INFO,"[UnidadN][INIT]->Eliminar Unidad");
        try{
            em.getTransaction().begin();
            Unidad unidad=em.find(Unidad.class,m.getId());
            em.remove(unidad);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
}
