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
                       MySql bdd = new MySql();
                       bdd.Connexion();
                       //TestOs=  bdd.VerifierOs("Windows","1.2");
                       //System.out.println(TestOs);
                       //bdd.AjoutSociete("Stri","Toulouse");
                       //bdd.AjoutLocal("STRI","Amphi","Toulouse");
                       //bdd.AjoutSalle("Salle 8",4,20,1);
                       //bdd.AjoutOrdinateur(3,"Test","172.0.0.254" ,"Asus","Windows","Pro.2",true, "500", "400", "300", "1TO");
                       //bdd.AjoutRouteur(4, "Routeur3" , "185.58.255.254" , "Cisco" ,"Linux","1.2.2", true ,10);
                       /*societe=bdd.RecupererSociete("STRI");
                       System.out.println(societe);
                       locaux=bdd.RecupererLocal("STRI");
                       System.out.println(locaux);
                       salle=bdd.RecupererSalle("Amphi");
                       System.out.println(salle);
                       System.out.println(societe);*/
                       
	}

}
