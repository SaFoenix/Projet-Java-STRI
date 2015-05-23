/**
 *
 */
package mesClasses;

/**
 * La classe Equipement qui represente la super classe equipement: La mac de
 * l'equipement, non modifiable Le nom de l'equipement La marque de l'equipement
 * L'etat de l'equipement (true=on;false=off) L'os de l'equipement
 *
 * @author STRI_JAVA
 *
 */
public class Equipement {

    /**
     * L'adresse MAC de l'equipement, ne peut pas être modifée une fois
     * l'equipement créé, est unique
     */
    private final String mac;
    /**
     * Le nom de l'equipement, il peut être modifié
     */
    private String nom;

    /**
     * la marque de l'appareil, ne peut pas être modifiée apres la creation
     */
    private final String marque;
    /**
     * definit si l'equipement est allumé ou eteint
     */
    private boolean power;
    /**
     * L'os de l'equipement
     *
     * @see Os
     */
    private Os os;

    /**
     * Le constructeur Equipement
     *
     * @param mac l'adresse MAC est unique
     * @param nom Le nom de l'equipement
     * @param marque La marque de l'equipement
     * @param power état de l'equipement, on ou off
     * @param os L'os de l'equipement
     */
    public Equipement(String mac, String nom, String marque, boolean power, Os os) {
        this.nom = nom;
        this.mac = mac;
        this.marque = marque;
        this.power = power;
        this.os = os;
    }

    /**
     *
     * @return la mac de l'equipement
     */
    public String getMac() {
        return mac;
    }

    /**
     * retourne le nom de l'equipement
     *
     * @return Le nom de l'equipement
     */
    public String getNom() {
        return nom;
    }

    /**
     * modifie le nom de l'equipement
     *
     * @param nom le nouveau nom de l'equipement
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return la marque de l'equipement
     */
    public String getMarque() {
        return marque;
    }

    /**
     * retourne l'etat de l'equipement
     *
     * @return l'etat de l'equipement
     */
    public boolean isPower() {
        return power;
    }

    /**
     * modifie l'etat de l'equipement
     *
     * @param power nouvel etat de l'equipement
     */
    public void setPower(boolean power) {
        this.power = power;
    }

    /**
     * @return the os
     * @see Os
     */
    public Os getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(Os os) {
        this.os = os;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = "Nom: " + getNom() + "\n";
        str += "Mac: " + getMac() + "\tMarque: " + getMarque() + "\n";
        str += "power: ";
        str += (isPower() ? "on" : "off");
        str += "\n";
        str += os.toString() + "\n";
        return str;
    }

     /**
     * Active ou désactive un equipement donc l'adresse Mac est donnée en
     * paramètre
     * @param pow  true pour activer, false pour désactiver
     */
    public void activerDesactiverAppareil(boolean pow) {
        String str;
        if (this instanceof Ordinateur) {
            str = "L'ordinateur ";
        } else if (this instanceof Tablette) {
            str = "La Tablette ";
        } else if (this instanceof Routeur) {
            str = "Le routeur ";
        } else {
            str = "La borne Wifi ";
        }
        str += (getNom() + " est " + (pow ? "activé." : "désactivé."));
        System.out.println(str);
    }

    /**
     * Mise à jour d'un equipement dont l'adresse Mac est donnée en paramètre
     * @param newOs Le nouvelle OS à installer sur l'equipement
     */
    public void miseAJour(Os newOs) {
        if (newOs.getNomOs().equalsIgnoreCase(os.getNomOs()) && newOs.getVersion().equalsIgnoreCase(os.getVersion())) {
            System.out.println("L'os est le même, mise à jour inutile.");
        } else {
            System.out.println("Mise a jour de l'equipement.");
            this.setOs(newOs);
        }
    }
}
