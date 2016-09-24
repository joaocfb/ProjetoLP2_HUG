/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class ConsultaInvalidaException extends Exception {
	
	public ConsultaInvalidaException(String erro){
		super("Erro na consulta " + erro);
	}
}
