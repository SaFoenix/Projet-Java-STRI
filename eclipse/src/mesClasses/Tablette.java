/**
 * 
 */
package mesClasses;

/**
 * La classe permet de définir un tablette, elle est une sous classe d'appareil
 * On y trouve comme informations:
 * la capacité de stockage de l'appareil
 * le modele de l'appareil
 * 
 * @see Equipement
 * 
 * @author STRI_JAVA
 *
 */
public class Tablette extends Equipement {
	/**
	 * La capacité definit la capacité de stockage de l'appareil
	 */
	private String capacite;
	
	/**
	 * le modele represente le modele de l'appareil
	 */
	private Integer modele;

	/**
	 * @param mac
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
	 * @param capacite
	 * @param modele
	 */
	public Tablette(String mac, String nom, String marque,
			boolean power, Os os, String capacite, Integer modele) {
		super(mac, nom, marque, power, os);
		this.capacite = capacite;
		this.modele = modele;
	}

	/**
	 * @return the capacite
	 */
	public String getCapacite() {
		return capacite;
	}

	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	/**
	 * @return the modele
	 */
	public Integer getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(Integer modele) {
		this.modele = modele;
	}
	
}
