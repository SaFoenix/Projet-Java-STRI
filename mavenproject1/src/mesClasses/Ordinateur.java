/**
 * 
 */
package mesClasses;

/**
 * 
 * @author STRI_JAVA
 *
 */
public class Ordinateur extends Equipement {
	private String ram;
	private String cpu;
	private String gpu;
	private String hdd;

	/**
	 * @param mac
	 * @param nom
	 * @param connectique
	 * @param marque
	 * @param power
	 * @param os
	 * @param ram
	 * @param cpu
	 * @param gpu
	 * @param hdd
	 */
	public Ordinateur(String mac, String nom,
			String marque, boolean power,Os os, String ram, String cpu, String gpu,
			String hdd) {
		super(mac, nom, marque, power,os);
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
	@Override
	public String toString() {
		String str=super.toString();
		str+="ram=" + ram +", cpu=" + cpu + ", gpu=" + gpu
				+ ", hdd=" + hdd + "\n";
		return str;
	}
		
}
