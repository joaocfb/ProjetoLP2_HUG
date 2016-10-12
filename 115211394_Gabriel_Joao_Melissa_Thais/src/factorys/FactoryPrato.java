/**
 * 
 */
package factorys;

import java.io.Serializable;

import exception.CadastroPratoInvalidoException;
import restaurante.Prato;
import valida.VerificaPrato;

/**
 * Fabrica de Pratos
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 */
public class FactoryPrato implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Cria um novo Prato
	 * @param Nome do Prato
	 * @param Descricao do Prato
	 * @param Preco do Prato
	 * @return O prato
	 * @throws CadastroPratoInvalidoException
	 */
	public Prato criaPrato(String nomePrato, String descricaoPrato, double precoPrato) throws CadastroPratoInvalidoException  {
		
		VerificaPrato.verificaNomePratovazio(nomePrato);
		VerificaPrato.verificaDescVazio(descricaoPrato);
		VerificaPrato.verificaPrecoInvalido(precoPrato);
		
		return new Prato(nomePrato, descricaoPrato, precoPrato);
	}

}
