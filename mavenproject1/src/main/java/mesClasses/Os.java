/**
 * 
 */
package mesClasses;

/**
 * La classe OS permet de definir une systeme d'exploitation
 * informations:
 *  L'identifiant de l'os
 *  La version de l'os
 *  Le nom de l'os
 * 
 * @author STRI_JAVA
 *
 */
public class Os {
    /**
     * L'identifiant de l'os
     */
	private Integer idOs;
        /**
         * La version de l'os
         */
	private String version;
        /**
         * Le nom de l'os
         */
	private String nomOs;
	
	/**
         * Le constructeur OS
	 * @param version la version de l'os
	 * @param nomOs Le nom de l'os
	 */
	public Os(String nomOs, String version) {
		this.version = version;
		this.nomOs = nomOs;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the nomOs
	 */
	public String getNomOs() {
		return nomOs;
	}

	/**
	 * @param nomOs the nomOs to set
	 */
	public void setNomOs(String nomOs) {
		this.nomOs = nomOs;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Os [version=" + version + ", nomOs=" + nomOs + "]";
	}
}
