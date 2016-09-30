package valida;

import java.util.regex.Pattern;

import exception.CadastroHospedeInvalidoException;
import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;

public class VerificaCadastro {
	
	
	// ########################## Cadastro do Hospede ##########################
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
	
	// ########################## Cadastro do Prato ##########################
	
	public static void verificaNomePratoInvalido(String nome) throws CadastroPratoInvalidoException{
		if (nome.trim().isEmpty()) {
			throw new CadastroPratoInvalidoException("Nome do prato esta vazio.");
		}
	}
	
	public static void verificaPrecoInvalido(double preco) throws CadastroPratoInvalidoException{
		if(preco <= 0.0){
			throw new CadastroPratoInvalidoException("Preco do prato eh invalido.");
		}
	}
	
	public static void verificaDescricaoPratoInvalido(String descricao) throws CadastroPratoInvalidoException{
		if (descricao.trim().isEmpty()) {
			throw new CadastroPratoInvalidoException("Descricao do prato esta vazia.");
		}
	}
	
	// ########################## Cadastro de Refeicao ##########################
	
	public static void verificaNomeRefeicaoInvalida(String nome) throws CadastroRefeicaoInvalidaException{
		if (nome.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Nome da refeicao esta vazio.");
		}
	}
	
	public static void verificaDescricaoRefeicaoInvalida(String descricao) throws CadastroRefeicaoInvalidaException{
		if (descricao.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Descricao da refeicao esta vazia.");
		}
	}
	
	public static void verificaComponentesVazio(String componentes) throws CadastroRefeicaoInvalidaException{
		if (componentes.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Componente(s) esta(o) vazio(s).");
		}
	}
	
	
	
}
