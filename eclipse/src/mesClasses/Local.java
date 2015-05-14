/**
 * 
 */
package mesClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * La classe Local permet de definir un local d'une société 
 * elle est definie par un identifiant unique attribuée définitivement
 * elle a un nom qui peut être modifiée
 * elle a une liste de salles; une peut être ajoutée ou supprimée 
 * 
 * @author STRI_JAVA
 * 
 */
public class Local {
	/**
	 * L'id du local, créé à la contuction du local, ne peut plus être modifié.
	 */
	private Integer idLocal; 
	
	
	/**
	 * La liste des salles qui sont disponibles dans le local
	 * Elle est modifiable
	 * 
	 * @see Salle
	 */
	private ArrayList<Salle> salles;

}
