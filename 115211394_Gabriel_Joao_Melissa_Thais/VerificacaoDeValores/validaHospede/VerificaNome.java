package validaHospede;

import java.util.regex.Pattern;

public class VerificaNome {

	public static void verificaNomevazio(String nome) throws Exception {
		if (nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new Exception("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
		}

	}
}
