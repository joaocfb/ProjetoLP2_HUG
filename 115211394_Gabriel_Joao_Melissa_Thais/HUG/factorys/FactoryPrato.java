/**
 * 
 */
package factorys;

import exception.CadastroPratoInvalidoException;
import restaurante.Prato;
import validaPrato.*;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryPrato {
	
	public Prato criaPrato(String nomePrato, String descricaoPrato, double precoPrato) throws CadastroPratoInvalidoException  {
		
		VerificaPrato.verificaNomePratovazio(nomePrato);
		VerificaPrato.verificaDescVazio(descricaoPrato);
		VerificaPrato.verificaPrecoInvalido(precoPrato);
		
		//verificaNomePratovazio(nomePrato);
		//verificaDescVazio(descricaoPrato);
		//verificaPrecoInvalido(precoPrato);
		
		return new Prato(nomePrato, descricaoPrato, precoPrato);
	}

}
