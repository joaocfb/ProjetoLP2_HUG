/**
 * 
 */
package restaurante;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class Refeicao extends TiposDeRefeicoes implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Prato> componentes;
	
	public Refeicao(String nome, String descricao, ArrayList<Prato> componentes) {
		super(nome,descricao);
		
		this.componentes = componentes;

	}
	
	/**
	 * Metodo que faz o calculo do preco de uma refeicao
	 */
	@Override
	public double getPreco(){
		double precoRef = 0.0;
		for (Prato prato : componentes) {
			precoRef += prato.getPreco();
		}
		return precoRef * 0.9;
	}
	


	
	@Override
	public String getDescricao() {
		return super.getDescricao() + " Serao servidos: " + toStringPratos() + ".";
	}
	

	/**
	 * @return the componentes
	 */
	public ArrayList<Prato> getComponentes() {
		return componentes;
	}

	/**
	 * @param componentes the componentes to set
	 */
	public void setComponentes(ArrayList<Prato> componentes) {
		this.componentes = componentes;
	}
	
	/**
	 * 
	 * @return Strind de pratos
	 */
	private String toStringPratos(){
		String toPratos = "";
		for (int i = 0; i < componentes.size(); i++) {
			toPratos += ", ";
			toPratos += "(" + (i + 1) + ") " + componentes.get(i).getNome();
		}
		return toPratos.substring(2);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Nome: " + getNome() + " Preco: R$" + getPrecoFormatado() + "\r\n" + "Descricao: " + 
		getDescricao() + " \r\n" + imprimePratos();
	}
	
	private String imprimePratos(){
	String stringPratos = " ";
	for (Prato prato : this.getComponentes()) {
		stringPratos += prato.getNome() + ", ";
	}
	return "Pratos: " + stringPratos.substring(0, stringPratos.length() - 2) + " \r\n";

	}

	
}
