package validaRemocao;

import exception.RemocaoInvalidaException;

public class verificaEmailRemocao {

	public static void verificaEmailInvalidoRemocao(String email) throws RemocaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new RemocaoInvalidaException("Formato de email invalido.");
		}
	}
	
}
