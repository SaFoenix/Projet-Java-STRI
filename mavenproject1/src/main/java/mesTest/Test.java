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
                       boolean TestOrdinateur;
                       ArrayList<Local> locaux = new ArrayList<>();
                       ArrayList<Salle> salle = new ArrayList<>();
                       MySql bdd = new MySql();
                       bdd.Connexion();
                       //bdd.AjoutSociete("Stri","Toulouse");
                       //bdd.AjoutLocal("STRI","Amphi","Toulouse");
                       //bdd.AjoutSalle("Salle 8",4,20,1);
                       //bdd.AjoutOrdinateur(1,"Test","2001::00:FF" ,"Asus" ,true, "500", "400", "300", "1TO");
                       //bdd.AjoutRouteur(1, "Routeur1" , "10.0.0.1" , "Cisco" , true ,10);
                       societe=bdd.RecupererSociete("STRI");
                       System.out.println(societe);
                       locaux=bdd.SocieteLocal("STRI");
                       System.out.println(locaux);
                       salle=bdd.LocalSalle("Amphi");
                       System.out.println(salle);
                       System.out.println(societe);
                       
	}

}
