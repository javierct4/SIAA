/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class Juez {

    int jue_id;
    String jue_nombres;
    String jue_apellidos;
    String jue_inicial;

    public Juez() {
    }

    public Juez(int jue_id, String jue_nombres, String jue_apellidos, String jue_inicial) {
        this.jue_id = jue_id;
        this.jue_nombres = jue_nombres;
        this.jue_apellidos = jue_apellidos;
        this.jue_inicial = jue_inicial;
    }

    public String getJue_apellidos() {
        return jue_apellidos;
    }

    public void setJue_apellidos(String jue_apellidos) {
        this.jue_apellidos = jue_apellidos;
    }

    public Integer getJue_id() {
        return jue_id;
    }

    public void setJue_id(Integer jue_id) {
        this.jue_id = jue_id;
    }

    public String getJue_nombres() {
        return jue_nombres;
    }

    public void setJue_nombres(String jue_nombres) {
        this.jue_nombres = jue_nombres;
    }

    public String getJue_inicial() {
        return jue_inicial;
    }

    public void setJue_inicial(String jue_inicial) {
        this.jue_inicial = jue_inicial;
    }

    @Override
    public String toString() {
        return  jue_nombres+' '+jue_apellidos ;
    }

      public void Juez(int _jue_id,String _jue_nombres,String _jue_apellidos,String _jue_inicial){
            this.jue_id=_jue_id;
            this.jue_apellidos=_jue_apellidos;
            this.jue_nombres=_jue_nombres;
            this.jue_inicial=_jue_inicial;
    }

}
