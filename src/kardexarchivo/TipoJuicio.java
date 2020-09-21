/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edwin.cevallost
 */
public class TipoJuicio {
int tip_id;
String tip_nombre;

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_nombre() {
        return tip_nombre;
    }

    public void setTip_nombre(String tip_nombre) {
        this.tip_nombre = tip_nombre;
    }

    public TipoJuicio(int tip_id, String tip_nombre) {
        this.tip_id = tip_id;
        this.tip_nombre = tip_nombre;
    }

    public TipoJuicio() {
    }

    @Override
    public String toString() {
        return tip_nombre;
    }

    public void cargarNombre(){
            ResultSet rs = null;
            BaseDatos conn = new BaseDatos("INVENTARIO");
            conn.Conectar();
            conn.CrearStoreProcedure("exec proc_buscar_tipoaccion ?");
            conn.AgregarParametroEntero("tip_id", tip_id);
            rs=conn.EjecutarComando();
            try{

              //this.tkardex.setModel(modelo);
               if(rs.next()){      
                       tip_nombre=rs.getString("tip_nombre");
                }
               rs.close();
                    
            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al ejecutar comando...Error:"+ex);
           }
    }
    
}
