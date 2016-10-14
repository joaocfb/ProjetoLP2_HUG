/**
 * 
 */
package restaurante;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Gabriel Alves 
 * @author Joao Carlos 
 * @author Melissa Diniz 
 * @author Thais Nicoly
 */
public class TiposDeRefeicoes implements Comparable<TiposDeRefeicoes>, Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private double preco;
	
	public TiposDeRefeicoes(String nome, String descricao) {
		this.nome = nome;
		this.setDescricao(descricao);
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	/**
	 * Retorna uma string com o preco formatado
	 * @return
	 */
	public String getPrecoFormatado() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(this.getPreco());
	}
	
	/**
	 * Faz a comparacao entre dois pratos pelo preco
	 */
	@Override
	public int compareTo(TiposDeRefeicoes outro) {
		if (this.getPreco() > outro.getPreco()) {
			return 1;
		} else if (this.getPreco() == outro.getPreco()) {
			return 0;
		} else {
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof TiposDeRefeicoes)) {
			return false;
		}
		TiposDeRefeicoes other = (TiposDeRefeicoes) obj;
		
		if (getNome().equalsIgnoreCase(other.getNome())) {
			return true;
		}
		return false;
	}

	}
