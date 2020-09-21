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
public class ConsultaDatosJuicio {

  String idjuicio;
  String Materia ;
  String TipoJuicio;
  String Delito;
  String Actor[];
  String Demandado[];
  String Juez;
  String Log_Juez;
  String Secretario;
  String Responsable;
  int Fojas;
  int Cuerpos;

    public String[] getActor() {
        return Actor;
    }

    public void setActor(String[] Actor) {
        this.Actor = Actor;
    }

    public int getCuerpos() {
        return Cuerpos;
    }

    public void setCuerpos(int Cuerpos) {
        this.Cuerpos = Cuerpos;
    }

    public String getDelito() {
        return Delito;
    }

    public void setDelito(String Delito) {
        this.Delito = Delito;
    }

    public String[] getDemandado() {
        return Demandado;
    }

    public void setDemandado(String[] Demandado) {
        this.Demandado = Demandado;
    }

    public int getFojas() {
        return Fojas;
    }

    public void setFojas(int Fojas) {
        this.Fojas = Fojas;
    }

    public String getJuez() {
        return Juez;
    }

    public void setJuez(String Juez) {
        this.Juez = Juez;
    }

    public String getLog_Juez() {
        return Log_Juez;
    }

    public void setLog_Juez(String Log_Juez) {
        this.Log_Juez = Log_Juez;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public String getSecretario() {
        return Secretario;
    }

    public void setSecretario(String Secretario) {
        this.Secretario = Secretario;
    }

    public String getTipoJuicio() {
        return TipoJuicio;
    }

    public void setTipoJuicio(String TipoJuicio) {
        this.TipoJuicio = TipoJuicio;
    }

public boolean consultardatos(String idjuicio){
    try{
        String host="10.24.4.3\\PRODUCCION";
         String bd = "";
         String login = "BLEX1";
        String password = "11hEfEstO11";
         String url = "jdbc:sqlserver://"+host+";databaseName="+bd+";user="+login+";password="+password+";";

        ResultSet rs = null;
        BaseDatos conn = new BaseDatos(bd,login,password,url);
        conn.Conectar();
        conn.CrearStoreProcedure("SELECT * FROM CLEX1.Juicios WHERE IdJuicio='"+idjuicio+"'");
        //conn.AgregarParametroString("idjuicio", idjuicio);
        rs=conn.EjecutarComando();

        if(rs.next()){
             System.out.println(rs.getString("idjuicio"));
             System.out.println(rs.getString("idjudicatura"));
             System.out.println(rs.getString("idjuicio"));
             System.out.println(rs.getString("idjuicio"));
             System.out.println(rs.getString("idjuicio"));
            return true;
        } else
            return false;
       }catch(Exception ex){
          System.out.println("Error  "+ex);
          return true;
        }
    
}
}


