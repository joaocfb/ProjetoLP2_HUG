package validaAtualizacao;

import exception.AtualizacaoInvalidaException;

public class verificaEmailAtualizacao {

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
