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
	private String localisation;
	private ArrayList<Local> locaux;
	
	/**
	 * @param nom
	 * @param localisation
	 */
	public Societe(String nom,String localisation) {
		this.nom = nom;
		this.localisation=localisation;
		locaux=new ArrayList<Local>();
	}	
		
	public void ajouterSalle(String nomL, Integer numero,Integer etage,Integer nombreOrdi){
		Local locRech=rechercherLocal(nomL);
		if(locRech==null){
			System.out.println("Le local "+nomL+" n'existe pas. La salle, numero "+numero+", etage "+etage+" n'a pas été ajoutée.");
			return;
		}
		locRech.ajouterSalle(numero, nombreOrdi, etage);
	}
	
	private Local rechercherLocal(String nomL){
		
		for(Local locRech : locaux){
			if(locRech.getNom().equalsIgnoreCase(nomL)){
				return locRech;
			}
		}
		return null;
	}
	public void ajouterLocal(String nomL,String localisation){
		Local nouvLocal=new Local(nomL,localisation);
		for(Local loc : locaux){
			if(loc.getNom().equalsIgnoreCase(nomL)){
				System.out.println("Le local "+nomL+" existe déjà.");
				return;
			}
		}
		locaux.add(nouvLocal);
		System.out.println("Le local "+nomL+" a été ajouté.");
		return;
	}
	
	public void supprimerLocal(String nomL){
		Local loc=rechercherLocal(nomL);		
		if(loc!=null){
			System.out.println("Le local "+nomL+" a été supprimé.");
			locaux.remove(loc);
		}
		else 
			System.out.println("Le local "+nomL+" n'existe pas.");
	}
	
	public void supprimerSalle(String nomL,Integer etage,Integer numero){
		Local loc=rechercherLocal(nomL);
		if(loc!=null)
			loc.supprimerSalle(etage,numero);
		else System.out.println("Le local "+nomL+" n'existe pas");
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str;
		str="Société: "+nom+" ["+localisation+"]\n";
		for(Local loc:locaux){
			str+=loc.toString();
		}
		return str;
	}
	
	public void ajouterRouteurSalle(Routeur rout, Integer etage,Integer numero, String nomL){
		Local loc=rechercherLocal(nomL);
		if(loc != null){
			loc.ajouterRouteurSalle(rout, numero, etage);
		}
		else System.out.println("Le local n'existe pas");
	}
	
	public void connecterOrdinateur(Ordinateur ordi,Integer etage,Integer numero,String macRout,String nomL){
		Local loc=rechercherLocal(nomL);
		if(loc != null){
			loc.connecterOrdinateur(ordi, numero, etage, macRout);
		}
		else System.out.println("Le local n'existe pas, impossible d'ajouter l'ordinateur");
	}
	public void ajouterBorneSansFil(BorneSansFil borne,String nomL,Integer etage,Integer numero){
		Local loc=rechercherLocal(nomL);
		if(loc !=null){
			loc.ajouterBorneSansFil( borne, etage, numero);
		}
		else System.out.println("Le local n'existe pas");
	}
	
	public void connecterTablette(Tablette tab,String nomL,Integer etage,Integer numero,String macBorne){
		Local loc=rechercherLocal(nomL);
		if(loc!=null){
			loc.connecterTablette(tab, etage, numero,macBorne);
		}
		else System.out.println("Le local n'existe pas");
	}
	
	public void activerDesactiverAppareil(String mac,String nomL,Integer numero,Integer etage,boolean power){
		Local loc=rechercherLocal(nomL);
		if(loc!=null){
			loc.activerDesactiverAppareil(mac,numero,etage,power);
		}
		else System.out.println("Le local n'existe pas");
	}
}