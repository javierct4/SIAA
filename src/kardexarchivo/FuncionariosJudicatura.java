/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kardexarchivo;

/**
 *
 * @author edwin.cevallost
 */
public class FuncionariosJudicatura {
    String login;
    String cargo;

    public FuncionariosJudicatura(String login, String cargo) {
        this.login = login;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login +"-"+ cargo ;
    }
    
    
            
}
