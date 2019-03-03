package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarcaN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Marca>> listadoMarcas=()->{
        LOG.log(Level.INFO,"[MarcaN][INIT]->Listado de Marcas");
        {
            Query query=em.createNamedQuery("Marca.findAll");
            List<Marca> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };
    public Consumer<Marca> guardarMarca=(m)->{
        LOG.log(Level.INFO,"[MarcaN][INIT]->Guardar Marca");
        try {
            em.getTransaction().begin();
            if(m.getId()==null){
                em.persist(m);
            }
            else{
                Marca marca=em.find(Marca.class,m.getId());
                marca.setId(m.getId());
                marca.setNombre(m.getNombre());
                em.merge(marca);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
    public Consumer<Marca> eliminarMarca=(m)->{
        LOG.log(Level.INFO,"[MarcaN][INIT]->Eliminar Marca");
        try{
            em.getTransaction().begin();
            Marca ma=em.find(Marca.class,m.getId());
            em.remove(ma);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
}
