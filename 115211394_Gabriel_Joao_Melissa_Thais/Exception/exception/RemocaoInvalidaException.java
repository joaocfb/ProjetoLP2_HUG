/**
 * 
 */
package exception;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class RemocaoInvalidaException extends Exception{
	
	public RemocaoInvalidaException(String erro){
		super("Erro na remocao do Hospede. " + erro);
	}

}
