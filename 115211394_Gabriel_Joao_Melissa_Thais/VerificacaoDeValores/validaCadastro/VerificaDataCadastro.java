package validaCadastro;

import exception.CadastroInvalidoException;

public class VerificaDataCadastro {

	/**
	 * verifica se a data eh vazia no cadastro 
	 * @param dataNascimento
	 * @throws CadastroInvalidoException
	 */
	public static void verificaDataInvalidaCadastro(String dataNascimento) throws CadastroInvalidoException {
		if (dataNascimento.trim().isEmpty()) {
			throw new CadastroInvalidoException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
	}
	
	/**
	 * Verifica se o formato da data esta valida no cadastro
	 * @param dataNascimento
	 * @throws CadastroInvalidoException
	 */
	public static void verificaFrDataInvalidaCadastro(String dataNascimento) throws CadastroInvalidoException {
		if (dataNascimento.length() != 10) {
			throw new CadastroInvalidoException("Formato de data invalido.");
		}
		if (dataNascimento.substring(2).equals("/") && dataNascimento.substring(5).equals("/")) {
			throw new CadastroInvalidoException("Formato de data invalido.");
		}
		if (dataNascimento.contains(".")) {
			throw new CadastroInvalidoException("Formato de data invalido.");
		}
	}
	
	
}
