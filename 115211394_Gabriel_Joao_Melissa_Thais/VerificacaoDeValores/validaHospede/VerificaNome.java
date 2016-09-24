package validaHospede;

import java.util.regex.Pattern;

import exception.CadastroHospedeInvalidoException;

public class VerificaNome {

	public static void verificaNomevazio(String nome) throws CadastroHospedeInvalidoException {
		if (nome.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		if(!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede esta invalido.");
		}

	}
}
