package validaHospede;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VerificaData {

	public static void verificaNascimentoVazio(String dataNascimento) throws Exception {
		if (dataNascimento.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
			
		}
	}
	
	public static void verificaNascInvalido(String dataNascimento) throws Exception{
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarAno(birthDate);
		} catch (Exception e) {
			
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
		}		
	}
	
	public static void checarAno(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if ((birthDate.getYear()) > thisYear) {
			throw new Exception("Erro no cadastro de Hospede. Formato de data invalido.");
		}
	}
	
	public static void verificaIdadeInvalido(String dataNascimento) throws Exception{
		LocalDate birthDate;
		try {
			birthDate = stringToDate(dataNascimento);
			checarIdade(birthDate);
		} catch (Exception e) {
			
			throw new Exception("Erro no cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}		
	}
	
	public static void checarIdade(LocalDate birthDate) throws Exception {
		int thisYear = LocalDate.now().getYear();

		if (thisYear - (birthDate.getYear()) < 18) {
			throw new Exception("Erro no cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
		}
	}
	
	
	public static LocalDate stringToDate(String dateCandidate) {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate data = LocalDate.parse(dateCandidate, formatador);

		return data;

	}
}
