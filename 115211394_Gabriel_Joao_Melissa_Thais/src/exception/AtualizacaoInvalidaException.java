/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na atualizacao do cadastro
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class AtualizacaoInvalidaException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a atualizacao do cadastro do hospede
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public AtualizacaoInvalidaException(String msgErro){
		super("Erro na atualizacao do cadastro de Hospede. " + msgErro);
	}
}
