/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * @author STRI_JAVA
 *
 */
public class Salle {
	private Integer idSalle;
	private Integer numero;
	private Integer etage;
	private Integer nombreOrdinateur;
	private ArrayList<Routeur> routeurs;
	private ArrayList<BorneSansFil> bornes;
	
	/**
	 * @param idSalle
	 * @param numero
	 * @param etage
	 * @param nombreOdinateur
	 */
	public Salle(Integer numero, Integer etage,Integer nombreOrdinateur) {
		this.numero = numero;
		this.etage = etage;
		this.nombreOrdinateur = nombreOrdinateur;
		routeurs=new ArrayList<Routeur>();
		bornes=new ArrayList<BorneSansFil>();
	}
	
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @return the nombreOdinateur
	 */
	public Integer getNombreOrdinateur() {
		return nombreOrdinateur;
	}

	/**
	 * @param nombreOrdinateur the nombreOrdinateur to set
	 */
	public void setNombreOrdinateur(Integer nombreOrdinateur) {
		this.nombreOrdinateur = nombreOrdinateur;
	}

	/**
	 * @return the idSalle
	 */
	public Integer getIdSalle() {
		return idSalle;
	}

	/**
	 * @return the etage
	 */
	public Integer getEtage() {
		return etage;
	}

	public String toString() {
		String str="Salle ["+ etage + numero +"]\n";
		str+="\tnombreOrdinateur=" + nombreOrdinateur+"\n";
		for(Routeur rout: routeurs){
			str+=rout.toString();
		}
		return str;
	}

	public void ajouterRouteur(Routeur rout) {
		for(Routeur obj : routeurs){
			if(obj.getMac()==rout.getMac()){
				System.out.println("Le retour "+rout.getMac()+" est déjà connecté dans la salle.");
				return;
			}				
		}		
		System.out.println("Le routeur "+rout.getMac()+" a été ajouté.");
		routeurs.add(rout);		
	}
	
	public Routeur rechercherRouteur(String mac){
		for(Routeur rout : routeurs){
			if(rout.getMac()==mac){
				return rout;
			}
		}	
		return null;
	}
	
	public void connecterOrdinateur(Ordinateur ordi,String mac){
		Routeur rout=rechercherRouteur(mac);
		if(rout==null){
			System.out.println("Le routeur n'existe pas.");
		}
		else{
			rout.connecterOrdinateur(ordi);
		}
	}
}
