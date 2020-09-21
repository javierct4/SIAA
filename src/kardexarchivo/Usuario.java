/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

import java.sql.ResultSet;

/**
 *
 * @author MEGASYSTEM
 */
public class Usuario {
String usu_id ;
String usu_cedula;
String usu_nombres;
String usu_apellidos;
String usu_password;
String usu_cargo;
int rol_id;

    public Usuario() {
    }

    public Usuario(String usu_id, String usu_password) {
        this.usu_id = usu_id;
        this.usu_password = usu_password;
        

    }

    public Usuario(String usu_id, String usu_cedula, String usu_nombres, String usu_apellidos, String usu_password) {
        this.usu_id = usu_id;
        this.usu_cedula = usu_cedula;
        this.usu_nombres = usu_nombres;
        this.usu_apellidos = usu_apellidos;
        this.usu_password = usu_password;
    }
    
public Usuario(String usu_id, String usu_nombres, String usu_apellidos,String usu_cargo) {
        this.usu_id = usu_id;
        this.usu_nombres = usu_nombres;
        this.usu_apellidos = usu_apellidos;
        this.usu_cargo = usu_cargo;
    }
    public String getUsu_apellidos() {
        return usu_apellidos;
    }

    public void setUsu_apellidos(String usu_apellidos) {
        this.usu_apellidos = usu_apellidos;
    }

    public String getUsu_cedula() {
        return usu_cedula;
    }

   

    public int getRol_id() {
        return rol_id;
    }



    public void setUsu_cedula(String usu_cedula) {
        this.usu_cedula = usu_cedula;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nombres() {
        return usu_nombres;
    }

    public void setUsu_nombres(String usu_nombres) {
        this.usu_nombres = usu_nombres;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    @Override
    public String toString() {
        return usu_nombres + " " + usu_apellidos ;
    }

/*public boolean loginuser(){

   try{
         
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_select_usuario_password ?, ?");
        conn.AgregarParametroString("usu_id", usu_id);
        conn.AgregarParametroString("usu_password", usu_password);

        rs=conn.EjecutarComando();
        if(rs.next()){
            usu_cedula=rs.getString("usu_cedula");
            usu_nombres=rs.getString("usu_nombres");
            usu_apellidos=rs.getString("usu_apellidos");
            rol_id=rs.getInt("rol_id");
             rs.close();
             conn.Desconectar();
            return true;

        } else
           return false;
       }catch(Exception ex){
          System.out.println("Error al consultar el registro proc_select_usuario_password: "+ex);
          
          return false;
        }


}*/



public boolean loginuserAD(){

   try{
         
        ResultSet rs = null;
        BaseDatos conn = new BaseDatos("INVENTARIO");
        conn.Conectar();
        conn.CrearStoreProcedure("exec proc_select_usuario_password_AD ?");
        conn.AgregarParametroString("usu_id", usu_id);
 
        rs=conn.EjecutarComando();
        if(rs.next()){
            usu_cedula=rs.getString("usu_cedula");
            usu_nombres=rs.getString("usu_nombres");
            usu_apellidos=rs.getString("usu_apellidos");

            rol_id=rs.getInt("rol_id");
             rs.close();
             conn.Desconectar();
            return true;

        } else
           return false;
       }catch(Exception ex){
          System.out.println("Error al consultar el registro proc_select_usuario_password: "+ex);
          
          return false;
        }


}

}
