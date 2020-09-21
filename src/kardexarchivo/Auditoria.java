/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kardexarchivo;

/**
 *
 * @author SMART14pro
 */
public class Auditoria {
   private int aud_id;
   private String jui_id;
   private String usu_id;
   private String aud_motivo ;
   private String aud_tabla ;

    public Auditoria() {
    }

    public int getAud_id() {
        return aud_id;
    }

    public String getAud_motivo() {
        return aud_motivo;
    }

    public String getAud_tabla() {
        return aud_tabla;
    }

    public String getJui_id() {
        return jui_id;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setAud_id(int aud_id) {
        this.aud_id = aud_id;
    }

    public void setAud_motivo(String aud_motivo) {
        this.aud_motivo = aud_motivo;
    }

    public void setAud_tabla(String aud_tabla) {
        this.aud_tabla = aud_tabla;
    }

    public void setJui_id(String jui_id) {
        this.jui_id = jui_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }
        
     public boolean GuardarAuditoria(){

     try{

        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_auditoria ?,?,  ?,?,?");
        conn.AgregarParametroEntero("aud_id", aud_id);
        conn.AgregarParametroString("jui_id", jui_id);
        conn.AgregarParametroString("usu_id", usu_id);
        conn.AgregarParametroString("aud_motivo",aud_motivo);
        conn.AgregarParametroString("aud_tabla", aud_tabla);

        conn.EjecutarUpdate();
        conn.Desconectar();
        return true;
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_auditoria: "+ex);
          return false;
        }
     }
}
