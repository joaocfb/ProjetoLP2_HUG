
package restaurante;

import java.util.ArrayList;
import java.util.Collections;

import exception.CadastroHospedeInvalidoException;
import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import exception.ErroOrdenacaoException;
import factorys.FactoryPrato;
import factorys.FactoryRefeicao;
import valida.VerificaCadastro;

/**
 * Classe Restaurante
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Restaurante {

	private FactoryPrato factoryPrato;
	private FactoryRefeicao factoryRefeicao;
	private ArrayList<TiposDeRefeicoes> refeicao;
	private ArrayList<Pedidos> pedidos;

	public Restaurante() {
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
		this.refeicao = new ArrayList<>();
		this.pedidos = new ArrayList<>();

	}

	/**
	 * Metodo que cadastra um prato
	 * 
	 * @param nomePrato
	 * @param precoPrato
	 * @param descricaoPrato
	 * @throws CadastroPratoInvalidoException
	 * @throws Exception
	 */
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)
			throws CadastroPratoInvalidoException {

		VerificaCadastro.verificaNomePratoInvalido(nomePrato);
		VerificaCadastro.verificaPrecoInvalido(precoPrato);
		VerificaCadastro.verificaDescricaoPratoInvalido(descricaoPrato);

		if (!ExistePratoRefeicao(nomePrato)) {
			refeicao.add(factoryPrato.criaPrato(nomePrato, descricaoPrato, precoPrato));

		}
	}

	/**
	 * Metodo que cadastra uma refeicao
	 * 
	 * @param nomeRef
	 * @param descricaoRef
	 * @param componentes
	 * @throws CadastroRefeicaoInvalidaException
	 * @throws Exception
	 */
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes)
			throws CadastroRefeicaoInvalidaException {

		VerificaCadastro.verificaNomeRefeicaoInvalida(nomeRef);
		VerificaCadastro.verificaDescricaoRefeicaoInvalida(descricaoRef);
		VerificaCadastro.verificaComponentesVazio(componentes);

		ArrayList<Prato> pratosRef = pratosRefeicao(componentes);

		if (!ExistePratoRefeicao(nomeRef)) {
			refeicao.add(factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRef));

		}
	}

	/**
	 * Metodo que retorna uma lista com os objs prato
	 * 
	 * @param componentes
	 * @return ArrayList
	 * @throws CadastroRefeicaoInvalidaException
	 */
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {

		int pratosCadastrados = 0;

		ArrayList<Prato> pratosRef = new ArrayList<>();
		String[] nomesComponentes = componentes.split(";");

		for (String nomePrato : nomesComponentes) {

			if (getRefeicaoNome(nomePrato) instanceof Prato) {

				Prato novoPrato = (Prato) getRefeicaoNome(nomePrato);
				pratosRef.add(novoPrato);

				if (ExistePratoRefeicao(nomePrato)) {
					pratosCadastrados++;
				}
			}
		}

		if ((pratosCadastrados != pratosRef.size())) {
			throw new CadastroRefeicaoInvalidaException(
					". So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}

		if (pratosRef.size() < 3 || pratosRef.size() > 4) {
			throw new CadastroRefeicaoInvalidaException(
					" completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}

		return pratosRef;
	}

	/**
	 * Metodo que imprime todos os pratos do cardapio
	 * 
	 * @return String
	 */
	public String consultaMenuRestaurante() {
		String retorno = "";

		for (TiposDeRefeicoes nomeRef : refeicao) {
			retorno += nomeRef.getNome() + ";";
		}

		if (retorno.length() > 0) {
			retorno = retorno.substring(0, retorno.length() - 1);
		}

		return retorno;
	}

	/**
	 * Metodo
	 * 
	 * @param chaveNome
	 * @param atributo
	 * @return
	 * @throws ConsultaRestauranteInvalidoException
	 * @throws Exception
	 */
	public String consultaRestaurante(String chaveNome, String atributo)
			throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException {

		if (ExistePratoRefeicao(chaveNome)) {

			switch (atributo.toLowerCase()) {

			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", (getRefeicaoNome(chaveNome).getPreco()));
				return retorno;

			case "descricao":

				return getRefeicaoNome(chaveNome).getDescricao();

			}

		}
		if (ExistePratoRefeicao((chaveNome))) {

			switch (atributo.toLowerCase()) {

			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", getRefeicaoNome(chaveNome).getPreco());
				return retorno;

			case "descricao":

				return getRefeicaoNome(chaveNome).toString();

			}

		}

		throw new ConsultaRestauranteInvalidoException(" Nome do prato esta vazio.");
	}

	public double precoPedido(String nomePedido) {
		double preco = 0;
		for (TiposDeRefeicoes pedido : refeicao) {
			if (pedido.getNome().equalsIgnoreCase(nomePedido)) {
				preco = pedido.getPreco();
			}
		}

		return preco;
	}

	/**
	 * @return the refeicao
	 */
	public ArrayList<TiposDeRefeicoes> getRefeicao() {
		return refeicao;
	}

	/**
	 * @return the pedidos
	 */
	public ArrayList<Pedidos> getPedidos() {
		return pedidos;
	}

	// ########### metodos da ordenacao ###########

	/**
	 * Ordena as refeicoes de acordo a qual deseja no atributo
	 * 
	 * @param tipo
	 *            de ordenacao que deseja (ordem alfabetica ou preco)
	 * @return a string formatada com a lista de ordenada
	 */
	public String ordenaMenu(String tipo) throws ErroOrdenacaoException {

		switch (tipo.toLowerCase()) {

		case "nome":
			ordenaMenuPorNome();
			return imprimeStringOrdem();

		case "preco":
			ordenaMenuPorPreco();
			System.out.println(imprimeStringOrdem());
			return imprimeStringOrdem();

		}
		throw new ErroOrdenacaoException("");
	}

	/**
	 * ordena os pratos pelo nome
	 */
	public void ordenaMenuPorNome() {
		Collections.sort(refeicao, new OrdenaPorNome());

	}

	/**
	 * ordena os pratos pelo preco
	 */
	public void ordenaMenuPorPreco() {
		Collections.sort(refeicao, new OrdenaPorPreco());
	}

	// ########### metodos da ordenacao ###########

	// ########## metodos privados ##########

	/**
	 * Metodo que imprime a lista na formatacao adequada
	 * 
	 * @return a lista com as refeicoes ordenada
	 */
	private String imprimeStringOrdem() {
		String retorno = "";
		for (TiposDeRefeicoes element : refeicao) {
			retorno += element.getNome() + ";";

		}
		if (retorno.length() > 0) {
			retorno = retorno.substring(0, retorno.length() - 1);
		}

		return retorno;
	}

	/**
	 * Metodo privado que busca um prato dando o retorno do tipo boolean
	 * 
	 * @param nomePrato
	 *            a ser buscado
	 * @return true or false
	 */

	private boolean ExistePratoRefeicao(String nomePrato) {
		for (TiposDeRefeicoes tiposDeRefeicoes : refeicao) {
			if (tiposDeRefeicoes.getNome().equalsIgnoreCase(nomePrato)) {
					return true;
			}
		}
		return false;
	}

	private boolean ExistePratoRefeicaoCompleta(ArrayList<Prato> pratosRef) {
		for (TiposDeRefeicoes tiposDeRefeicoes : refeicao) {
			for (Prato prato : pratosRef) {
				if (tiposDeRefeicoes.getNome().equalsIgnoreCase(prato.getNome())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Metodo privado que retorna um Tipo De Refeiçao a partir de uma busca
	 * feita pelo nome do Prato
	 * 
	 * @param nomePrato
	 * @return
	 */
	private TiposDeRefeicoes getRefeicaoNome(String nomePrato) {
		for (TiposDeRefeicoes tiposDeRefeicoes : refeicao) {
			if (tiposDeRefeicoes.getNome().equalsIgnoreCase(nomePrato)) {
				return tiposDeRefeicoes;
			}
		}
		return null;
	}

	/**
	 * metodo privado que verifica se existe pratos cadastrados na lista de
	 * refeicoes
	 * 
	 * @param nome
	 *            dos pratos a serem verificados
	 * @throws CadastroRefeicaoInvalidaException
	 */
	private void verificaExistePratoCadastrado(ArrayList<Prato> pratosRef) throws CadastroRefeicaoInvalidaException {
		if (!ExistePratoRefeicaoCompleta(pratosRef)) {
			throw new CadastroRefeicaoInvalidaException(
					". So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
	}

	/**
	 * metodo privado que verifica se a quantidade de pratos na refeicao eh
	 * valida
	 * 
	 * @param componentes
	 *            da lista de refeicoes
	 * @throws CadastroRefeicaoInvalidaException
	 */
	private void verificaQuantidadePratos(ArrayList<Prato> pratosRef) throws CadastroRefeicaoInvalidaException {
		System.out.println(pratosRef.size());
		if (pratosRef.size() >= 3 || pratosRef.size() <= 4) {
			throw new CadastroRefeicaoInvalidaException(
					" completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
	}

}