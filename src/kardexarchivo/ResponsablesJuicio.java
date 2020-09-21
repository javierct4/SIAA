/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class ResponsablesJuicio {

    int resp_id;
    String resp_nombres;
    String resp_apellidos;

    public ResponsablesJuicio() {
    }

    public ResponsablesJuicio(int resp_id, String resp_nombres, String resp_apellidos) {
        this.resp_id = resp_id;
        this.resp_nombres = resp_nombres;
        this.resp_apellidos = resp_apellidos;
    }

    public String getResp_apellidos() {
        return resp_apellidos;
    }

    public void setResp_apellidos(String resp_apellidos) {
        this.resp_apellidos = resp_apellidos;
    }

    public int getResp_id() {
        return resp_id;
    }

    public void setResp_id(int resp_id) {
        this.resp_id = resp_id;
    }

    public String getResp_nombres() {
        return resp_nombres;
    }

    public void setResp_nombres(String resp_nombres) {
        this.resp_nombres = resp_nombres;
    }

    @Override
    public String toString() {
        return resp_nombres+' '+ resp_apellidos;
    }
    
    public void ResponsablesJuicio(int _resp_id,String _resp_nombres,String _resp_apellidos){
            this.resp_id=_resp_id;
            this.resp_apellidos=_resp_apellidos;
            this.resp_nombres=_resp_nombres;
    }

}
