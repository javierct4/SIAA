/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

import java.sql.ResultSet;

/**
 *
 * @author MEGASYSTEM
 */
public class Judicatura {
    String jud_id;
    String jud_nombre;

    public Judicatura() {
    }

    public String getJud_id() {
        return jud_id;
    }

    public void setJud_id(String jud_id) {
        this.jud_id = jud_id;
    }

    public String getJud_nombre() {
        return jud_nombre;
    }

    public void setJud_nombre(String jud_nombre) {
        this.jud_nombre = jud_nombre;
    }

    public Judicatura(String jud_id, String jud_nombre) {
        this.jud_id = jud_id;
        this.jud_nombre = jud_nombre;
    }

    @Override
    public String toString() {
        return  jud_nombre ;
    }

    public boolean BuscarJudicatura(){
        try{
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_select_judicatura ?");
        conn.AgregarParametroString("jud_id", jud_id);
        rs=conn.EjecutarComando();
        if(rs.next())
            return true;
        else
            return false;
       }catch(Exception ex){
          System.out.println("No existe judicatura: sp_colsultar_judicatura"+ex);
          return false;
        }
    }

}
