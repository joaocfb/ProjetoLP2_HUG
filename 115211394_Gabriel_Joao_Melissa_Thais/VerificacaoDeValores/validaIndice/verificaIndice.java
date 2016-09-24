/**
 * 
 */
package validaIndice;

import exception.IndiceInvalidoException;

/**
 * @author nicolly
 *
 */
public class verificaIndice {
	
	public static void verificaIndiceInvalido(int indice) throws IndiceInvalidoException{
		if(indice < 0){
			throw new IndiceInvalidoException("");
		}
	}
}
