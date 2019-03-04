/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Articulo;
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
public class ArticuloN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Articulo>> listadoArticulos=()->{
        LOG.log(Level.INFO,"[ArticuloN][INIT]->Listado de Articulos");
        {
            em.getEntityManagerFactory().getCache().evictAll();
            Query query=em.createNamedQuery("Articulo.findAll");
            List<Articulo> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };
    public Consumer<Articulo> guardarArticulo=(a)->{
        LOG.log(Level.INFO,"[ArticuloN][INIT]->Guardar Articulo");
        try {
            em.getTransaction().begin();
            if(a.getId()==null||a.getId()==0){
                em.persist(a);
            }else{
                Articulo articulo=em.find(Articulo.class,a.getId());
                articulo.setId(a.getId());
                articulo.setCodigo(a.getCodigo());
                articulo.setNombre(a.getNombre());
                articulo.setDescripcion(a.getDescripcion());
                articulo.setDatosMarca(a.getDatosMarca());
                articulo.setDatosCategoria(a.getDatosCategoria());
                articulo.setDatosUnidad(a.getDatosUnidad());
                em.merge(articulo);
            }            
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
    public Consumer<Articulo> eliminarArticulo=(a)->{
        LOG.log(Level.INFO,"[ArticuloN][INIT]->Eliminar Articulo");
        try{
            em.getTransaction().begin();
            Articulo articulo=em.find(Articulo.class,a.getId());
            em.remove(articulo);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    };
    
}
