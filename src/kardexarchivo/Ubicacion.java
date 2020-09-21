/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class Ubicacion {

    Integer ubi_id;
     String ubi_descripcion;

    public Integer getUbi_id() {
        return ubi_id;
    }

    public void setUbi_id(Integer ubi_id) {
        this.ubi_id = ubi_id;
    }
   

    public String getUbi_descripcion() {
        return ubi_descripcion;
    }

    public void setUbi_descripcion(String ubi_descripcion) {
        this.ubi_descripcion = ubi_descripcion;
    }

    @Override
    public String toString() {
        return  ubi_descripcion ;
    }

    public Ubicacion(Integer ubi_id, String ubi_descripcion) {
        this.ubi_id = ubi_id;
        this.ubi_descripcion = ubi_descripcion;
    }




}
