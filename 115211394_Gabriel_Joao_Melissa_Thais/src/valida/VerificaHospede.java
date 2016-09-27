package valida;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import exception.CadastroHospedeInvalidoException;

public class VerificaHospede {
	
	public static void verificaEmailInvalido(String email) throws CadastroHospedeInvalidoException {
		if (email.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CadastroHospedeInvalidoException("Email do(a) hospede esta invalido.");
		}		
	}


	public static void verificaNomevazio(String nome) throws CadastroHospedeInvalidoException {
		if (nome.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede esta invalido.");
		}

	}
	
	public static void verificaNascimentoVazio(String dataNascimento) throws CadastroHospedeInvalidoException {
		if (dataNascimento.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Data de Nascimento do(a) hospede nao pode ser vazio.");
			
		}
	}
	
	public static void verificaNascInvalido(String dataNascimento) throws CadastroHospedeInvalidoException{
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			verificaFrAnoCadastro(birthDate);
		} catch (Exception e) {
			
			throw new CadastroHospedeInvalidoException("Formato de data invalido.");
		}		
	}
	
	public static void verificaFrAnoCadastro(LocalDate birthDate) throws CadastroHospedeInvalidoException {
		int thisYear = LocalDate.now().getYear();

		if ((birthDate.getYear()) > thisYear) {
			throw new CadastroHospedeInvalidoException("Formato de data invalido.");
		}
	}
	
	public static void verificaIdadeInvalido(String dataNascimento) throws CadastroHospedeInvalidoException{
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			verificaMaiorIdadeCadastro(birthDate);
		} catch (Exception e) {
			
			throw new CadastroHospedeInvalidoException("A idade do(a) hospede deve ser maior que 18 anos.");
		}		
	}
	
	public static void verificaMaiorIdadeCadastro(LocalDate birthDate) throws CadastroHospedeInvalidoException {
		int thisYear = LocalDate.now().getYear();

		if (thisYear - (birthDate.getYear()) < 18) {
			throw new CadastroHospedeInvalidoException("A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}
	
	
	public static LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;

	}
}
