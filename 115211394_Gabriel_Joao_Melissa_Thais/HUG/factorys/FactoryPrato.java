/**
 * 
 */
package factorys;

import restaurante.Prato;
import restaurante.PratoEntrada;
import restaurante.PratoPetitFour;
import restaurante.PratoPrincipal;
import restaurante.PratoSobremesa;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryPrato {
	
	
	
	public Prato criaPratoEntrada(String nomePrato, double precoPrato, String descricaoPrato){
		return new PratoEntrada(nomePrato, precoPrato, descricaoPrato);
	}
	
	public Prato criaPratoPrincipal(String nomePrato, double precoPrato, String descricaoPrato){
		return new PratoPrincipal(nomePrato, precoPrato, descricaoPrato);
	}
	
	public Prato criaPratoSobremesa(String nomePrato, double precoPrato, String descricaoPrato){
		return new PratoSobremesa(nomePrato, precoPrato, descricaoPrato);
	}
	
	public Prato criaPratoPetitFour(String nomePrato, double precoPrato, String descricaoPrato){
		return new PratoPetitFour(nomePrato, precoPrato, descricaoPrato);
	}
}
