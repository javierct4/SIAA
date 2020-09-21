/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kardexarchivo;


import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author edwin.cevallost
 */
public class AutenticarAD {
   

        private String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
        private String MY_HOST = "ldap://10.24.4.3:389";

        public AutenticarAD() {}
        public boolean Authenticate(String domain, String user, String pass) {          
                Hashtable<String, String> env = new Hashtable<String, String>();
                if (pass.compareTo("") == 0 || user.compareTo("") == 0)
                        return false;
                env.put(Context.INITIAL_CONTEXT_FACTORY,INITCTX);
                env.put(Context.PROVIDER_URL, MY_HOST);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL,new String(domain+"\\"+user));
                env.put(Context.SECURITY_CREDENTIALS,new String(pass));
                try {
                        DirContext ctx = new InitialDirContext(env);
                        //return true;
                }
                catch (NamingException e) {
                        e.printStackTrace();
                        return false;
                }

                return true;  
        }

 }

