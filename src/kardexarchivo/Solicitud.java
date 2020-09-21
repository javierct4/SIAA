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
public class Solicitud {
    private int numero;
    private Usuario usuario;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitud(Usuario usuario, int estado) {
        this.usuario = usuario;
        this.estado = estado;
    }
    
    public int GuardarSolicitud(){
     try{
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec sp_guardar_solicitud ?, ?, ?");
        conn.AgregarParametroEntero("sol_id", this.numero);
        conn.AgregarParametroString("usu_id", this.usuario.usu_id);
        conn.AgregarParametroEntero("sol_estado", this.estado);
         //System.out.println("guardar juicio");
     
         rs=conn.EjecutarComando();        
         if(rs.next()){
             this.numero=rs.getInt("sol_id");      
         }
          rs.close();
          conn.Desconectar();
          return this.numero;  
       }catch(Exception ex){
          System.out.println("Error al guardar el registro sp_guardar_juicio: "+ex);
          return 0;
        }
    }
    
    
    
}
