/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class Etiqueta {
String et_nombre;
int et_id ;
String jui_id;

    public int getEt_id() {
        return et_id;
    }

    public void setEt_id(int et_id) {
        this.et_id = et_id;
    }

    public String getJui_id() {
        return jui_id;
    }

    public void setJui_id(String jui_id) {
        this.jui_id = jui_id;
    }

    public Etiqueta(int et_id, String jui_id) {
        this.et_id = et_id;
        this.jui_id = jui_id;
    }

    public String getEt_nombre() {
        return et_nombre;
    }

    public void setEt_nombre(String et_nombre) {
        this.et_nombre = et_nombre;
    }

    @Override
    public String toString() {
        return et_nombre;
    }

    public Etiqueta() {
    }
    public void poneretiqueta(){
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_etiqueta ?, ?");
        conn.AgregarParametroEntero("et_id", et_id);
        conn.AgregarParametroString("jui_id", jui_id);
        conn.EjecutarUpdate();
        conn.Desconectar();


    }
    public void quitaretiqueta(){
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_eliminar_etiqueta ?, ?");
        conn.AgregarParametroEntero("et_id", et_id);
        conn.AgregarParametroString("jui_id", jui_id);
        conn.EjecutarUpdate();
        conn.Desconectar();


    }

}
