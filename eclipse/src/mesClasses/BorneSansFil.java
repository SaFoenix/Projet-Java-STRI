/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * @author STRI_JAVA
 *
 */
public class BorneSansFil extends Equipement {
	/**
	 * definit le nombre d'appareil connectés à la borne 
	 * à la construction est égale à zero
	 */
	private Integer nombreConnexion;
	private ArrayList<Tablette> tablettes;

	/**
	 * @param mac
	 * @param nom
	 * @param connectique
	 * @param marque
	 * @param power
	 * @param os
	 */
	public BorneSansFil(String mac, String nom, String connectique,
			String marque, boolean power,Os os) {
		super(mac, nom, connectique, marque, power,os);
		nombreConnexion=0;
		tablettes=new ArrayList<Tablette>();
	}
	
	public boolean connecterTablette(Tablette nouvelleTablette){
		tablettes.add(nouvelleTablette);
		return true;
	}
	public boolean deconnecter(Tablette suppTablette){
		if(tablettes.contains(suppTablette)){
			tablettes.remove(suppTablette);
		}
		return true;
	}
	
}
