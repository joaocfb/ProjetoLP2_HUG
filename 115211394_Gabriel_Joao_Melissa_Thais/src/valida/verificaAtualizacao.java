package valida;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exception.AtualizacaoInvalidaException;
import exception.CadastroHospedeInvalidoException;

public class verificaAtualizacao {

	/**
	 * verifica se a data esta vazia 
	 * @param dataNascimento
	 * @throws AtualizacaoInvalidaException
	 */
	public static void verificaDataInvalidaAtualizacao(String data) throws AtualizacaoInvalidaException {
		if (data.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}
	
	/**
	 * Verifica se o formato da data eh valida
	 * @param dataNascimento
	 * @throws CadastroHospedeInvalidoException
	 */
	public static void verificaFrDataInvalidaAtualizacao(String dataNascimento) throws AtualizacaoInvalidaException {
		if (dataNascimento.length() != 10) {
			throw new AtualizacaoInvalidaException("Formato de data invalido.");
		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new AtualizacaoInvalidaException("Formato de data invalido.");
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
	
	// Local Date
	private static LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;
		
	}
	

	public static void verificaEmailInvalidoAtualizacao(String email) throws AtualizacaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new AtualizacaoInvalidaException("Email do(a) hospede esta invalido.");
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

}
