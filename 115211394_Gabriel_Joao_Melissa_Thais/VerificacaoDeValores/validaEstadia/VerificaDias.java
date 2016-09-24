package validaEstadia;

import exception.CheckinInvalidoException;

public class VerificaDias {

	public static void verificaQuantDias(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
}
