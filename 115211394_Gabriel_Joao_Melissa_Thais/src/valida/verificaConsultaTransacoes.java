/**
 * 
 */
package valida;

import java.io.Serializable;

import exception.IndiceInvalidoException;

/**
 * @author nicolly
 *
 */
public class verificaConsultaTransacoes implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que verifica se o indice eh valido
	 * @param indice
	 * @throws IndiceInvalidoException
	 */
	public static void verificaIndiceInvalido(int indice) throws IndiceInvalidoException{
		if(indice < 0){
			throw new IndiceInvalidoException("");
		}
	}
}

