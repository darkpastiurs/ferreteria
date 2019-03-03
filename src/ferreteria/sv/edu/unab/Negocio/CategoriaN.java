package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Categoria>> listadoCategoria=()->{
        LOG.log(Level.INFO,"[CategoriaN][INIT]->Listado de Categorias");
        {
            Query query=em.createNamedQuery("Categoria.findAll");
            List<Categoria> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };
    public Consumer<Categoria> guardarCategoria=(c)->{
         LOG.log(Level.INFO,"[CategoriaN][INIT]->Guardar Categoria");
         try {
              em.getTransaction().begin();
              if(c.getId()==null){
                  em.persist(c);
              }else{
                  Categoria cat=em.find(Categoria.class, c.getId());
                  cat.setId(c.getId());
                  cat.setNombre(c.getNombre());
                  em.merge(cat);
              }                
              em.getTransaction().commit();
          }catch (Exception e){
              em.getTransaction().rollback();
          }finally {
              em.close();
          }
    };
    public Consumer<Categoria> eliminarCategoria=(m)->{
        LOG.log(Level.INFO,"[CategoriaN][INIT]->Eliminar Categoria");
        try{
            em.getTransaction().begin();
            Categoria categoria=em.find(Categoria.class,m.getId());
            em.remove(categoria);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
}
