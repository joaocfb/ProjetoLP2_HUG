package validaCadastro;

import java.util.regex.Pattern;

import exception.CadastroHospedeInvalidoException;

public class VerificaNomeCadastro {

	/**
	 * verifica se o nome esta valido no cadastro
	 * @param nome
	 * @throws CadastroHospedeInvalidoException
	 */
	public static void verificaNomeInvalidoCadastro(String nome) throws CadastroHospedeInvalidoException {
		if (nome.trim().isEmpty()) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede nao pode ser vazio.");
		}
		if (!(Pattern.matches("[a-zA-Z ]+", nome))) {
			throw new CadastroHospedeInvalidoException("Nome do(a) hospede esta invalido.");
		}

	}
}
