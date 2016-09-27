/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Prato extends TiposDeRefeicoes{
	
	private double preco;
	
	public Prato(String nome, String descricao, double preco) {
		super(nome, descricao);
		this.setPreco(preco);
		
	}
	

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prato [nomePrato=" + this.getNome() + ", precoPrato=" + this.getPreco() + ", descricaoPrato=" + this.getDescricao()
				+ "]";
	}
	
	
}
