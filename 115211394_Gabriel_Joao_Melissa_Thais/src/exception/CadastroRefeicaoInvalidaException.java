/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem no cadastro da refeicao no restaurante
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroRefeicaoInvalidaException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando o cadastro da refeicao
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CadastroRefeicaoInvalidaException(String msgErro){
		super("Erro no cadastro de refeicao" + msgErro);
	}
}
