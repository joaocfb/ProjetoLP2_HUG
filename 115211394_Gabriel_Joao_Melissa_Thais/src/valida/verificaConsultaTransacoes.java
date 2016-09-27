/**
 * 
 */
package valida;

import exception.IndiceInvalidoException;

/**
 * @author nicolly
 *
 */
public class verificaConsultaTransacoes {
	
	public static void verificaIndiceInvalido(int indice) throws IndiceInvalidoException{
		if(indice < 0){
			throw new IndiceInvalidoException("");
		}
	}
}

