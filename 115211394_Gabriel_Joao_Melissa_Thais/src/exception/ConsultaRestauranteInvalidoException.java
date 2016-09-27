/**
 * 
 */
package exception;

/**
 * @author nicolly
 *
 */
@SuppressWarnings("serial")
public class ConsultaRestauranteInvalidoException extends Exception{
	
	public ConsultaRestauranteInvalidoException(String erro){
		super("Erro na consulta do restaurante." + erro);
	}
}
