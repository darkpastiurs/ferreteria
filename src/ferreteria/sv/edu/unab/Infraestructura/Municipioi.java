package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Municipio;
import ferreteria.sv.edu.unab.Negocio.MunicipioN;

import java.util.List;
import java.util.function.Supplier;

public class Municipioi {
    MunicipioN dn=new MunicipioN();
    public Supplier<List<Municipio>> listado= dn.listadoMuni::get;
}
