/**
 * 
 */
package mesClasses;

/**
 * La classe Ordinateur definit un ordinateur, classe derivée de Equipement
 * informations:
 *  La ram
 *  CPU
 *  GPU
 *  HDD
 * 
 * @see Equipement
 * @author STRI_JAVA
 *
 */
public class Ordinateur extends Equipement {
    /**
     * La ram de l'ordinateur
     */
	private String ram; 
        /**
         *Le cpu de l'ordinateur 
         */
	private String cpu;
        /**
         * Le gpu de l'ordinateur
         */
	private String gpu;
        /**
         * La capacité du disque dur de l'ordinateur
         */
	private String hdd;
      
	/**
         * Le constructeur de Ordinateur
	 * @param mac l'adresse mac de l'ordinateir
	 * @param nom le nom de l'ordinateur
	 * @param marque la marque de l'ordinateur
	 * @param power l'etat de l'ordinateur
	 * @param os L'os de l'ordinatuer
	 * @param ram la ram de l' ordinateur
	 * @param cpu le cpu de l'ordinatuer 
	 * @param gpu le gpu de l'ordinateur
	 * @param hdd le disque dur de l'ordinateur
	 */
	public Ordinateur(String nom, String mac,
			String marque, boolean power,Os os, String ram, String cpu, String gpu,
			String hdd) {
		super(nom,mac, marque, power,os);
		this.ram = ram;
		this.cpu = cpu;
		this.gpu = gpu;
		this.hdd = hdd;
	}

	/**
	 * @return the ram
	 */
	public String getRam() {
		return ram;
	}

	/**
	 * @param ram the ram to set
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}

	/**
	 * @return the cpu
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * @param cpu the cpu to set
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * @return the gpu
	 */
	public String getGpu() {
		return gpu;
	}

	/**
	 * @param gpu the gpu to set
	 */
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	/**
	 * @return the hdd
	 */
	public String getHdd() {
		return hdd;
	}

	/**
	 * @param hdd the hdd to set
	 */
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

    /**
     *
     * @return
     */    
	@Override
	public String toString() {
		String str=super.toString();
		str+="ram=" + ram +", cpu=" + cpu + ", gpu=" + gpu
				+ ", hdd=" + hdd + "\n";
		return str;
	}		
}
