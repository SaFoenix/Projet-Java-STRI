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
                       ArrayList<Local> locaux = new ArrayList<>();
                       ArrayList<Salle> salle = new ArrayList<>();
                       MySql bdd = new MySql();
                       bdd.Connexion();
                       //bdd.AjoutSociete("Stri","Toulouse");
                       //bdd.AjoutLocal("STRI","Blabla","Toulouse");
                       //bdd.AjoutSalle("Amphi", 1,20,1);
                       //bdd.AjoutSalle("Lit", 1, 1, 1);
                       //bdd.AjoutOrdinateur("TomZzy", "Asus", "AdresseMac",true, "500", "400", "300", "1TO");
                       //societe=bdd.RecupererSociete("STRI");
                       //System.out.println(societe);
                       //locaux=bdd.SocieteLocal("STRI");
                       //System.out.println(locaux);
                       //salle=bdd.LocalSalle("Amphi");
                       //System.out.println(salle);
                       //System.out.println(societe);
                       bdd.AjoutOrdinateur(1,"TomZzy", "Asus", "AdresseMac",true, "500", "400", "300", "1TO");
	}

}
