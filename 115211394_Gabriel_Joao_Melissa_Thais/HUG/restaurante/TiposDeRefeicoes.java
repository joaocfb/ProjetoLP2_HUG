/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class TiposDeRefeicoes {
	
	private String nome;
	private String descricao;
	/**
	 * 
	 */
	public TiposDeRefeicoes(String nome, String descricao) {
		this.nome = nome;
		this.setDescricao(descricao);
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
