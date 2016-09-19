/**
 * 
 */
package restaurante;

import java.util.ArrayList;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Refeicao {
	private String nomeRef;
	private String descricaoRef;
	private ArrayList<Prato> componentes;
	
	public Refeicao(String nomeRef, String descricaoRef, ArrayList<Prato> componentes) throws Exception{
		
		this.nomeRef = nomeRef;
		this.descricaoRef = descricaoRef;
		this.componentes = componentes;

	}
	
	
	
	private String toStringPratos(){
		String toPratos = "";
		for (int i = 0; i < componentes.size(); i++) {
			toPratos += ", ";
			toPratos += "(" + (i + 1) + ") " + componentes.get(i).getNomePrato();
		}
		return toPratos.substring(2);
	}
	
	public double getPrecoRefeicao(){
		double precoRef = 0.0;
		for (Prato prato : componentes) {
			precoRef += prato.getPrecoPrato();
		}
		return precoRef * 0.9;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.descricaoRef + " Serao servidos: " + toStringPratos() + ".";
	}


	/**
	 * @return the nomeRef
	 */
	public String getNomeRef() {
		return nomeRef;
	}

	/**
	 * @param nomeRef the nomeRef to set
	 */
	public void setNomeRef(String nomeRef) {
		this.nomeRef = nomeRef;
	}

	/**
	 * @return the descricaoRef
	 */
	public String getDescricaoRef() {
		return descricaoRef;
	}

	/**
	 * @param descricaoRef the descricaoRef to set
	 */
	public void setDescricaoRef(String descricaoRef) {
		this.descricaoRef = descricaoRef;
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
	
	
}
