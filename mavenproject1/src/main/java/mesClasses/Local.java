/**
 *
 */
package mesClasses;

import java.util.ArrayList;

/**
 * La classe Local permet de definir un local d'une société 
 * elle est definie par un identifiant unique attribuée définitivement 
 * elle a un nom qui peut être modifiée 
 * elle a un nom de la ville elle a une liste de salles
 *
 * @author STRI_JAVA
 *
 */
public class Local {

    /**
     * L'id du local, créé à la contuction du local, ne peut plus être modifié.
     */
    private Integer idLocal;

    /**
     * La localisation du local, une ville
     */
    private String localisation;
    /**
     * Le nom du local, unique
     */
    private String nom;
    /**
     * La liste des salles qui sont disponibles dans le local
     *
     * @see Salle
     */
    private ArrayList<Salle> salles;

    /**
     * Le constructeur de Local
     *
     * @param nom Le nom du local
     * @param localisation La localisation du local
     */
    public Local(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
        salles = new ArrayList<Salle>();
    }

    /**
     * recherche une salle dans un local
     *
     * @param numero le numero de la salle à rechercher
     * @param etage l'etage de la salle
     * @return le salle recherchée ou null si non trouvée
     */
    private Salle rechercherSalle(Integer numero, Integer etage) {
        for (Salle salleRech : salles) {
            if ((salleRech.getEtage() == etage) && (salleRech.getNumero() == numero)) {
                return salleRech;
            }
        }
        return null;
    }

    /**
     * Ajoute une salle dans un local
     *
     * @param numero le numero de la salle
     * @param nombreOrdi le nombre d'ordinateur maximum que peut contenir la
     * salle
     * @param etage L'etage de la salle
     */
    public void ajouterSalle(Integer numero, Integer etage, Integer nombreOrdi) {
        Salle sall = new Salle(numero, etage, nombreOrdi);
        if (rechercherSalle(numero, etage) == null) {
            System.out.println("La salle, numero " + numero + ", etage " + etage + ", a été ajoutée au local " + nom + ".");
            salles.add(sall);
        } else {
            System.out.println("La salle, numero " + numero + ", etage " + etage + ", existe déjà.");
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str;
        str = "Local: " + nom + " [" + localisation + "]\n";
        for (Salle sa : salles) {
            str += sa.toString() + "\n";
        }
        return str;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Supprimer une salle
     *
     * @param numero le numero de la salle à supprimer
     * @param etage l'etage de la salle
     */
    public void supprimerSalle(Integer numero, Integer etage) {
        Salle sal = rechercherSalle(numero, etage);
        if (sal != null) {
            System.out.println("La salle numero " + numero + " etage " + etage + " a été supprimée.");
            salles.remove(sal);
        } else {
            System.out.println("La salle numero " + numero + " etage " + etage + " n'existe pas.");
        }
    }

    /**
     * Ajoute un Routeur à une salle
     *
     * @param rout Le routeur à ajouter dans une salle
     * @param numero Le numero de la salle
     * @param etage L'etage de la salle
     */
    public void ajouterRouteurSalle(Routeur rout, Integer numero, Integer etage) {
        Salle salle = rechercherSalle(numero, etage);
        if (salle != null) {
            salle.ajouterRouteur(rout);
        } else {
            System.out.println("La salle " + numero + " etage " + etage + " n'existe pas, impossible d'ajouter le routeur.");
        }
    }

    /**
     * Connecte un ordinateur à un routeur
     *
     * @param ordi L'ordinateur à connecter au routeur
     * @param etage L'etage de la salle
     * @param numero Le numero de la salle
     * @param macRout La Mac du routeur
     */
    public void connecterOrdinateur(Ordinateur ordi, Integer numero, Integer etage, String macRout) {
        Salle salle = rechercherSalle(numero, etage);
        if (salle != null) {
            salle.connecterOrdinateur(ordi, macRout);
        } else {
            System.out.println("La salle " + numero + " etage " + etage + " n'existe pas, impossible d'ajouter l'ordinateur.");
        }
    }

    /**
     * le nombre de salle du local
     *
     * @return le nombre de salle
     */
    public int nombreDeSalle() {
        return salles.size();
    }

    /**
     * Ajoute une borne Wifi à une salle
     *
     * @param borne La borne à ajouter
     * @param etage L'etage de la salle
     * @param numero le numero de la salle
     */
    public void ajouterBorneSansFil(BorneSansFil borne, Integer etage,
            Integer numero) {
        Salle sal = rechercherSalle(numero, etage);
        if (sal != null) {
            sal.ajouterBorneSansFil(borne);
        } else {
            System.out.println("La salle " + numero + " etage " + etage + " n'existe pas, impossible d'ajouter la borne.");
        }
    }

    /**
     * Connecte une tablette à une borne Wifi
     *
     * @param tab La tablette à connecter
     * @param etage L'etage de la salle
     * @param numero Le numero de la salle
     * @param macBorne La mac de la borne
     */
    public void connecterTablette(Tablette tab, Integer etage, Integer numero,
            String macBorne) {
        Salle sal = rechercherSalle(numero, etage);
        if (sal != null) {
            sal.connecterTablette(tab, macBorne);
        } else {
            System.out.println("La salle " + numero + " etage " + etage + " n'existe pas, impossible d'ajouter la tablette.");
        }

    }

    /**
     * Le message d'erreur si salle n'existe pas
     *
     * @param numero le numero de la salle
     * @param etage Le numero de l'étage
     * @param str le message à afficher
     */
    private void messageNonTrouve(Integer numero, Integer etage, String str) {
        System.out.println("La salle " + numero + " etage " + etage + " n'existe pas, " + str);
    }

    /**
     * Active ou désactive un equipement donc l'adresse Mac est donnée en
     * paramètre
     *
     * @param mac La mac de l'equipement
     * @param numero le numero de la salle
     * @param etage L'etage de la salle
     * @param power true pour activer, false pour désactiver
     */
    public void activerDesactiverAppareil(String mac, Integer numero,
            Integer etage, boolean power) {
        Salle sal = rechercherSalle(numero, etage);
        if (sal != null) {
            sal.activerDesactiverAppareil(mac, power);
        } else {
            messageNonTrouve(numero, etage, "l'equipement ne peut pas être désactivé.");
        }
    }

    /**
     * Mise à jour d'un equipement dont l'adresse Mac est donnée en paramètre
     *
     * @param numero Le numero de la salle
     * @param etage L'étage de la salle
     * @param mac La mac de l'equipement à mettre à jour
     * @param newOs Le nouvelle OS à installer sur l'equipement
     */
    public void miseAJour(Integer numero, Integer etage, String mac, Os newOs) {
        Salle sal = rechercherSalle(numero, etage);
        if (sal != null) {
            sal.miseAJour(mac, newOs);
        } else {
            messageNonTrouve(numero, etage, "l'equipement ne peut pas mis à jour.");
        }
    }

    /**
     * retourne la localisation du local
     *
     * @return localisation
     */
    public String getlocalisation() {
        return localisation;
    }
}
