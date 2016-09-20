/**
 * 
 */
package factorys;

import hotel.Hospede;
import testesValores.TestaValores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		verificaIdadeInvalido(dataNascimento);

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
	
	public static void verificaEmailInvalido(String email) throws Exception {
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
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarAno(birthDate);
		} catch (Exception e) {
			
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
		}
		
	}
	
	private void checarAno(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if ((birthDate.getYear()) > thisYear) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
		}
	}
	
	private void verificaIdadeInvalido(String dataNascimento) throws Exception{
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarIdade(birthDate);
		} catch (Exception e) {
			
			throw new Exception("Erro no cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}
		
	}
	
	private void checarIdade(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if (thisYear - (birthDate.getYear()) < 18) {
			throw new Exception("Erro no cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}
	
	
	private LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;

	}

	
}
