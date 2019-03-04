/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.TipoUsuario;
import ferreteria.sv.edu.unab.Negocio.TipoUsuarioN;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author anton
 */

public class TipoUsuarioi {
    TipoUsuarioN tn =new TipoUsuarioN();
    public Supplier<List<TipoUsuario>> listadoTipo= tn.listadoTipoUsuario::get;
}
