/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * 
 * @author STRI_JAVA
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
			str+="-Tablette "+(i+1)+"\n";
			str+=tab.toString()+"\n";
			i++;
		}
		return str;
	}
	
	
	public void connecterTablette(Tablette nouvelleTablette){
		Tablette tab=rechercherTablette(nouvelleTablette.getMac());
		if(tab==null){
			System.out.println("La tablette est connecté à la borne Wifi.");
			tablettes.add(nouvelleTablette);	
		}
		else System.out.println("La tablette est deja connecté à la borne Wifi.");
	}
	
	public boolean deconnecter(Tablette suppTablette){
		if(tablettes.contains(suppTablette)){
			tablettes.remove(suppTablette);
		}
		return true;
	}

	public void activerDesactiverTablette(boolean power) {
			for(Tablette tabl:tablettes)
				tabl.activerDesactiverAppareil(power);
	}

	public Tablette rechercherTablette(String mac){
		for(Tablette tab:tablettes){
			if(tab.getMac().equalsIgnoreCase(mac)){
				return tab;
			}
		}
		return null;
	}
	public boolean activerDesactiverAppareil(String mac, boolean power) {
		Tablette tab=rechercherTablette(mac);
		if(tab!=null){
			tab.activerDesactiverAppareil(power);
			return true;
		}
		return false;
	}	
	
}
