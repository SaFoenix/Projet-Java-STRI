/**
 * 
 */
package mesTest;
import java.sql.*;
import java.util.*;
import mesClasses.*;
/**
 * @author STRI_JAVA
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args){
                       ArrayList societe = new ArrayList();
                       MySql bdd = new MySql();
                     
                       bdd.Connexion();
                       societe=bdd.SocieteLocal("Latelec");
                       System.out.println(societe);
	}

}
