/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kardexarchivo;

//import java.sql.ResultSet;

    
/**
 *
 * @author edwin.cevallost
 */
public class SolicitudDetalle {
    private int sol_numero;
    private Juicio juicio;

    public Juicio getJuicio() {
        return juicio;
    }

    public int getSol_numero() {
        return sol_numero;
    }

    public void setJuicio(Juicio juicio) {
        this.juicio = juicio;
    }

    public void setSol_numero(int sol_numero) {
        this.sol_numero = sol_numero;
    }

    public SolicitudDetalle(int sol_numero, Juicio juicio) {
        this.sol_numero = sol_numero;
        this.juicio = juicio;
    }
    
    public boolean GuardarDetalle(){
    try{
        //ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_solicitud_detalle ?, ?");
        conn.AgregarParametroEntero("sol_id", this.sol_numero);
        conn.AgregarParametroString("jui_id", this.juicio.jui_id);
         //System.out.println("guardar juicio");
     
         conn.EjecutarComando();        
       
         // rs.close();
          conn.Desconectar();
          return true;  
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_juicio: "+ex);
          return false;
        }
    }
    
}
