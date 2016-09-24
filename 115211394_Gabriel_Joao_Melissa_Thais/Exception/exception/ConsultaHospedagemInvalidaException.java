/**
 * 
 */
package exception;

/**
 * @author nicolly
 *
 */
@SuppressWarnings("serial")
public class ConsultaHospedagemInvalidaException extends Exception{
	
	public ConsultaHospedagemInvalidaException(String erro){
		super("Erro na consulta de hospedagem. " + erro + " nao esta hospedado(a).");
	}
}
