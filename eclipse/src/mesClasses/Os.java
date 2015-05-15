/**
 * 
 */
package mesClasses;

/**
 * @author guigui
 *
 */
public class Os {
	private Integer idOs;
	private String version;
	private String nomOs;
	
	/**
	 * @param version
	 * @param nomOs
	 */
	public Os(String version, String nomOs) {
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
}
