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
                       boolean TestOs;
                       ArrayList<Local> locaux = new ArrayList<>();
                       ArrayList<Salle> salle = new ArrayList<>();
                       ArrayList<Ordinateur> ordi = new ArrayList<>();
                       MySql bdd = new MySql();
                       bdd.Connexion();
                       //bdd.AjoutSociete("Stri","Toulouse");
                       //bdd.AjoutLocal("STRI","U2","Toulouse");
                       //bdd.AjoutSalle("U2",202,1,15);
                       //bdd.AjoutRouteur(202, "RouteurSalle2" , "192.255.0.0" , "Cisco" ,"Linux","1.2.2", true ,5);
                       //bdd.AjoutOrdinateur(1,"Pierre","FF80::1" ,"Apple","Apple","Pro.2",true, "500", "400", "300", "500Go");
                       societe=bdd.RecupererSociete("STRI");
                       System.out.println(societe);
                       locaux=bdd.RecupererLocal("STRI");
                       System.out.println(locaux);
                       salle=bdd.RecupererSalle("Amphi");
                       System.out.println(salle);
                       ordi = bdd.RecupererOrdinateur(202);
                       System.out.println(ordi);
                       
                       
	}

}
