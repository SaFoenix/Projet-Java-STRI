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
	public static void main(String[] args){
                        
                        MySql bdd = new MySql();
                         bdd.Connexion();
                        bdd.AjoutLocal("Pieere","Robert");
                        
	}

}
