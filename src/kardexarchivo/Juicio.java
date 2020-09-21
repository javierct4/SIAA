/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;
import java.sql.ResultSet;

/**
 *
 * @author edwin.cevallost
 */
public class Juicio {
        String jui_id ;
	String jud_id;
	String jui_actor;
	String jui_demandado;
	String jui_juez;
	String jui_secretario;
	int jui_cuerpos;
	String jui_naturaleza;
	int resp_id;
	String jui_ubicacion;
        int jui_fojas;
        String jui_observaciones;
        int tip_id;
        int del_id;
        int mat_id;
        String usu_id;
        String jui_sector;
        String jui_estanteria;
        String jui_bandeja;
        String jui_caja;
//Constructor
    public Juicio() {
    }

   //Constructor con variables
    public Juicio(String _jui_id, String _jud_id, String _jui_actor, String _jui_demandado, String _jui_juez, String _jui_secretario,  int _jui_ano, String _jui_naturaleza, int _resp_id, String _jui_ubicacion, int _jui_fojas, String _jui_observaciones,int _tip_id,int _del_id,int _mat_id) {
        this.jui_id = _jui_id;
        this.jud_id = _jud_id;
        this.jui_actor = _jui_actor;
        this.jui_demandado = _jui_demandado;
        this.jui_juez = _jui_juez;
        this.jui_secretario = _jui_secretario;
        this.jui_fojas = _jui_fojas;
        this.jui_naturaleza = _jui_naturaleza;
        this.resp_id = _resp_id;
        this.jui_ubicacion = _jui_ubicacion;
        this.jui_observaciones=_jui_observaciones;
        this.tip_id = _tip_id;
        this.del_id = _del_id;
        mat_id=_mat_id;
    }
//****************
    //INICIA SECCION DE SET Y GET PARA VARIABLES
    public String getJud_id() {
        return jud_id;
    }

    public void setJud_id(String jud_id) {
        this.jud_id = jud_id;
    }

    public String getJui_juez() {
        return jui_juez;
    }

    public void setJui_juez(String jui_juez) {
        this.jui_juez = jui_juez;
    }

    public String getJui_secretario() {
        return jui_secretario;
    }

    public void setJui_secretario(String jui_secretario) {
        this.jui_secretario = jui_secretario;
    }



    public String getJui_actor() {
        return jui_actor;
    }

    public void setJui_actor(String jui_actor) {
        this.jui_actor = jui_actor;
    }

    public int getJui_ano() {
        return jui_cuerpos;
    }

    public void setJui_ano(int jui_cuerpos) {
        this.jui_cuerpos = jui_cuerpos;
    }

    public String getJui_demandado() {
        return jui_demandado;
    }

    public void setJui_demandado(String jui_demandado) {
        this.jui_demandado = jui_demandado;
    }

    public String getJui_id() {
        return jui_id;
    }

    public void setJui_id(String jui_id) {
        this.jui_id = jui_id;
    }

    public String getJui_naturaleza() {
        return jui_naturaleza;
    }

    public void setJui_naturaleza(String jui_naturaleza) {
        this.jui_naturaleza = jui_naturaleza;
    }

    public String getJui_ubicacion() {
        return jui_ubicacion;
    }

    public void setJui_ubicacion(String jui_ubicacion) {
        this.jui_ubicacion = jui_ubicacion;
    }

    public int getJui_cuerpos() {
        return jui_cuerpos;
    }

    public void setJui_cuerpos(int jui_cuerpos) {
        this.jui_cuerpos = jui_cuerpos;
    }

    public int getJui_fojas() {
        return jui_fojas;
    }

    public void setJui_fojas(int jui_fojas) {
        this.jui_fojas = jui_fojas;
    }

    
    public int getResp_id() {
        return resp_id;
    }

    public void setResp_id(int resp_id) {
        this.resp_id = resp_id;
    }

  

    public String getJui_observaciones() {
        return jui_observaciones;
    }

    public void setJui_observaciones(String jui_observaciones) {
        this.jui_observaciones = jui_observaciones;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }
 public String getJui_sector() {
        return jui_sector;
    }

    public void setJui_sector(String jui_sector) {
        this.jui_sector = jui_sector;
    }

    public String getJui_estanteria() {
        return jui_estanteria;
    }

    public void setJui_estanteria(String jui_estanteria) {
        this.jui_estanteria = jui_estanteria;
    }

    public String getJui_bandeja() {
        return jui_bandeja;
    }

    public void setJui_bandeja(String jui_bandeja) {
        this.jui_bandeja = jui_bandeja;
    }

    public String getJui_caja() {
        return jui_caja;
    }

    public void setJui_caja(String jui_caja) {
        this.jui_caja = jui_caja;
    }

    
    
public boolean ExisteJuicio(){

 try{
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_buscar_juicio ?,?");
        conn.AgregarParametroString("jui_id", jui_id);
        conn.AgregarParametroString("jud_id", jud_id);

        rs=conn.EjecutarComando();
        if (rs.next()){
            jui_observaciones=rs.getString("jui_observaciones");
            jui_ubicacion=rs.getString("jui_ubicacion");
            return true;
        } else
            return false;
       }catch(Exception ex){
          System.out.println("Error al buscar el registro proc_buscar_juicio: "+ex);
          return false;
        }
}

  public boolean GuardarJuicio(){

     try{
        //ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_juicio ?, ?,  ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        conn.AgregarParametroString("jui_id", jui_id);
        conn.AgregarParametroString("jud_id", jud_id);
   
        conn.AgregarParametroString("jui_juez", jui_juez);
        conn.AgregarParametroString("jui_secretario",jui_secretario);
        conn.AgregarParametroEntero("jui_cuerpos", jui_cuerpos);
        conn.AgregarParametroString("jui_naturaleza",jui_naturaleza);
        conn.AgregarParametroEntero("resp_id", resp_id);
        conn.AgregarParametroString("jui_ubicacion",jui_ubicacion);
        conn.AgregarParametroEntero("jui_fojas",jui_fojas);
        conn.AgregarParametroString("jui_observaciones",jui_observaciones);
        conn.AgregarParametroEntero("tip_id",tip_id);
        conn.AgregarParametroEntero("del_id",del_id);
        conn.AgregarParametroEntero("mat_id",mat_id);
        conn.AgregarParametroString("usu_id",usu_id);
        conn.AgregarParametroString("jui_sector",jui_sector);
        conn.AgregarParametroString("jui_estanteria",jui_estanteria);
        conn.AgregarParametroString("jui_bandeja",jui_bandeja);
        conn.AgregarParametroString("jui_caja",jui_caja);
        conn.AgregarParametroString("usu_modifica",usu_id);
         //System.out.println("guardar juicio");
        conn.EjecutarUpdate();
        conn.Desconectar();
        return true;
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_juicio: "+ex);
          return false;
        }

  }
        
}
