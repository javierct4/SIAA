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
public class Delitos {
    int del_id;
    String del_nombre;

    public int getDel_id() {
        return del_id;
    }

    public void setDel_id(int del_id) {
        this.del_id = del_id;
    }

    public String getDel_nombre() {
        return del_nombre;
    }

    public void setDel_nombre(String del_nombre) {
        this.del_nombre = del_nombre;
    }

    public Delitos(int del_id, String del_nombre) {
        this.del_id = del_id;
        this.del_nombre = del_nombre;
    }

    public Delitos() {
    }

    @Override
    public String toString() {
        return del_nombre;
    }
    public void cargarNombre(){
            ResultSet rs = null;
            BaseDatos conn = new BaseDatos("INVENTARIO");
            conn.Conectar();
            conn.CrearStoreProcedure("exec proc_buscar_delito ?");
            conn.AgregarParametroEntero("del_id",del_id);
            rs=conn.EjecutarComando();
            try{

              //this.tkardex.setModel(modelo);
               if(rs.next()){      
                       del_nombre=rs.getString("del_nombre");
                }
               rs.close();
                    
            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al ejecutar comando...Error:"+ex);
           }
    }


}
