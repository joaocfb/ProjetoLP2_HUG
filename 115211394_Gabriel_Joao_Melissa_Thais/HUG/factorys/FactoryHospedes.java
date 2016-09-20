/**
 * 
 */
package factorys;

import hotel.Hospede;
import testesValores.TestaValores;

import java.util.regex.Pattern;


/**
 * Fabrica de hospede
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryHospedes {
	private TestaValores testa;
	
	
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
		//colocar aqui os metodos da classe testa valores
		
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
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
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
