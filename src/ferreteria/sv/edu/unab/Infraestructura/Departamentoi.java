package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Departamento;
import ferreteria.sv.edu.unab.Negocio.DepartamentoN;

import java.util.List;
import java.util.function.Supplier;

public class Departamentoi {
    DepartamentoN dn=new DepartamentoN();
    public Supplier<List<Departamento>> listado= dn.listadoDepa::get;
}
