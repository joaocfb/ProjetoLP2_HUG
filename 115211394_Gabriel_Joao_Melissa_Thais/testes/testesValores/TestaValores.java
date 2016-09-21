/**
 * 
 */
package testesValores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import exception.AtualizacaoInvalidaException;
import exception.CadastroInvalidoException;
import exception.CheckinInvalidoException;
import exception.RemocaoInvalidaException;
import hotel.Hospede;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class TestaValores {
	
	
	// mensagem de erro para cadastro
	
	/**
	 * verifica se a data eh vazia no cadastro 
	 * @param dataNascimento
	 * @throws CadastroInvalidoException
	 */
	public static void verificaDataInvalidaCadastro(String dataNascimento) throws CadastroInvalidoException {
		if (dataNascimento.trim().isEmpty()) {
			throw new CadastroInvalidoException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

	}
	
	/**
	 * verifica se o nome esta valido no cadastro
	 * @param nome
	 * @throws CadastroInvalidoException
	 */
	public static void verificaNomeInvalidoCadastro(String nome) throws CadastroInvalidoException {
		if (nome.trim().isEmpty()) {
			throw new CadastroInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		if (!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new CadastroInvalidoException("Nome do(a) hospede esta invalido.");
		}

	}
	
	/**
	 * Verifica se o formato da data esta valida no cadastro
	 * @param dataNascimento
	 * @throws CadastroInvalidoException
	 */
	public static void verificaFrDataInvalidaCadastro(String dataNascimento) throws CadastroInvalidoException {

		if (dataNascimento.length() != 10) {
			throw new CadastroInvalidoException("Formato de data invalido.");

		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new CadastroInvalidoException("Formato de data invalido.");

		}
		if (dataNascimento.contains(".")) {
			throw new CadastroInvalidoException("Formato de data invalido.");

		}
	}
	
	// mensagem de erro para atualizacao
	
	
	public static void verificaEmailInvalidoAtualizacao(String email) throws AtualizacaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new AtualizacaoInvalidaException("Email do(a) hospede esta invalido.");
		}
	}
	
	public static void verificaDataInvalidaAtualizacao(String data) throws AtualizacaoInvalidaException {
		if (data.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}

	public static void verificaFrDataInvalidaAtualizacao(String dataNascimento) throws AtualizacaoInvalidaException {

		if (dataNascimento.length() != 10) {
			throw new AtualizacaoInvalidaException("Formato de data invalido.");

		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new AtualizacaoInvalidaException("Formato de data invalido.");

		}
	}

	public static void verificaFrEmailInvalidoAtualizacao(String email) throws AtualizacaoInvalidaException{
		if (email.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("Email do(a) hospede esta invalido.");

		}
		if (!email.contains("@") || email.startsWith("@") || !email.contains(".")) {
			throw new AtualizacaoInvalidaException("Email do(a) hospede esta invalido.");

		}

	}

	public static void verificaDataNascInvalidoAtualizacao(String dataNascimento) throws AtualizacaoInvalidaException {
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			verificaAnoAtualizacao(birthDate);
		} catch (Exception e) {

			throw new AtualizacaoInvalidaException("Formato de data invalido.");
		}

	}

	private static void verificaAnoAtualizacao(LocalDate birthDate) throws AtualizacaoInvalidaException {
		int thisYear = LocalDate.now().getYear();

		if ((birthDate.getYear()) > thisYear) {
			throw new AtualizacaoInvalidaException("Formato de data invalido.");
		}
	}
	
	public static void verificaIdadeInvalidaAtualizacao(String dataNascimento) throws AtualizacaoInvalidaException {
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			verificaIdadeMaiorInvalidaAtualizacao(birthDate);
		} catch (Exception e) {

			throw new AtualizacaoInvalidaException("A idade do(a) hospede deve ser maior que 18 anos.");
		}

	}

	private static void verificaIdadeMaiorInvalidaAtualizacao(LocalDate birthDate) throws AtualizacaoInvalidaException {
		int thisYear = LocalDate.now().getYear();

		if (thisYear - (birthDate.getYear()) < 18) {
			throw new AtualizacaoInvalidaException("A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}
	
	// mensagem de erro para remocao
	
	public static void verificaEmailInvalidoRemocao(String email) throws RemocaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new RemocaoInvalidaException("Formato de email invalido.");
		}
	}
	
	// mensagem de erro para checkin
	
	public static void verificaQuantDiasInvalidaCheckin(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
	
	public static void verificaIdInvalidaCheckin(String id) throws CheckinInvalidoException {
		if(!(Pattern.matches("[a-zA-Z]+", id))|| id.trim().isEmpty()) {
			throw new CheckinInvalidoException ("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	

	public static void verificaEmailInvalidoCheckin(String email) throws CheckinInvalidoException  {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckinInvalidoException ("Email do(a) hospede esta invalido.");
		}
	}
	
	// Local Date
	private static LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;

	}

}
