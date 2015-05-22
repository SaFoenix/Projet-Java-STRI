/**
 *
 */
package mesClasses;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * La classe Salle permet de définir une salle
 * informations: 
 * Identifiant de la salle 
 * L'etage de la salle
 * Le numero de la salle 
 * Le nombre d'ordinateur que peut contenir la salle 
 * La liste des routeurs 
 * La liste des bornes Wifi
 *
 * @author STRI_JAVA
 *
 */
public class Salle{

    /**
     * L'identifiant de la salle
     */
    private Integer idSalle;
    /**
     * Le numero de la salle
     */
    private Integer numero;
    /**
     * L'etage de la salle
     */
    private Integer etage;
    /**
     * Le nombre de l'ordinateur maximum que peut contenir la salle
     */
    private Integer nombreOrdinateur;
    /**
     * La liste des routeurs
     *
     * @see Routeur
     */
    private ArrayList<Routeur> routeurs;
    /**
     * La liste des bornes Wifi dans la salle
     *
     * @see BorneSansFil
     */
    private ArrayList<BorneSansFil> bornes;

    /**
     * Le constructeur de la salle
     *
     * @param numero le numero de la salle
     * @param etage l'etage de la salle
     * @param nombreOrdinateur Le nombre de la salle
     */
    public Salle(Integer numero, Integer etage, Integer nombreOrdinateur) {
        this.numero = numero;
        this.etage = etage;
        this.nombreOrdinateur = nombreOrdinateur;
        routeurs = new ArrayList<Routeur>();
        bornes = new ArrayList<BorneSansFil>();
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @return the nombreOdinateur
     */
    public Integer getNombreOrdinateur() {
        return nombreOrdinateur;
    }

    /**
     * @param nombreOrdinateur the nombreOrdinateur to set
     */
    public void setNombreOrdinateur(Integer nombreOrdinateur) {
        this.nombreOrdinateur = nombreOrdinateur;
    }

    /**
     * @return the idSalle
     */
    public Integer getIdSalle() {
        return idSalle;
    }

    /**
     * @return the etage
     */
    public Integer getEtage() {
        return etage;
    }

    public String toString() {
        String str = "Salle [" + etage + numero + "]\n";
        str += "\tnombreOrdinateur: " + nombreOrdinateur + "\n";
        str += "[Routeur]\n";
        for (Routeur rout : routeurs) {
            str += rout.toString() + "\n";
        }
        str += "[Bornes Wifi]\n";
        for (BorneSansFil bor : bornes) {
            str += bor.toString() + "\n";
        }
        return str;
    }

    /**
     * ajouter un routeur
     *
     * @param rout le routeur à ajouter
     */
    public void ajouterRouteur(Routeur rout) {
        for (Routeur obj : routeurs) {
            if (obj.getMac().equalsIgnoreCase(rout.getMac())) {
                System.out.println("Le retour " + rout.getMac() + " est déjà connecté dans la salle.");
                return;
            }
        }
        System.out.println("Le routeur " + rout.getMac() + " a été ajouté.");
        routeurs.add(rout);
    }

    /**
     * Rechercher un routeur suivant une adresse mac
     *
     * @param mac l'adresse mac
     * @return le routeur recherché ou null
     */
    public Routeur rechercherRouteur(String mac) {
        for (Routeur rout : routeurs) {
            if (rout.getMac().equalsIgnoreCase(mac)) {
                return rout;
            }
        }
        return null;
    }

    /**
     * Rechercher une borne Wifi suivant une adresse mac
     *
     * @param mac l'adresse mac
     * @return le borne Wifi recherchée ou null
     */
    public BorneSansFil rechercherBorne(String mac) {
        for (BorneSansFil bo : bornes) {
            if (bo.getMac().equalsIgnoreCase(mac)) {
                return bo;
            }
        }
        return null;
    }

    /**
     * connecter un ordinateur à un routeur
     *
     * @param ordi l'ordinateur à ajouter
     * @param mac L'adresse mac du routeur
     */
    public void connecterOrdinateur(Ordinateur ordi, String mac) {
        Routeur rout = rechercherRouteur(mac);
        if (rout == null) {
            System.out.println("Le routeur n'existe pas.");
        } else {
            rout.connecterOrdinateur(ordi);
        }
    }

    /**
     * ajouter une borne Wifi
     *
     * @param borne la borne Wifi
     */
    public void ajouterBorneSansFil(BorneSansFil borne) {
        for (BorneSansFil bo : bornes) {
            if (bo.getMac().equalsIgnoreCase(borne.getMac())) {
                System.out.println("La borne est déjà dans la salle.");
                return;
            }
        }
        System.out.println("La borne est ajoutée dans la salle.");
        bornes.add(borne);
    }

    /**
     * Connecter une tablette à une borne Wifi
     *
     * @param tab la tablette à ajouter
     * @param macBorne L'adresse mac de la borne
     */
    public void connecterTablette(Tablette tab, String macBorne) {
        BorneSansFil boRech = rechercherBorne(macBorne);
        if (boRech != null) {
            boRech.connecterTablette(tab);
        } else {
            System.out.println("Le borne n'existe pas.");
        }
    }

    /**
     * Active ou désactive un equipement donc l'adresse Mac est donnée en
     * paramètre
     *
     * @param mac La mac de l'equipement
     * @param power true pour activer, false pour désactiver
     */
    public void activerDesactiverAppareil(String mac, boolean power) {
        Routeur rout = rechercherRouteur(mac);
        if (rout != null) {
            rout.activerDesactiverAppareil(power);
            rout.activerDesactiverOrdinateur(power);
            return;
        } else {
            BorneSansFil bo = rechercherBorne(mac);
            if (bo != null) {
                bo.activerDesactiverAppareil(power);
                bo.activerDesactiverTablette(power);
                return;
            } else {
                for (Routeur routIterateur : routeurs) {
                    boolean trouve = routIterateur.activerDesactiverAppareil(mac, power);
                    if (trouve) {
                        return;
                    }
                }

                for (BorneSansFil boIte : bornes) {
                    boolean trouve = boIte.activerDesactiverAppareil(mac, power);
                    if (trouve) {
                        return;
                    }
                }
                System.out.println("L'équipement non trouvé.");
            }
        }
    }

    /**
     * Mise à jour d'un equipement dont l'adresse Mac est donnée en paramètre
     *
     * @param mac La mac de l'equipement à mettre à jour
     * @param newOs Le nouvelle OS à installer sur l'equipement
     */
    public void miseAJour(String mac, Os newOs) {
        Routeur rout = rechercherRouteur(mac);
        if (rout != null) {
            rout.miseAJour(newOs);
            return;
        } else {
            BorneSansFil bo = rechercherBorne(mac);
            if (bo != null) {
                bo.miseAJour(newOs);
                return;
            } else {
                for (Routeur routIterateur : routeurs) {
                    Ordinateur ordi = routIterateur.rechercherOrdinateur(mac);
                    if (ordi != null) {
                        ordi.miseAJour(newOs);
                        return;
                    }
                }

                for (BorneSansFil boIte : bornes) {
                    Tablette tab = boIte.rechercherTablette(mac);
                    if (tab != null) {
                        tab.miseAJour(newOs);
                        return;
                    }
                }
                System.out.println("L'équipement non trouvé.");
            }
        }
    }

    public ArrayList<Routeur> getRouteurs() {
        return routeurs;
    }

    public ArrayList<BorneSansFil> getBornes() {
        return bornes;
    }
}
