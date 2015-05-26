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
                       ArrayList<Routeur> routeur = new ArrayList<>();
                       ArrayList<BorneSansFil> borne = new ArrayList<>();
                       MySql bdd = new MySql();
                       bdd.Connexion();
                       //bdd.AjoutSociete("Stri","Toulouse");
                       //bdd.AjoutLocal("STRI","U2","Toulouse");
                       //bdd.AjoutSalle("U2",202,1,15);
                       //bdd.AjoutRouteur(1, "RouteurSalle2" , "192.255.0.0" , "Cisco" ,"Linux","1.2.2", true ,5);
                       //bdd.AjoutOrdinateur(1,"Pierre","38.36.82.69" ,"Apple","Apple","Pro.2",true, "500", "400", "300", "500Go");
                       societe=bdd.RecupererSociete("STRI");
                       System.out.println(societe);
                       locaux=bdd.RecupererLocal("STRI");
                       System.out.println(locaux);
                       salle=bdd.RecupererSalle("U3");
                       System.out.println(salle);
                       routeur=bdd.RecupererRouteur(1);
                       System.out.println(routeur);
                       borne=bdd.RecupererBorne(1);
                       System.out.println(borne);
                       /*ordi = bdd.RecupererOrdinateur(1);
                       System.out.println(ordi);*/
                       bdd.ModifierOs("ModifOs", "ModifVersion", "MacBo");
                       //bdd.ModifierNom("Testmodif", "1234" );
                       //bdd.AjoutBorne(1,"Borne" ,"MacBorne", "Marque","Windows","1.2.3.4",true);
                       //bdd.AjoutTablette(1,"Tablette1" ,"MacTablette", "Ipad" ,"MAcOs" , "1.1.1",true, "4","Petit" );
	}

}
