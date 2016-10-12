package valida;

import java.io.Serializable;

import exception.CheckoutInvalidoException;
/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaCheckout implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Metodo que verifica se o email para checkout eh valido
	 * @param email
	 * @throws CheckoutInvalidoException
	 */
	public static void verificaEmailInvalido(String email) throws CheckoutInvalidoException {
		if (email.trim().isEmpty()) {
			throw new CheckoutInvalidoException("Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckoutInvalidoException("Email do(a) hospede esta invalido.");
		}		
	}
	
	/**
	 * Metodo que verifica se o id do quarto checkout eh valido
	 * @param id
	 * @throws CheckoutInvalidoException
	 */
	public static void verificaIdInvalidaCheckout(String id) throws CheckoutInvalidoException {
		if(!(id.matches("[a-zA-Z0-9]+"))) {
			throw new CheckoutInvalidoException("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	
}

