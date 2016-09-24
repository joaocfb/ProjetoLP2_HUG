/**
 * 
 */
package restaurante;

import java.util.ArrayList;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Refeicao extends TiposDeRefeicoes{
	
	private ArrayList<Prato> componentes;
	
	public Refeicao(String nome, String descricao, ArrayList<Prato> componentes) {
		super(nome,descricao);
		
		this.componentes = componentes;

	}
	
	public double getPrecoRefeicao(){
		double precoRef = 0.0;
		for (Prato prato : componentes) {
			precoRef += prato.getPrecoPrato();
		}
		return precoRef * 0.9;
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
		return this.getDescricao() + " Serao servidos: " + toStringPratos() + ".";
	}
	
}
