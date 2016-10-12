package valida;

import java.io.Serializable;

import exception.RemocaoInvalidaException;
/**
 * 
 * @author Melissa
 *
 */
public class verificaRemocao implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que verifica se o email para remocao eh valido
	 * @param email
	 * @throws RemocaoInvalidaException
	 */
	public static void verificaEmailInvalidoRemocao(String email) throws RemocaoInvalidaException {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new RemocaoInvalidaException("Formato de email invalido.");
		}
	}
	
}
