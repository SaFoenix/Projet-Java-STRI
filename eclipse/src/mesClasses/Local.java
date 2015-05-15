/**
 * 
 */
package mesClasses;

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
	
	private String nom;
	/**
	 * La liste des salles qui sont disponibles dans le local
	 * Elle est modifiable
	 * 
	 * @see Salle
	 */
	private ArrayList<Salle> salles;
	
	/**
	 * @param nom
	 */
	public Local(String nom) {
		this.nom = nom;
		salles=new ArrayList<Salle>();
	}

	public Salle rechercherSalle(Integer numero,Integer etage){
		for(Salle salleRech :salles){
			if(salleRech.getEtage()==etage && salleRech.getNumero()==numero){
				return salleRech;
			}
		}		
		return null;
	}
	public void ajouterSalle(Integer numero,Integer nombreOrdi,Integer etage){
		Salle sall=new Salle(numero, etage, nombreOrdi);
		if(rechercherSalle(numero, etage)==null){
			System.out.println("La salle, numero "+numero+", etage "+etage+", a été ajoutée au local "+nom+ ".");
			salles.add(sall);
		}
		else 
			System.out.println("La salle, numero "+numero+", etage "+etage+", existe déjà.");
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str;
		str="Local: "+nom+"\n";
		for(Salle sa : salles){
			str+=sa.toString();
		}
		return str;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterRouteurSalle(Routeur rout,Integer numero, Integer etage){
		Salle salle=rechercherSalle(numero, etage);
		if(salle!=null){
			salle.ajouterRouteur(rout);
		}
		else{
			System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, impossible d'ajouter le routeur.");
		}
	}	
	
	public void connecterEquipARouteurSalle(Equipement equi,Integer numero,Integer etage,String macRout){
		Salle salle=rechercherSalle(numero, etage);
		if(salle!=null)
			salle.connecterEquipementARouteur(equi,macRout);
		else System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, impossible d'ajouter l'equipement.");
	}
}
