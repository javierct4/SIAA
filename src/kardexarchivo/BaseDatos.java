package kardexarchivo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier Cevallos
 * @
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.DriverManager;


public class BaseDatos {
        Connection conn;
        private String bd ;
        private String login;
        private String password ;
        private String url ;
       // public String url= "jdbc:sqlserver://10.24.13.191;databaseName=INVENTARIO;user=sa;password=ComplejoOtavalo2013;";
        //  String url = "jdbc:sqlserver://10.24.4.7;instanceName=DBPRUEBA;user=BLEX1;password=BLEX1;";
       //String url = "jdbc:sqlserver://localhost;instanceName=DBPRUEBA;user=BLEX1;password=BLEX1;";

       public CallableStatement spi;

    public BaseDatos(String _bdd,String _login,String _password,String _url) {
         LeerArchivo host = new LeerArchivo();
     host.Leer("servidores");
    
        this.bd=_bdd;
        this.login=_login;
        this.password=_password;
        this.url=_url;
        conn=null;
        spi=null;
    }
 public BaseDatos(String bdd) {
    LeerArchivo conexion = new LeerArchivo();
     conexion.Leer("conexion.fj");
    conexion.lista.get(1);
       if (bdd.equals("satje")){
         this.bd = "";
         this.login = "";
         this.password = "";
         this.url = "jdbc:sqlserver://"+conexion.lista.get(1)+";databaseName=BADALEX1;user=USR_OPE_PROVINCIAS;password=Pr0vincias;";    
       }else{
        this.bd = "INVENTARIO";
         this.login = "inventario";
         this.password = "4rchivo10";
         this.url = "jdbc:sqlserver://"+conexion.lista.get(0)+";databaseName="+this.bd+";user="+this.login+";password="+this.password+";";
        
     }
        conn=null;
        spi=null;

    }

        //Integer indice=0;
    public void setBd(String bd) {
        this.bd = bd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void Conectar()
    {

        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(this.url, this.login, this.password);
         /*if (conn != null)
               {
               System.out.println("Conexión a base de datos ..... Ok");
               //conn.close();
                }*/
           }
         catch(SQLException ex) {
             System.out.println("Hubo un problema al intentar conectarse con la base de datos Error:"+ex);
         }
        catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

       public void Desconectar()
    {
           try{
                   if (conn != null)
                    conn.close();
            }
            catch(SQLException ex) {
                    System.out.println("Hubo un problema al intentar desconectar de la base de datos "+url+ "Error:"+ex);
            }
       }

        public ResultSet CrearComando()
        {
            ResultSet rs=null;
            PreparedStatement psExecute;
            try{
                psExecute = conn.prepareStatement("proc select");
                rs = psExecute.executeQuery();
            }
            catch(SQLException ex) {
                    System.out.println("Hubo un problema al intentar recuperar datos..."+url+ " Error:"+ex);
            }
            return rs;
        }

         public void CrearStoreProcedure(String parametro)
        {

            try{
               spi = conn.prepareCall(parametro);
            }
            catch(SQLException ex) {
                    System.out.println("Hubo un problema al intentar crear el Store Procedure..."+url+ " Error:"+ex);
            }

        }

        public void AgregarParametroString(String nomparam,String parametro)
        {
               try{
                  // this.indice=this.indice+1;
                    spi.setString(nomparam, parametro);

            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al intentar asignar parametro String..."+url+ " Error:"+ex);

           }

          }

         public void AgregarParametroEntero(String nomparam,Integer parametro)
        {
              try{
                   //this.indice=this.indice+1;
                   spi.setInt(nomparam, parametro);

            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al intentar asignar parametro entero..."+url+ " Error:"+ex);

           }

          }

           public ResultSet EjecutarComando()
        {
              ResultSet rs =null;
              try{
                    spi.execute();
                    rs = spi.getResultSet();

            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al ejecutar comando..."+url+ " Error:"+ex);
           }
            return rs;
          }

             public int EjecutarUpdate()
        {
              //ResultSet rs =null;
              int i=0;
              try{
                i= spi.executeUpdate();

            }catch(SQLException ex) {
                    System.out.println("Hubo un problema al ejecutar comando..."+url+ " Error:"+ex);

           }
            return i;
          }

    public Connection getConn() {
        return conn;
    }


}
