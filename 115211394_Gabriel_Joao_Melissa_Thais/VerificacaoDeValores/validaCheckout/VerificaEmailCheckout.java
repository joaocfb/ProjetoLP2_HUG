package validaCheckout;

import exception.CheckoutInvalidoException;
/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaEmailCheckout {

	public static void verificaEmailInvalido(String email) throws CheckoutInvalidoException {
		if (email.trim().isEmpty()) {
			throw new CheckoutInvalidoException("Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckoutInvalidoException("Email do(a) hospede esta invalido.");
		}		
	}
		public static void verificaIdInvalidaCheckout(String id) throws CheckoutInvalidoException {
		if(!(id.matches("[a-zA-Z0-9]+"))) {
			throw new CheckoutInvalidoException("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	
}

