/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * @author guigui
 *
 */
public class Routeur extends Equipement {
	private Integer nombrePorts;
	private ArrayList<Ordinateur> ordinateurs;
	
	/**
	 * @param mac
	 * @param nom
	 * @param connectique
	 * @param marque
	 * @param power
	 * @param os
	 * @param nombrePorts
	 * @param ordinateurs
	 */
	public Routeur(String mac, String nom, String connectique, String marque,
			boolean power, Os os, Integer nombrePorts) {
		super(mac, nom, connectique, marque, power, os);
		this.nombrePorts = nombrePorts;
		ordinateurs=new ArrayList<Ordinateur>();
	}

	/**
	 * @return the nombrePorts
	 */
	public Integer getNombrePorts() {
		return nombrePorts;
	}

	/**
	 * @param nombrePorts the nombrePorts to set
	 */
	public void setNombrePorts(Integer nombrePorts) {
		this.nombrePorts = nombrePorts;
	}
	
	public boolean connecterOdinateur(Ordinateur ordi){
		ordinateurs.add(ordi);
		return true;
	}	
	
	public boolean deconnecterOrdinateur(Ordinateur ordi){
		ordinateurs.remove(ordi);
		return true;
	}
}
