package valida;

import exception.CheckinInvalidoException;

public class verificaCheckin {

	public static void verificaQuantDiasInvalidaCheckin(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
	
	public static void verificaIdInvalidaCheckin(String id) throws CheckinInvalidoException {
		if(!(id.matches("[a-zA-Z0-9]+"))) {
			throw new CheckinInvalidoException("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	
	/**
	 * Metodo que verifica se o tipo passado do quarto eh valido
	 * 
	 * @param tipoQuarto
	 * @throws CheckinInvalidoException
	 */
	public static void verificaTipoQuartoValido(String tipoQuarto) throws CheckinInvalidoException {
		if (!(tipoQuarto.equalsIgnoreCase("luxo") || tipoQuarto.equalsIgnoreCase("simples")
				|| tipoQuarto.equalsIgnoreCase("presidencial"))) {
			throw new CheckinInvalidoException("Tipo de quarto invalido.");
		}
	}

	public static void verificaEmailFrmInvalidoCheckin(String email) throws CheckinInvalidoException  {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckinInvalidoException ("Email do(a) hospede esta invalido.");
		}
		
	}
	
	public static void verificaEmailInvalidoCheckin(String email) throws CheckinInvalidoException  {
		if (email.trim().isEmpty()) {
			throw new CheckinInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
	}
}
