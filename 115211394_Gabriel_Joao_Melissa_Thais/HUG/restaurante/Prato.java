/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Prato extends TiposDeRefeicoes{
	
	private double precoPrato;
	
	public Prato(String nome, String descricao, double precoPrato) {
		super(nome, descricao);
		
		this.setPrecoPrato(precoPrato);
		
	}
	

	/**
	 * @return the preco
	 */
	public double getPrecoPrato() {
		return precoPrato;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPrecoPrato(double precoPrato) {
		this.precoPrato = precoPrato;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prato [nomePrato=" + this.getNome() + ", precoPrato=" + this.getPrecoPrato() + ", descricaoPrato=" + this.getDescricao()
				+ "]";
	}
	
	
}
