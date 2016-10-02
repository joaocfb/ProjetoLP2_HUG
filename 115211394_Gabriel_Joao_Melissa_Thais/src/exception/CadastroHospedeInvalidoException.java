/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lanca a mensagem no cadastro do hospede no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroHospedeInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando o cadastro do hospede
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CadastroHospedeInvalidoException(String msgErro){
		super("Erro no cadastro de Hospede. " + msgErro);
	}
}
