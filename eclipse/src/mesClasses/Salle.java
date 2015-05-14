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
	private ArrayList<Equipement> equipements;
	
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
		equipements=new ArrayList<Equipement>();
	}
	
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str="Salle ["+ etage + numero +"]\n";
		str+="\tnombreOrdinateur=" + nombreOrdinateur+"\n";
		for(Equipement equi: equipements){
			str+=equi.toString();
		}
		return str;
	}
}
