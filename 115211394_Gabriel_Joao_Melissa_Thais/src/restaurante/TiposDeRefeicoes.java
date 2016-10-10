/**
 * 
 */
package restaurante;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class TiposDeRefeicoes implements Comparable<TiposDeRefeicoes> {
	
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

	public String getPrecoFormatado() {
		DecimalFormat df = new DecimalFormat("R$0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(this.getPreco());
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

}
