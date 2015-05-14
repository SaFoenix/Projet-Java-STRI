/**
 * 
 */
package mesClasses;

/**
 * La classe abstraite Equipement
 * 
 * @author STRI_JAVA
 *
 */
public abstract class Equipement {
	/**
	 * L'adresse MAC de l'equipement, ne peut pas être modifée une fois l'equipement créé, est unique
	 */
	private String mac;
	/**
	 * Le nom de l'equipement, il peut être modifié
	 */
	private String nom;
	private String connectique;
	/**
	 * la marque de l'appareil, ne peut pas être modifiée apres la creation
	 */
	private String marque;
	/**
	 * definit si l'equipement est allumé ou eteint
	 */
	private boolean power;
	private Os os;

	/**
	 * @param mac
	 * 				l'adresse MAC est unique
	 * @param nom
	 * 				Le nom de l'equipement
	 * @param connectique
	 * @param marque
	 * @param power
	 * @param os
	 */
	public Equipement(String mac, String nom, String connectique,String marque, boolean power,Os os) {
		this.mac = mac;
		this.nom = nom;
		this.connectique = connectique;
		this.marque = marque;
		this.power = power;
		this.os=os;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getConnectique() {
		return connectique;
	}
	public void setConnectique(String connectique) {
		this.connectique = connectique;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}

	/**
	 * @return the os
	 */
	public Os getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(Os os) {
		this.os = os;
	}
}
