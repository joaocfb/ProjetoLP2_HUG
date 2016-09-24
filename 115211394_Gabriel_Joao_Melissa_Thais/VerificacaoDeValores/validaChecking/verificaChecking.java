package validaChecking;

import java.util.regex.Pattern;

import exception.CheckinInvalidoException;

public class verificaChecking {

	public static void verificaQuantDiasInvalidaCheckin(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
	
	public static void verificaIdInvalidaCheckin(String id) throws CheckinInvalidoException {
		if(!(Pattern.matches("[a-zA-Z]+", id))|| id.trim().isEmpty()) {
			throw new CheckinInvalidoException ("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	

	public static void verificaEmailInvalidoCheckin(String email) throws CheckinInvalidoException  {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckinInvalidoException ("Email do(a) hospede esta invalido.");
		}
	}
}
