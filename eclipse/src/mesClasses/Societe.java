/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * La classe société permet de définir une société.
 * On y trouve les informations suivantes:
 * L'id de la société qui unique et non modifiable
 * Le nom de la société 
 * La liste de locaux qu'elle possède
 * 
 * Une société peut pourra 
 * 
 * @author STRI_JAVA
 *
 */
public class Societe {
	private Integer idSociete; 
	private String nom;
	private ArrayList<Local> locaux;
	
	/**
	 * @param nom
	 * @param locaux
	 */
	public Societe(String nom) {
		this.nom = nom;
		locaux=new ArrayList<Local>();
	}	
	
	public void ajouterLocal(String nomL){
		Local nLocal=new Local(nomL);
		locaux.add(nLocal);
	}
	
	public void ajouterSalle(String nomL, String nomS){
		
	}
	
}
