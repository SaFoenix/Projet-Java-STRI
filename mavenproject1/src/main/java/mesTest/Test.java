/**
 * 
 */
package mesTest;
import mesClasses.*;
/**
 * @author STRI_JAVA
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			Societe so=new Societe("So1", "Bordeaux");
			Societe so1=new Societe("So2", "Bordeaux");
			System.out.println(so.toString());
			System.out.println(so1.toString());
			so.ajouterLocal("Local1", "Toulouse");
			so.ajouterLocal("Local2", "bayonne");
			so.ajouterSalle("Local1", 0, 1, 15);
			so.ajouterSalle("Local1", 0, 2, 20);
			Os os=new Os(".1", "Windows");
			Routeur r1=new Routeur("ffffff", "r1", "CISCO", true, os, 20);
			Routeur r2=new Routeur("ff:ff:dd:ff", "r2", "CISCO", false, os, 20);
			Routeur r3=new Routeur("aa:aa:55:11", "r3", "CISCO", true,os , 20);
			so.ajouterRouteurSalle(r1, 1, 0, "Local1");
			so.ajouterRouteurSalle(r2, 1, 0, "Local1");
			so.ajouterRouteurSalle(r3, 2, 0, "Local1");
			Ordinateur o1=new Ordinateur("aa", "o1", "eze", false, os, "4go", "i5", "intel", "500go");
			Ordinateur o2=new Ordinateur("aaee", "o2", "eze", false, os, "4go", "i5", "intel", "500go");
			Ordinateur o3=new Ordinateur("aazz", "o3", "eze", false, os, "4go", "i5", "intel", "500go");
			Ordinateur o4=new Ordinateur("aaqq", "o4", "eze", false, os, "4go", "i5", "intel", "500go");
			so.connecterOrdinateur(o1, 1, 0, "ffffff", "Local1");
			so.connecterOrdinateur(o2, 1, 0, "ffffff", "Local1");
			so.connecterOrdinateur(o3, 1, 0, "ff:ff:dd:ff", "Local1");
			so.connecterOrdinateur(o4, 1, 0, "ff:ff:dd:ff", "Local1");
			
			BorneSansFil b1=new BorneSansFil("efefef", "b1", "mamma", false, os);
			BorneSansFil b2=new BorneSansFil("eee", "b2", "mamma", false, os);
			BorneSansFil b3=new BorneSansFil("efeeefef", "b3", "mamma", false, os);
			BorneSansFil b4=new BorneSansFil("efefeeeeef", "b4", "mamma", false, os);
			so.ajouterBorneSansFil(b1, "Local1", 1, 0);
			so.ajouterBorneSansFil(b2, "Local1", 1, 0);
			so.ajouterBorneSansFil(b3, "Local1", 2, 0);
			so.ajouterSalle("Local2", 0, 1, 5);
			so.ajouterBorneSansFil(b4, "Local2", 1, 0);
			Tablette t1=new Tablette("Mact1", "t1", "ezfez", false, os, "50go", 5);
			Tablette t2=new Tablette("Mact1ezfff", "t2", "ezfez", false, os, "50go", 5);
			Tablette t3=new Tablette("Mact1ezf", "t3", "ezfez", false, os, "50go", 5);
			Tablette t4=new Tablette("Mact1ezf", "t4", "ezfez", false, os, "50go", 5);
			Tablette t5=new Tablette("Mact1ezf", "t5", "ezfez", false, os, "50go", 5);
			Tablette t6=new Tablette("Mact1zef", "t6", "ezfez", false, os, "50go", 5);
			
			so.connecterTablette(t1, "Local2", 1, 0, "efefeeeeef");		
			so.connecterTablette(t2, "Local2", 1, 0, "efefeeeeef");
			so.connecterTablette(t3, "Local2", 1, 0, "efefeeeeef");
			so.connecterTablette(t4, "Local1", 1, 0, "efefef");
			so.connecterTablette(t5, "Local1", 1, 0, "efefef");
			so.connecterTablette(t6, "Local2", 1, 0, "efefeeeeef");
			
			
			so.activerDesactiverAppareil("Mact1zef", "Local2", 0, 1, true);	
			so.activerDesactiverAppareil("Mact1zef", "Local2", 0, 1, false);
			so.activerDesactiverAppareil("efefeeeeef", "Local2", 0, 1, true);
			so.activerDesactiverAppareil("ff:ff:dd:ff", "Local1", 0, 1, false);
			so.activerDesactiverAppareil("ff:ff:dd:ff", "Local1", 0, 1, true);
			so.activerDesactiverAppareil("aaqq", "Local1", 0, 1, false);
                        Os os2=new Os("Mate", "Linux")
                        so.miseAJour("Local2", 0, 1, "efefeeeeef", os);
                        so.miseAJour("Local2", 0, 1, "efefeeeeef", os2);
                        System.out.println(so.toString());
	}

}
