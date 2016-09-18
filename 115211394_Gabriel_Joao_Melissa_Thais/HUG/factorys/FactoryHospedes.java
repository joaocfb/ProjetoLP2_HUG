/**
 * 
 */
package factorys;

import hotel.Hospede;

import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

import exception.StringInvalidaException;

/**
 * Fabrica de hospede
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryHospedes {

	/**
	 * Cria um hospede
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @return
	 * @throws Exception
	 * @throws TestesHospedeException
	 */
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws Exception {
		verificaNomevazio(nome);
		verificaNomeValido(nome);
		
		return new Hospede(nome, email, dataNascimento);
	}

	private void verificaNomevazio(String nome) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}

	}

	private void verificaNomeValido(String nome) throws Exception {
		ArrayList<String> valoresInvalidos = new ArrayList();

		valoresInvalidos.add("@");
		valoresInvalidos.add("!");
		valoresInvalidos.add("#");
		valoresInvalidos.add(".");
		
		for (String string : valoresInvalidos) {
			if (nome.contains(string)) {
				throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
			}
		}
	}
}
