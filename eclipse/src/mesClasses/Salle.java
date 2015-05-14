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
	private Integer nombreOdinateur;
	private ArrayList<Equipement> equipements;
	
	/**
	 * @param idSalle
	 * @param numero
	 * @param etage
	 * @param nombreOdinateur
	 */
	public Salle(Integer idSalle, Integer numero, Integer etage,
			Integer nombreOdinateur) {
		this.idSalle = idSalle;
		this.numero = numero;
		this.etage = etage;
		this.nombreOdinateur = nombreOdinateur;
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
	public Integer getNombreOdinateur() {
		return nombreOdinateur;
	}

	/**
	 * @param nombreOdinateur the nombreOdinateur to set
	 */
	public void setNombreOdinateur(Integer nombreOdinateur) {
		this.nombreOdinateur = nombreOdinateur;
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
		
}
