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
	private ArrayList<Tablette> tablettes;

	/**
	 * @param mac
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
	 */
	public BorneSansFil(String mac, String nom,
			String marque, boolean power,Os os) {
		super(mac, nom, marque, power,os);
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
