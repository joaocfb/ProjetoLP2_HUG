/**
 * 
 */
package testesValores;

import java.util.regex.Pattern;


/**
 * @author Melissa
 *
 */
public class TestaValores {
	
	
	public static void testaQuantDias(int quant)throws Exception{
		if (quant <= 0) {
			throw new Exception("Nao pode.");
		}
	}
	

	public static void verificaNascimentoVazio(String dataNascimento) throws Exception {
		if (dataNascimento.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

	}
	
	public static void verificaNomeCadastroInvalido(String nome) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
		}

	}
	
	public static void testaAtualizaNomeInvalido(String nome) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede esta invalido.");
		}

	}
	
	public static void testaNascVazio(String data) throws Exception {
		if (data.trim().isEmpty()) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}
	
	public static void testaNascInvalido(String dataNascimento) throws Exception{
		
		if (dataNascimento.length() != 10) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");
			
		}if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");

		}
	}
	
	//TA PODRE
	public static void testaNascCadastroInvalido(String dataNascimento) throws Exception{
		
		if (dataNascimento.length() != 10) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
			
		}if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}if (dataNascimento.contains(".")) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}
	}
	
	public static void testaEmailInvalido(String email) throws Exception {
		if (email.trim().isEmpty()) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");
			
		}if (!email.contains("@") || email.startsWith("@") || !email.contains(".")) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");

		}

	}

	
}
