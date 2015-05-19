/**
 * 
 */
package mesClasses;

/**
 * @author guigui
 *
 */
public class Routeur extends Equipement {
	private Ordinateur [] ordinateurs; 	
	
	/**
	 * @param mac
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
	 * @param nombrePorts
	 */
	public Routeur(String mac, String nom, String marque,
			boolean power, Os os, Integer nombrePorts) {
		super(mac, nom, marque, power, os);
		ordinateurs=new Ordinateur [nombrePorts];
	}

	/**
	 * @return the nombrePorts
	 */
	public Integer getNombrePorts() {
		return ordinateurs.length;
	}

	/**
	 * 
	 * @return le numero de port libre du routeur, -1 si aucun port 
	 */
	public Integer obtenirPortLibre(){
		int i=0;
		while(i<ordinateurs.length){
			if(ordinateurs[i]==null){
				return i;
			}
			i++;
		}		
		return -1;
	}
	
	public void connecterOrdinateur(Ordinateur ordi){
		Ordinateur ordiRech=rechercherOrdinateur(ordi.getMac());
		if(ordiRech!=null){
			System.out.println("L'ordinateur est déjà dans la salle.");
			return;
		}		
		int portLibre=obtenirPortLibre();
		if(portLibre!=-1){
			System.out.println("ajout de l'ordinateur "+ordi.getNom() +" sur le routeur "+ this.getNom()+" sur le port "+ portLibre+".");
			ordinateurs[portLibre]=ordi;
		}
		else System.out.println("Le routeur n'a pas de port de libre.");
	}	
	
	public String toString() {
		String str=super.toString();
		str+="nombre de ports: "+getNombrePorts()+"\n";
		for(int i=0;i<ordinateurs.length;i++){
			str+="[Port "+i+"]\n";
			if(ordinateurs[i]!=null)
				str+=ordinateurs[i].toString()+"\n";
			else str+="Vide\n";
		}
		return str;
	}

	public void activerDesactiverOrdinateur(boolean power) {
		for(int i=0;i<ordinateurs.length;i++){
                    if(ordinateurs[i]!=null){
			ordinateurs[i].activerDesactiverAppareil(power);
                    }
		}
	}	
	
	public Ordinateur rechercherOrdinateur(String mac){
		for(int i=0;i<ordinateurs.length;i++){
			if(ordinateurs[i]!=null && ordinateurs[i].getMac().equalsIgnoreCase(mac)){
				return ordinateurs[i];
			}
		}
		return null;
	}
	
	public boolean activerDesactiverAppareil(String mac,boolean power){
		Ordinateur ordiRech=rechercherOrdinateur(mac);
		if(ordiRech!=null){
			ordiRech.activerDesactiverAppareil(power);
			return true;
		}
		return false;
	}
}
