/**
 * 
 */
package mesClasses;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author guigui
 *
 */
public class Routeur extends Equipement {
	private Integer nombrePorts;
	private Equipement [] equipements; 	
	
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
		equipements=new Equipement [nombrePorts];
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
	
	/**
	 * 
	 * @return le numero de port libre du routeur, -1 si aucun port 
	 */
	public Integer obtenirPortLibre(){
		int i=0;
		while(i<equipements.length){
			if(equipements[i]==null){
				return i;
			}
			i++;
		}		
		return -1;
	}
	
	public void connecterOrdinateur(Ordinateur ordi){
		int portLibre=obtenirPortLibre();
		if(portLibre!=-1){
			System.out.println("ajout de l'ordinateur "+ordi.getNom() +" sur le routeur "+ this.getNom()+" sur le port "+ portLibre+".");
			equipements[portLibre]=ordi;
		}
		else System.out.println("Le routeur n'a pas de port de libre.");
	}	
	
	public void deconnecterEquipement(Integer numeroPort){
		equipements[numeroPort]=null;
	}
}
