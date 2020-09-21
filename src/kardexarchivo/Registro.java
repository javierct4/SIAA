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
public class Registro {
	int kar_id;
	String jui_id;
	String kar_resp_entrega;
	String kar_resp_recibe;
        String tipo;
	int tip_id;
        String ubicacion;
	int ubi_id ;
	String kar_proposito;
	String usu_id;
        String kar_fecha;
        String kar_hora;

    public String getJui_id() {
        return jui_id;
    }

    public void setJui_id(String jui_id) {
        this.jui_id = jui_id;
    }

    public int getKar_id() {
        return kar_id;
    }

    public void setKar_id(int kar_id) {
        this.kar_id = kar_id;
    }

    public String getKar_proposito() {
        return kar_proposito;
    }

    public void setKar_proposito(String kar_proposito) {
        this.kar_proposito = kar_proposito;
    }

    public String getKar_resp_entrega() {
        return kar_resp_entrega;
    }

    public void setKar_resp_entrega(String kar_resp_entrega) {
        this.kar_resp_entrega = kar_resp_entrega;
    }

    public String getKar_resp_recibe() {
        return kar_resp_recibe;
    }

    public void setKar_resp_recibe(String kar_resp_recibe) {
        this.kar_resp_recibe = kar_resp_recibe;
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public int getUbi_id() {
        return ubi_id;
    }

    public void setUbi_id(int ubi_id) {
        this.ubi_id = ubi_id;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }

    public Registro(String jui_id, String kar_resp_entrega, String kar_resp_recibe, int tip_id, int ubi_id, String kar_proposito, String usu_id) {
        this.jui_id = jui_id;
        this.kar_resp_entrega = kar_resp_entrega;
        this.kar_resp_recibe = kar_resp_recibe;
        this.tip_id = tip_id;
        this.ubi_id = ubi_id;
        this.kar_proposito = kar_proposito;
        this.usu_id = usu_id;
    }

 public Registro(int kar_id,String jui_id, String kar_resp_entrega, String kar_resp_recibe, int tip_id, int ubi_id, String kar_proposito, String usu_id,String fecha, String hora ) {
        this.kar_id=kar_id;
        this.jui_id = jui_id;
        this.kar_resp_entrega = kar_resp_entrega;
        this.kar_resp_recibe = kar_resp_recibe;
        this.tip_id = tip_id;
        this.ubi_id = ubi_id;
        this.kar_proposito = kar_proposito;
        this.usu_id = usu_id;
        this.kar_fecha= fecha;
        this.kar_hora=hora;
    }
    public Registro() {
    }

    
public void GuardarRegistro(){
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_kardex ?, ?, ?, ?, ?,?,?,?,?");
        conn.AgregarParametroEntero("kar_id", kar_id);
        conn.AgregarParametroString("jui_id", jui_id);
        conn.AgregarParametroString("kar_resp_entrega", kar_resp_entrega);
        conn.AgregarParametroString("kar_resp_recibe", kar_resp_recibe);
        conn.AgregarParametroEntero("tip_id", tip_id);
        conn.AgregarParametroEntero("ubi_id",ubi_id);
        conn.AgregarParametroString("kar_proposito", kar_proposito);
        conn.AgregarParametroString("usu_id",usu_id);
         conn.AgregarParametroString("kar_fecha","");
        conn.EjecutarUpdate();
        conn.Desconectar();
        
}

public boolean CargarRegistros(int _kar_id){
try{
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_buscar_registros_kardex ?");
        conn.AgregarParametroEntero("kar_id", _kar_id);

        rs=conn.EjecutarComando();
        if (rs.next()){
           kar_id=rs.getInt("kar_id");
           kar_resp_entrega=rs.getString("ENTREGO");
           kar_resp_recibe=rs.getString("RECIBIO");
           tipo=rs.getString("TIPO");
           tip_id=rs.getInt("tip_id");
           ubicacion=rs.getString("UBICACION");
           ubi_id=rs.getInt("ubi_id");
           kar_proposito=rs.getString("PROPOSITO");
           kar_fecha=rs.getString("FECHA");
           return true;

        } else
            return false;
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_juicio: "+ex);
          return true;
        }

}
public void ActualizarRegistro(){
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_kardex ?, ?, ?, ?, ?,?,?,?,?");
        conn.AgregarParametroEntero("kar_id", kar_id);
        conn.AgregarParametroString("jui_id", jui_id);
        conn.AgregarParametroString("kar_resp_entrega", kar_resp_entrega);
        conn.AgregarParametroString("kar_resp_recibe", kar_resp_recibe);
        conn.AgregarParametroEntero("tip_id", tip_id);
        conn.AgregarParametroEntero("ubi_id",ubi_id);
        conn.AgregarParametroString("kar_proposito", kar_proposito);
        conn.AgregarParametroString("usu_id",usu_id);
        conn.AgregarParametroString("kar_fecha", (kar_fecha+" "+kar_hora));
        conn.EjecutarUpdate();
        conn.Desconectar();

}
public boolean CargarRegistrosActualizar(int _kar_id){
try{
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_buscar_registros_kardex ?");
        conn.AgregarParametroEntero("kar_id", _kar_id);

        rs=conn.EjecutarComando();
        if (rs.next()){
           kar_id=rs.getInt("kar_id");
           kar_resp_entrega=rs.getString("ENTREGO");
           kar_resp_recibe=rs.getString("RECIBIO");
           tipo=rs.getString("TIPO");
           tip_id=rs.getInt("tip_id");
           ubicacion=rs.getString("UBICACION");
           ubi_id=rs.getInt("ubi_id");
           kar_proposito=rs.getString("PROPOSITO");
           kar_fecha=rs.getString("FECHA");
           kar_hora=rs.getString("HORA");
           return true;

        } else
            return false;
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_juicio: "+ex);
          return true;
        }

}

}
