/**
 * 
 */
package testesValores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import hotel.Hospede;

/**
 * @author Melissa
 *
 */
public class TestaValores {

	public static void testaQuantDias(int quant) throws Exception {
		if (quant <= 0) {
			throw new Exception("Erro ao realizar checkin. Quantidade de dias esta invalida.");
		}
	}
	
	public static void testaIdInvalido(String id) throws Exception{
		if(!(Pattern.matches("[a-zA-Z]+", id))|| id.trim().isEmpty()) {
			throw new Exception("Erro ao realizar checkin. ID do quarto invalido, use apenas numeros ou letras.");
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
		if (!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
		}

	}

	public static void verificaEmailAtualizaInvalido(String email) throws Exception {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
	}

	public static void verificaEmailremoveInvalido(String email) throws Exception {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new Exception("Erro na remocao do Hospede. Formato de email invalido.");
		}
	}

	public static void verificaEmailCheckinInvalido(String email) throws Exception {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new Exception("Erro ao realizar checkin. Email do(a) hospede esta invalido.");
		}
	}


	public static void testaNascVazio(String data) throws Exception {
		if (data.trim().isEmpty()) {
			throw new Exception(
					"Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}

	public static void testaNascInvalido(String dataNascimento) throws Exception {

		if (dataNascimento.length() != 10) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");

		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");

		}
	}

	// TA PODRE
	public static void testaNascCadastroInvalido(String dataNascimento) throws Exception {

		if (dataNascimento.length() != 10) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}
		if (dataNascimento.contains(".")) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");

		}
	}

	public static void testaEmailInvalido(String email) throws Exception {
		if (email.trim().isEmpty()) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");

		}
		if (!email.contains("@") || email.startsWith("@") || !email.contains(".")) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");

		}

	}

	public static void verificaNascInvalido(String dataNascimento) throws Exception {
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarAno(birthDate);
		} catch (Exception e) {

			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");
		}

	}

	private static void checarAno(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if ((birthDate.getYear()) > thisYear) {
			throw new Exception("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");
		}
	}

	public static void verificaIdadeInvalido(String dataNascimento) throws Exception {
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarIdade(birthDate);
		} catch (Exception e) {

			throw new Exception(
					"Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}

	}

	private static void checarIdade(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if (thisYear - (birthDate.getYear()) < 18) {
			throw new Exception(
					"Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}

	private static LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;

	}

}
