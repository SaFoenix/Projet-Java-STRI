/**
 *
 */
package mesClasses;

import java.util.ArrayList;

/**
 * @author STRI_JAVA
 *
 */
public class Salle {

    private Integer idSalle;
    private Integer numero;
    private Integer etage;
    private Integer nombreOrdinateur;
    private ArrayList<Routeur> routeurs;
    private ArrayList<BorneSansFil> bornes;

    /**
     * @param numero
     * @param etage
     * @param nombreOrdinateur
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

    public Routeur rechercherRouteur(String mac) {
        for (Routeur rout : routeurs) {
            if (rout.getMac().equalsIgnoreCase(mac)) {
                return rout;
            }
        }
        return null;
    }

    public BorneSansFil rechercherBorne(String mac) {
        for (BorneSansFil bo : bornes) {
            if (bo.getMac().equalsIgnoreCase(mac)) {
                return bo;
            }
        }
        return null;
    }

    public void connecterOrdinateur(Ordinateur ordi, String mac) {
        Routeur rout = rechercherRouteur(mac);
        if (rout == null) {
            System.out.println("Le routeur n'existe pas.");
        } else {
            rout.connecterOrdinateur(ordi);
        }
    }

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

    public void connecterTablette(Tablette tab, String macBorne) {
        BorneSansFil boRech = rechercherBorne(macBorne);
        if (boRech != null) {
            boRech.connecterTablette(tab);
        } else {
            System.out.println("Le borne n'existe pas.");
        }
    }

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
}
