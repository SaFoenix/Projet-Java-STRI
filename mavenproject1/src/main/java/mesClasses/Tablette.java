/**
 * 
 */
package mesClasses;

/**
 * La classe permet de définir un tablette, elle est une classe dérivée de Equipement
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
	private String modele;

	/**
         * Le constructeur de Tablette
	 * @param mac 
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
	 * @param capacite la capacité de la tablette
	 * @param modele le modele de la tablette
	 */
	public Tablette(String nom, String mac, String marque,
			boolean power, Os os, String capacite, String modele) {
		super(nom, mac, marque, power, os);
		this.capacite = capacite;
		this.modele = modele;
	}

	/**
         * Retourne la capacité de l'os
	 * @return the capacite
	 */
	public String getCapacite() {
		return capacite;
	}

	/**
         * retourne le modele
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	public String toString() {
		String str=super.toString();
		str+="capacite=" + capacite + ", modele=" + modele+"\n";
		return str;
	}
	
}
