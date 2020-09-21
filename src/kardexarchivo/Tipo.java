/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kardexarchivo;

/**
 *
 * @author MEGASYSTEM
 */
public class Tipo {
    private Integer tip_id;
    private String tip_siglas;
    private String tip_detalle;

    public Tipo(){}


    public String getTip_detalle() {
        return tip_detalle;
    }

    public void setTip_detalle(String tip_detalle) {
        this.tip_detalle = tip_detalle;
    }

    public Integer getTip_id() {
        return tip_id;
    }

    public void setTip_id(Integer tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_siglas() {
        return tip_siglas;
    }

    public void setTip_siglas(String tip_siglas) {
        this.tip_siglas = tip_siglas;
    }

     @Override
    public String toString() {
        return tip_detalle;
    }

    public Tipo(Integer tip_id, String tip_siglas, String tip_detalle) {
        this.tip_id = tip_id;
        this.tip_siglas = tip_siglas;
        this.tip_detalle = tip_detalle;
    }

     

}
