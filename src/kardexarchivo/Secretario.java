/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class Secretario {

    int  sec_id;
    String sec_nombres;
    String sec_apellidos ;

    public Secretario(int sec_id, String sec_nombres, String sec_apellidos) {
        this.sec_id = sec_id;
        this.sec_nombres = sec_nombres;
        this.sec_apellidos = sec_apellidos;
    }

    public Secretario() {
    }

    public String getSec_apellidos() {
        return sec_apellidos;
    }

    public void setSec_apellidos(String sec_apellidos) {
        this.sec_apellidos = sec_apellidos;
    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }

    public String getSec_nombres() {
        return sec_nombres;
    }

    public void setSec_nombres(String sec_nombres) {
        this.sec_nombres = sec_nombres;
    }

    @Override
    public String toString() {
        return sec_nombres+' '+ sec_apellidos ;
    }
 public void Secretario(int _sec_id,String _sec_nombres,String _sec_apellidos){
            this.sec_id=_sec_id;
            this.sec_apellidos=_sec_apellidos;
            this.sec_nombres=_sec_nombres;
    }

}
