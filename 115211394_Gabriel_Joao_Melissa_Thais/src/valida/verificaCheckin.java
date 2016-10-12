package valida;

import java.io.Serializable;

import exception.CheckinInvalidoException;

public class verificaCheckin implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que verifica se a quantidade de dias da estadia eh valida
	 * @param quant
	 * @throws CheckinInvalidoException
	 */
	public static void verificaQuantDiasInvalidaCheckin(int quant) throws CheckinInvalidoException  {
		if (quant <= 0) {
			throw new CheckinInvalidoException ("Quantidade de dias esta invalida.");
		}
	}
	
	/**
	 * Metodo que verifica se o id do quarto eh valido
	 * @param id
	 * @throws CheckinInvalidoException
	 */
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

	/**
	 * Metodo que verifica se o email do hospede eh valido
	 * @param id
	 * @throws CheckinInvalidoException
	 */
	public static void verificaEmailFrmInvalidoCheckin(String email) throws CheckinInvalidoException  {

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new CheckinInvalidoException ("Email do(a) hospede esta invalido.");
		}
		
	}
	
	/**
	 * Metodo que verifica se o email eh nulo
	 * @param email
	 * @throws CheckinInvalidoException
	 */
	public static void verificaEmailInvalidoCheckin(String email) throws CheckinInvalidoException  {
		if (email.trim().isEmpty()) {
			throw new CheckinInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
	}
}
