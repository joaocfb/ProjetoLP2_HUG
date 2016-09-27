/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class HospedagemAtivaInvalidaException extends Exception {

	public HospedagemAtivaInvalidaException(String erro){
		super("Erro ao checar hospedagem ativa. Email do(a) hospede " + erro);
	}
}
