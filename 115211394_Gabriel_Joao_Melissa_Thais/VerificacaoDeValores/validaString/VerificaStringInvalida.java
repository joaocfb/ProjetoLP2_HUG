/**
 * 
 */
package validaString;

import exception.CheckinInvalidoException;
import exception.StringInvalidaException;

/**
 * @author Melissa
 *
 */
public class VerificaStringInvalida {

	
	public void verificaEmailInvalido(String str)throws StringInvalidaException{

		if (str.trim().isEmpty()) {
			throw new StringInvalidaException("Email do(a) hospede nao pode ser vazio.");
		}
	}
}
