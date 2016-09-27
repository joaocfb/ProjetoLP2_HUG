package valida;

import exception.RemocaoInvalidaException;

public class verificaRemocao {

	public static void verificaEmailInvalidoRemocao(String email) throws RemocaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new RemocaoInvalidaException("Formato de email invalido.");
		}
	}
	
}
