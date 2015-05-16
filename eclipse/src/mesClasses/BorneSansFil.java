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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str=super.toString();
		int i=0;
		for(Tablette tab:tablettes){
			str+="-Tablette "+i+1+"\n";
			str+=tab.toString()+"\n";
			i++;
		}
		return str;
	}
	
	
	public void connecterTablette(Tablette nouvelleTablette){
		tablettes.add(nouvelleTablette);		
	}
	public boolean deconnecter(Tablette suppTablette){
		if(tablettes.contains(suppTablette)){
			tablettes.remove(suppTablette);
		}
		return true;
	}
	
}
