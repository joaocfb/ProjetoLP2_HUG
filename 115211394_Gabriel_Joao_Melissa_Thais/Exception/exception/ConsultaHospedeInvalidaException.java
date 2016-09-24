/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class ConsultaHospedeInvalidaException extends Exception {

	public ConsultaHospedeInvalidaException(String erro){
		super("Erro na consulta de hospede. Hospede de email " + erro + " nao foi cadastrado(a).");
	}
}
