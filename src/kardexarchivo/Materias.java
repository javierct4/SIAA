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
public class Materias {
    int mat_id;
   String mat_nombre;

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_nombre() {
        return mat_nombre;
    }

    public void setMat_nombre(String mat_nombre) {
        this.mat_nombre = mat_nombre;
    }

    @Override
    public String toString() {
        return mat_nombre;
    }

    public Materias(int mat_id, String mat_nombre) {
        this.mat_id = mat_id;
        this.mat_nombre = mat_nombre;
    }

    public Materias() {
    }

    public void cargarNombre(){
            ResultSet rs = null;
            BaseDatos conn = new BaseDatos("INVENTARIO");
            conn.Conectar();
            conn.CrearStoreProcedure("exec proc_buscar_materia ?");
            conn.AgregarParametroEntero("mat_id", mat_id);
            rs=conn.EjecutarComando();
            try{

              //this.tkardex.setModel(modelo);
               if(rs.next()){      
                       mat_nombre=rs.getString("mat_nombre");
                }
               rs.close();
                    
            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al ejecutar comando...Error:"+ex);
           }
    }

}
