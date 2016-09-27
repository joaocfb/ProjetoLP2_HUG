/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class TiposDeRefeicoes {
	//implements Comparable<TiposDeRefeicoes>
	private String nome;
	private String descricao;
	private double preco;
	
	/**
	 * 
	 */
	public TiposDeRefeicoes(String nome, String descricao) {
		this.nome = nome;
		this.setDescricao(descricao);
	}
	/*
	@Override
	public int compareTo(TiposDeRefeicoes ref) {
		
		if (ref.getNome() > this.nome) {
			return 1;
		} else if (ref.getNome() < this.nome){
			return -1;
		} else {
			return 0;
		}
	}
	*/
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
