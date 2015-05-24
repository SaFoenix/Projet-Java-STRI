/**
 * 
 */
package mesClasses;

import java.util.ArrayList;

/**
 * La class BorneSansFil represente la borne Wifi, classe dérivée de Equipement 
 * informations:
 * La liste des tablettes 
 * 
 * @see Equipement
 * @author STRI_JAVA
 */
public class BorneSansFil extends Equipement {
	private ArrayList<Tablette> tablettes;

	/**
         * Le constructeur BorneSansFil
	 * @param mac
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
         * @see Equipement
	 */
	public BorneSansFil(String nom, String mac,
			String marque, boolean power,Os os) {
		super(nom, mac, marque, power,os);
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
	
	/**
         * connecter une tablette à une borne Wifi
         * @param nouvelleTablette la tablette à connecter
         */
	public void connecterTablette(Tablette nouvelleTablette){
		Tablette tab=rechercherTablette(nouvelleTablette.getMac());
		if(tab==null){
			System.out.println("La tablette est connecté à la borne Wifi.");
			tablettes.add(nouvelleTablette);	
		}
		else System.out.println("La tablette est deja connecté à la borne Wifi.");
	}
	
        /**
         * deconnecter une tablette de la borne
         * @param suppTablette la tablette à deconnecter
         * @return 
         */
	public boolean deconnecter(Tablette suppTablette){
		if(tablettes.contains(suppTablette)){
			tablettes.remove(suppTablette);
        }
        return true;
    }

    /**
     * L'activer ou désactiver une tablette
     * @param power true/false pour activer/desactiver les tablettes
     */
	public void activerDesactiverTablette(boolean power) {
            for(Tablette tabl:tablettes)
		tabl.activerDesactiverAppareil(power);
	}

       /**
        * rechercher une tablette par rapport à la mac
        * @param mac adresse mac de la tablette à rechercher
        * @return la tablette trouvée ou null
        */
	public Tablette rechercherTablette(String mac){
		for(Tablette tab:tablettes){
			if(tab.getMac().equalsIgnoreCase(mac)){
				return tab;
			}
		}
		return null;
	}
        
        /**
         * retourne les tablettes connectées à la borne
         * @return tablettes
         */
        public ArrayList<Tablette> getTablettes(){
            return tablettes;
        }
        
        /**
         *Activer/Desactiver une tablette en cherchant l'adresse mac 
         * @param mac l'adresse mac de la tablette
         * @param power le nouvel état
         * @return true si trouvé, false sinon
         */
	public boolean activerDesactiverAppareil(String mac, boolean power) {
		Tablette tab=rechercherTablette(mac);
		if(tab!=null){
			tab.activerDesactiverAppareil(power);
			return true;
		}
		return false;
	}	
}
