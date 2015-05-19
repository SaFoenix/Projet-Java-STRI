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
	private String localisation;
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
         * @param localisation
	 */
	public Local(String nom,String localisation) {
		this.nom = nom;
		this.localisation=localisation;
		salles=new ArrayList<Salle>();
	}

	private Salle rechercherSalle(Integer numero,Integer etage){
		for(Salle salleRech :salles){
			if((salleRech.getEtage()==etage) && (salleRech.getNumero()==numero)){
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
		str="Local: "+nom+" ["+localisation+"]\n";
		for(Salle sa : salles){
			str+=sa.toString()+"\n";
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
	
	public void supprimerSalle(Integer numero, Integer etage){
		Salle sal=rechercherSalle(numero, etage);
		if(sal!=null){
			System.out.println("La salle numero "+numero+" etage "+etage+" a été supprimée.");
			salles.remove(sal);
		}
		else System.out.println("La salle numero "+numero+" etage "+etage+" n'existe pas.");
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
	
	public void connecterOrdinateur(Ordinateur ordi,Integer numero,Integer etage,String macRout){
		Salle salle=rechercherSalle(numero, etage);
		if(salle!=null)
			salle.connecterOrdinateur(ordi,macRout);
		else System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, impossible d'ajouter l'ordinateur.");
	}
	
	public int nombreDeSalle(){
		return salles.size();
	}

	public void ajouterBorneSansFil(BorneSansFil borne, Integer etage,
			Integer numero) {
		Salle sal=rechercherSalle(numero, etage);
		if(sal!=null){
			sal.ajouterBorneSansFil(borne);
		}
		else System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, impossible d'ajouter la borne.");
	}

	public void connecterTablette(Tablette tab, Integer etage, Integer numero,
			String macBorne) {
		Salle sal=rechercherSalle(numero, etage);
		if(sal!=null)
			sal.connecterTablette(tab,macBorne);
		else System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, impossible d'ajouter la tablette.");

	}
	
	private void messageNonTrouve(Integer numero,Integer etage,String str){
		System.out.println("La salle "+numero+" etage "+etage+" n'existe pas, "+str);
	}
	
	public void activerDesactiverAppareil(String mac, Integer numero,
			Integer etage,boolean power) {
		Salle sal=rechercherSalle(numero, etage);
		if(sal!=null){
			sal.activerDesactiverAppareil(mac,power);
		}
		else messageNonTrouve(numero, etage,"l'equipement ne peut pas être désactivé.");
	}
        
        public void miseAJour(Integer numero,Integer etage,String mac, Os newOs){
            Salle sal=rechercherSalle(numero, etage);
            if(sal!=null){
                sal.miseAJour(mac, newOs);
            }
            else messageNonTrouve(numero, etage, "l'equipement ne peut pas mis à jour.");
        }
}
