package validaHospede;

import exception.CadastroHospedeInvalidoException;

public class VerificaEmail {

	public static void verificaEmailInvalido(String email) throws CadastroHospedeInvalidoException {
		if (email.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CadastroHospedeInvalidoException("Email do(a) hospede esta invalido.");
		}		
	}
}
