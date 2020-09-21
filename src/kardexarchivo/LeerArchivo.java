/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
/**
 *
 * @author edwin.cevallost
 */
public class LeerArchivo {
    ArrayList lista = new ArrayList(); 
    String host=null;
    //String fecha;
    //String hora;
public ArrayList Leer(String archivo){
    
    // bdd.CrearStoreProcedure("sp_guardar_evento ?,?");
            File f = new File(archivo);
            //System.out.println(f.getAbsolutePath());
                            Scanner s;
                            try {
                                    s = new Scanner(f);
                                    int i=0;
                                   
                                   while (s.hasNextLine()) {
                                            
                                            String linea = s.nextLine();
                                            Scanner sl = new Scanner(linea);
                                           // System.out.println("Estoy aqui");
                                           // sl.useDelimiter("\\s*,\\s*");
                                            host=sl.next();
                                             lista.add(host);
                                                           
                                            //System.out.println(lista.get(i));
                                            i++;
                                            //System.out.println(fecha+hora);
                                            //System.out.println(hora);

                                           // bdd.AgregarParametroString("@id", cedula);
                                            //bdd.AgregarParametroString("@fechahora", fecha +" "+ hora);
                                            //bdd.EjecutarUpdate();
                                            //bdd.Desconectar();
                                    }
                                    s.close();
                                 
                                  
                            } catch (FileNotFoundException e) {
                                    e.printStackTrace();
            }
            return lista;

    }

}
