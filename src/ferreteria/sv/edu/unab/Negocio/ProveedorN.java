/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Proveedor;
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
public class ProveedorN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Proveedor>> listadoProveedores=()->{
        LOG.log(Level.INFO,"[ProveedorN][INIT]->Listado de Proveedores");
        
        Query query=em.createNamedQuery("Proveedor.findAll");
        List<Proveedor> listado=query.getResultList();
        return listado;
    };
    public Consumer<Proveedor> guardarProveedor= p->{
        LOG.log(Level.INFO,"[ProveedorN][INIT]->Guardar Proveedor");
        try {
            em.getTransaction().begin();
            if(p.getId()==null||p.getId()==0){
                em.persist(p);               
            }else{
                Proveedor pro=em.find(Proveedor.class,p.getId());
                pro.setDatosPersonales(p.getDatosPersonales());
                em.merge(pro);
            }            
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    };
    public Consumer<Proveedor> eliminarProveedor=p->{
        LOG.log(Level.INFO,"[ProveedorN][INIT]->Remover Proveedor");
        try{
            em.getTransaction().begin();
            Proveedor pro = em.find(Proveedor.class, p.getId());
            em.remove(pro);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    };
    
}
