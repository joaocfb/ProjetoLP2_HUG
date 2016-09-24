package validaCadastro;

import java.util.regex.Pattern;

import exception.CadastroInvalidoException;

public class VerificaNomeCadastro {

	/**
	 * verifica se o nome esta valido no cadastro
	 * @param nome
	 * @throws CadastroInvalidoException
	 */
	public static void verificaNomeInvalidoCadastro(String nome) throws CadastroInvalidoException {
		if (nome.trim().isEmpty()) {
			throw new CadastroInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		if (!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new CadastroInvalidoException("Nome do(a) hospede esta invalido.");
		}

	}
}
