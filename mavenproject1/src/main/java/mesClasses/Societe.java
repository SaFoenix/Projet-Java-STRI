/**
 *
 */
package mesClasses;

import java.util.ArrayList;

/**
 * La classe société permet de définir une société. On y trouve les
 * informationssuivantes: L'id de la société qui unique et non modifiable Le nom
 * de la société La ville où elle est domiciliée. La liste de locaux qu'elle
 * possède.
 *
 * @author STRI_JAVA
 */
public class Societe {

    /**
     * l'identifiant idSociete
     */
    private Integer idSociete;
    /**
     * Le nom de la societe
     */
    private String nom;
    /**
     * La localisation
     */
    private String localisation;
    /**
     * La liste des locaux appartenant la societe
     */
    private ArrayList<Local> locaux;

    /**
     * Le construteur de Societe
     *
     * @param nom Le nom de la societe
     * @param localisation La localisation de la societe
     */
    public Societe(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
        locaux = new ArrayList<Local>();
    }

    /**
     * ajoute une salle à un local
     *
     * @param nomL le nom du local où ajouter la salle
     * @param numero Le numero de la salle
     * @param etage L'étage de la salle
     * @param nombreOrdi Le nombre d'ordi de la salle
     */
    public void ajouterSalle(String nomL, Integer numero, Integer etage, Integer nombreOrdi) {
        Local locRech = rechercherLocal(nomL);
        if (locRech == null) {
            System.out.println("Le local " + nomL + " n'existe pas. La salle, numero " + numero + ", etage " + etage + " n'a pas été ajoutée.");
            return;
        }
        locRech.ajouterSalle(numero, nombreOrdi, etage);
    }

    /**
     * Routourne le local recherché
     *
     * @param nomL Le nom du local à rechercher
     * @return Le local recherché ou null si non trouvé
     */
    private Local rechercherLocal(String nomL) {

        for (Local locRech : locaux) {
            if (locRech.getNom().equalsIgnoreCase(nomL)) {
                return locRech;
            }
        }
        return null;
    }

    /**
     *
     * @param nomL Le nom du local à rechercher
     * @param localisation La localisation de la societe
     */
    public void ajouterLocal(String nomL, String localisation) {
        Local nouvLocal = new Local(nomL, localisation);
        for (Local loc : locaux) {
            if (loc.getNom().equalsIgnoreCase(nomL)) {
                System.out.println("Le local " + nomL + " existe déjà.");
                return;
            }
        }
        locaux.add(nouvLocal);
        System.out.println("Le local " + nomL + " a été ajouté.");
        return;
    }

    /**
     * supprime le local de la liste
     *
     * @param nomL Le nom du local à supprimer
     */
    public void supprimerLocal(String nomL) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            System.out.println("Le local " + nomL + " a été supprimé.");
            locaux.remove(loc);
        } else {
            System.out.println("Le local " + nomL + " n'existe pas.");
        }
    }

    /**
     * supprimer une salle d'un local donné.
     *
     * @param nomL le nom du local
     * @param etage l'etage de la salle
     * @param numero le numero de la salle
     */
    public void supprimerSalle(String nomL, Integer etage, Integer numero) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.supprimerSalle(etage, numero);
        } else {
            System.out.println("Le local " + nomL + " n'existe pas");
        }

    }

    /**
     *
     * @return une chaine
     */
    public String toString() {
        String str;
        str = "Société: " + nom + " [" + localisation + "]\n";
        for (Local loc : locaux) {
            str += loc.toString();
        }
        return str;
    }

    /**
     * ajoute un routeur à une salle
     *
     * @param rout le routeur à ajouter
     * @param etage l'etage de la salle où ajouter le routeur
     * @param numero le numero de la salle où ajouter le routeur
     * @param nomL le nom du local où ajouter le routeur
     */
    public void ajouterRouteurSalle(Routeur rout, Integer etage, Integer numero, String nomL) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.ajouterRouteurSalle(rout, numero, etage);
        } else {
            System.out.println("Le local n'existe pas");
        }
    }

    /**
     * Connecte un ordinateur à un routeur
     *
     * @param ordi L'ordinateur à connecter au routeur
     * @param etage L'etage de la salle
     * @param numero Le numero de la salle
     * @param macRout La Mac du routeur
     * @param nomL Le nom du local
     */
    public void connecterOrdinateur(Ordinateur ordi, Integer etage, Integer numero, String macRout, String nomL) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.connecterOrdinateur(ordi, numero, etage, macRout);
        } else {
            System.out.println("Le local n'existe pas, impossible d'ajouter l'ordinateur");
        }
    }

    /**
     * Ajoute une borne Wifi à une salle
     *
     * @param borne La borne à ajouter
     * @param nomL Le nom du local
     * @param etage L'etage de la salle
     * @param numero le numero de la salle
     */
    public void ajouterBorneSansFil(BorneSansFil borne, String nomL, Integer etage, Integer numero) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.ajouterBorneSansFil(borne, etage, numero);
        } else {
            System.out.println("Le local n'existe pas");
        }
    }

    /**
     * Connecte une tablette à une borne Wifi
     *
     * @param tab La tablette à connecter
     * @param nomL le nom du local
     * @param etage L'etage de la salle
     * @param numero Le numero de la salle
     * @param macBorne La mac de la borne
     */
    public void connecterTablette(Tablette tab, String nomL, Integer etage, Integer numero, String macBorne) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.connecterTablette(tab, etage, numero, macBorne);
        } else {
            System.out.println("Le local n'existe pas");
        }
    }

    /**
     * Active ou désactive un equipement donc l'adresse Mac est donnée en
     * paramètre
     *
     * @param mac La mac de l'equipement
     * @param nomL Le nom du local
     * @param numero le numero de la salle
     * @param etage L'etage de la salle
     * @param power true pour activer, false pour désactiver
     */
    public void activerDesactiverAppareil(String mac, String nomL, Integer numero, Integer etage, boolean power) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.activerDesactiverAppareil(mac, numero, etage, power);
        } else {
            System.out.println("Le local n'existe pas");
        }
    }

    /**
     * Mise à jour d'un equipement dont l'adresse Mac est donnée en paramètre
     *
     * @param nomL Le nom du local
     * @param numero Le numero de la salle
     * @param etage L'étage de la salle
     * @param mac La mac de l'equipement à mettre à jour
     * @param newOs Le nouvelle OS à installer sur l'equipement
     */
    public void miseAJour(String nomL, Integer numero, Integer etage, String mac, Os newOs) {
        Local loc = rechercherLocal(nomL);
        if (loc != null) {
            loc.miseAJour(numero, etage, mac, newOs);
        } else {
            System.out.println("Le local n'existe pas.");
        }
    }
}
