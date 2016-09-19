/**
 * 
 */
package factorys;

import hotel.Hospede;

import java.util.regex.Pattern;


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
		verificaEmailInvalido(email);
		verificaNascimentoVazio(dataNascimento);
		verificaNascInvalido(dataNascimento);
		
		return new Hospede(nome, email, dataNascimento);
	}

	private void verificaNomevazio(String nome) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
		}

	}
	
	private void verificaEmailInvalido(String email) throws Exception {
		if (email.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
			
		}if (!email.contains("@") || email.startsWith("@") || !email.contains(".")) {
			throw new Exception("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");

		}

	}
	
	private void verificaNascimentoVazio(String dataNascimento) throws Exception {
		if (dataNascimento.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
			
		}

	}
	
	private void verificaNascInvalido(String dataNascimento) throws Exception{
		
		if (dataNascimento.length() != 10) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
			
		}if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}
	}
	

	
}
