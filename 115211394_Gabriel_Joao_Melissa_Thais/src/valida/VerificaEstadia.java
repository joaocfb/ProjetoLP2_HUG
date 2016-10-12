package valida;

import java.io.Serializable;

import exception.CheckinInvalidoException;

/**
 * 
 * @author Melissa
 *
 */
public class VerificaEstadia implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void verificaQuantDias(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
}
