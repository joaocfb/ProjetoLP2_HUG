/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Prato {
	private String nomePrato;
	private double precoPrato;
	private String descricaoPrato;
	
	
	public Prato(String nomePrato, double precoPrato, String descricaoPrato) {
		this.nomePrato = nomePrato;
		this.precoPrato = precoPrato;
		this.descricaoPrato = descricaoPrato;
	}


	/**
	 * @return the nomePrato
	 */
	public String getNomePrato() {
		return nomePrato;
	}


	/**
	 * @param nomePrato the nomePrato to set
	 */
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}


	/**
	 * @return the precoPrato
	 */
	public double getPrecoPrato() {
		return precoPrato;
	}


	/**
	 * @param precoPrato the precoPrato to set
	 */
	public void setPrecoPrato(double precoPrato) {
		this.precoPrato = precoPrato;
	}


	/**
	 * @return the descricaoPrato
	 */
	public String getDescricaoPrato() {
		return descricaoPrato;
	}


	/**
	 * @param descricaoPrato the descricaoPrato to set
	 */
	public void setDescricaoPrato(String descricaoPrato) {
		this.descricaoPrato = descricaoPrato;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prato [nomePrato=" + nomePrato + ", precoPrato=" + precoPrato + ", descricaoPrato=" + descricaoPrato
				+ "]";
	}
	
	
	
	
}
