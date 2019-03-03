package ferreteria.sv.edu.unab.Negocio;

import ferreteria.sv.edu.unab.Dominio.Departamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoN {
    private static final Logger LOG=Logger.getLogger("sv.edu.unab.FerreteriaLupycar");
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("ferreteriaPU");
    EntityManager em=emf.createEntityManager();

    public Supplier<List<Departamento>> listadoDepa=()->{
        LOG.log(Level.INFO,"[DepartamentoN][INIT]->Listado de Departamentos");
        {
            Query query=em.createNamedQuery("Departamento.findAll");
            List<Departamento> listado=query.getResultList();

            if (!listado.isEmpty()&&listado.size()>0){
                return listado;
            }else{
                return null;
            }
        }
    };
}
