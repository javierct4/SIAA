/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class LitigantesM {

    int lit_id;
    String lit_nombre;
    String lit_tipo;
    String jui_id;

    public LitigantesM() {
    }

    public LitigantesM(int lit_id, String lit_nombre, String lit_tipo, String jui_id) {
        this.lit_id = lit_id;
        this.lit_nombre = lit_nombre;
        this.lit_tipo = lit_tipo;
        this.jui_id = jui_id;
    }

    public String getJui_id() {
        return jui_id;
    }

    public void setJui_id(String jui_id) {
        this.jui_id = jui_id;
    }

    public int getLit_id() {
        return lit_id;
    }

    public void setLit_id(int lit_id) {
        this.lit_id = lit_id;
    }

    public String getLit_nombre() {
        return lit_nombre;
    }

    public void setLit_nombre(String lit_nombre) {
        this.lit_nombre = lit_nombre;
    }

    public String getLit_tipo() {
        return lit_tipo;
    }

    public void setLit_tipo(String lit_tipo) {
        this.lit_tipo = lit_tipo;
    }

    @Override
    public String toString() {
        
        String cadena;
        if (jui_id!=null)
           cadena=lit_nombre ;
        else
            cadena = lit_nombre;
        return cadena;
    }
    
  
    public boolean GuardarLitigante(){
        try{
        //ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_litigantes ?, ?, ?, ?");
        conn.AgregarParametroEntero("lit_id", lit_id);
        conn.AgregarParametroString("lit_nombre", lit_nombre);
        conn.AgregarParametroString("lit_tipo", lit_tipo);
        conn.AgregarParametroString("jui_id", jui_id);
              conn.EjecutarUpdate();
                conn.Desconectar();
                return true;
               }catch(Exception ex){
                  System.out.println("Error al guardar el registro sp_guardar_litigante: "+ex);
                  return false;
                }
            }





}
