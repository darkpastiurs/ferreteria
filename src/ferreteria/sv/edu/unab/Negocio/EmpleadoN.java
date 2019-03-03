package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Empleado>> listadoEmpleados=()->{
        LOG.log(Level.INFO,"[EmpleadoN][INIT]->Listado de Empleados");
        
        Query query=em.createNamedQuery("Empleado.findAll");
        List<Empleado> listado=query.getResultList();
        return listado;
    };
    public Consumer<Empleado> guardarEmpleado= e->{
        LOG.log(Level.INFO,"[EmpleadoN][INIT]->Guardar Empleado");
        try {
            em.getTransaction().begin();
            if(e.getId()!=null){
                Empleado emp=em.find(Empleado.class,e.getId());
                emp.setDatosPersonales(e.getDatosPersonales());
                emp.setIsss(e.getIsss());
                emp.setAfp(e.getAfp());
                em.merge(emp);
            }else{
                em.persist(e);
            }            
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    };
    public Consumer<Empleado> eliminarEmpleado=e->{
        LOG.log(Level.INFO,"[EmpleadoN][INIT]->Remover Empleado");
        try{
            em.getTransaction().begin();
            Empleado emp = em.find(Empleado.class, e.getId());
            em.remove(emp);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    };
}
