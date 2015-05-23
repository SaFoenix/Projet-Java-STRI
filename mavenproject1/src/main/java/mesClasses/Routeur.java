/**
 * 
 */
package mesClasses;

/**
 * La classe Routeur definit un routeur, classe derivée de Equipement
 * information ;
 *  les informations sur equipement
 *  La liste des ordinateurs connectés au routeur
 * 
 * @see Equipement
 * @author guigui
 *
 */
public class Routeur extends Equipement {
    /**
     * Tableau contenant les ordinateurs
     */
	private Ordinateur [] ordinateurs; 	
	
	/**
         * constructeur de Routeur
	 * @param mac
	 * @param nom
	 * @param marque
	 * @param power
	 * @param os
	 * @param nombrePorts Le nombre de port du routeur
	 */ 
	public Routeur(String nom, String mac, String marque,
			boolean power, Os os, Integer nombrePorts) {
		super(nom, mac, marque, power, os);
		ordinateurs=new Ordinateur [nombrePorts];
	}

	/**
	 * @return the nombrePorts
	 */
	public Integer getNombrePorts() {
		return ordinateurs.length;
	}

	/**
	 * Retourne le premier port de libre pour connecter un ordinateur
	 * @return le numero de port libre du routeur, -1 si aucun port disponible
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
	/**
         * connecter un ordinateur
         * @param ordi ordinateur à ajouter au routeur
         * @see Ordinateur
         */
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
	
        @Override
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

    /**
     * desactiver/activer les ordinateurs du routeurs
     *
     * @param power nouvel etat de l'ordinateur
     */
    public void activerDesactiverOrdinateur(boolean power) {
        for (int i = 0; i < ordinateurs.length; i++) {
            if (ordinateurs[i] != null) {
                ordinateurs[i].activerDesactiverAppareil(power);
            }
        }
    }

    /**
     *Recherche un ordinateur sur le routeur
     * @param mac adresse mac de l'ordinateur à rechercher
     * @return l'ordinateur recherché ou null
     */
    public Ordinateur rechercherOrdinateur(String mac) {
        for (int i = 0; i < ordinateurs.length; i++) {
            if (ordinateurs[i] != null && ordinateurs[i].getMac().equalsIgnoreCase(mac)) {
                return ordinateurs[i];
            }
        }
        return null;
    }

    /**
     *activer/desactiver un appareil
     * @param mac l'adresse mac de l'ordinateur
     * @param power nouvel état
     * @return retourne un boolean, true si appareil trouvé, false sinon
     */
    public boolean activerDesactiverAppareil(String mac, boolean power) {
        Ordinateur ordiRech = rechercherOrdinateur(mac);
        if (ordiRech != null) {
            ordiRech.activerDesactiverAppareil(power);
            return true;
        }
        return false;
    }
    /**
     * Retourne les ordinateurs du routeur
     * @return ordinateurs
     */
    public Ordinateur [] retournerOrdinateurs(){
        return ordinateurs;
    }
}
