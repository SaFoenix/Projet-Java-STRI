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
                       Societe societe;
                       Local local;
                       MySql bdd = new MySql();
                       Societe so = null;
                       bdd.Connexion();
                       //bdd.AjoutSociete("Stri","Toulouse");
                       bdd.AjoutLocal("STRI","Blabla","Toulouse");
                       //bdd.AjoutSalle("Lit", 1, 1, 1);
                       //bdd.AjoutOrdinateur("TomZzy", "Asus", "AdresseMac",true, "500", "400", "300", "1TO");
                       societe=bdd.RecupererSociete();
                       local=bdd.SocieteLocal("STRI");
                       //System.out.println(societe);
                      
	}

}
