/**
 * 
 */
package factorys;

import restaurante.Prato;
import validaPrato.*;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryPrato {
	
	public Prato criaPrato(String nomePrato, double precoPrato, String descricaoPrato) throws Exception{
		
		VerificaPrato.verificaNomePratovazio(nomePrato);
		VerificaPrato.verificaDescVazio(descricaoPrato);
		VerificaPrato.verificaPrecoInvalido(precoPrato);
		
		//verificaNomePratovazio(nomePrato);
		//verificaDescVazio(descricaoPrato);
		//verificaPrecoInvalido(precoPrato);
		
		return new Prato(nomePrato, precoPrato, descricaoPrato);
	}

}
