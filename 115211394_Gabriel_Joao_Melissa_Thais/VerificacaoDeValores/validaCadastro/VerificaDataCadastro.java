package validaCadastro;

import exception.CadastroHospedeInvalidoException;

public class VerificaDataCadastro {

	/**
	 * verifica se a data eh vazia no cadastro 
	 * @param dataNascimento
	 * @throws CadastroHospedeInvalidoException
	 */
	public static void verificaDataInvalidaCadastro(String dataNascimento) throws CadastroHospedeInvalidoException {
		if (dataNascimento.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}
	
	/**
	 * Verifica se o formato da data esta valida no cadastro
	 * @param dataNascimento
	 * @throws CadastroHospedeInvalidoException
	 */
	public static void verificaFrDataInvalidaCadastro(String dataNascimento) throws CadastroHospedeInvalidoException {
		if (dataNascimento.length() != 10) {
			throw new CadastroHospedeInvalidoException("Formato de data invalido.");
		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new CadastroHospedeInvalidoException("Formato de data invalido.");
		}
		if (dataNascimento.contains(".")) {
			throw new CadastroHospedeInvalidoException("Formato de data invalido.");
		}
	}
	
	
}
