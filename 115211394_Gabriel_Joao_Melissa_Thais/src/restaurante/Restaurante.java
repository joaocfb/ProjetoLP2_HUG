
package restaurante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import factorys.FactoryPrato;
import factorys.FactoryRefeicao;

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
	private ArrayList<TiposDeRefeicoes> pedidos;


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

		refeicao.add(factoryPrato.criaPrato(nomePrato, descricaoPrato, precoPrato));
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

		refeicao.add(factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRefeicao(componentes)));
	}

	/**
	 * Metodo que retorna uma lista com os objs prato
	 * 
	 * @param componentes
	 * @return ArrayList
	 * @throws CadastroRefeicaoInvalidaException
	 */
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {

		if (componentes.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Componente(s) esta(o) vazio(s).");
		}

		int pratosCadastrados = 0;

		ArrayList<Prato> pratosRef = new ArrayList<>();
		String[] nomesComponentes = componentes.split(";");

		for (String nomePrato : nomesComponentes) {
			
			if (getNomeRefeicao(nomePrato) instanceof Prato) {
				Prato novoPrato = (Prato) getNomeRefeicao(nomePrato);

				pratosRef.add(novoPrato);

				if (ExistePratoRefeicao(nomePrato)) {
					pratosCadastrados++;
				}
			}
		}

		if (!(pratosCadastrados == pratosRef.size())) {
			throw new CadastroRefeicaoInvalidaException(
					". So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}

		if (pratosRef.size() > 4 || pratosRef.size() < 3) {
			throw new CadastroRefeicaoInvalidaException(
					" completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}

		return pratosRef;
	}

	/**
	 * Metodo privado que busca um prato dando o retorno do tipo boolean
	 * @param nomePrato a ser buscado
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

	/**
	 * Metodo privado que retorna um Tipo De Refeiçao a partir de uma busca feita pelo nome do Prato
	 * @param nomePrato
	 * @return
	 */
	private TiposDeRefeicoes getNomeRefeicao(String nomePrato) {
		for (TiposDeRefeicoes tiposDeRefeicoes : refeicao) {
			if (tiposDeRefeicoes.getNome().equalsIgnoreCase(nomePrato)) {
				return tiposDeRefeicoes;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param tipoOrdenacao
	 */
	
	public void ordenaMenu(String tipoOrdenacao) {

		switch (tipoOrdenacao.toLowerCase()) {
		case "nome":
			ordenaCardapioPorNome();
		case "preco":
			ordenaCardapioPorPreco();
		default:
			break;
		}

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
				retorno += String.format("R$%.2f", (getNomeRefeicao(chaveNome).getPreco()));
				return retorno;

			case "descricao":

				return getNomeRefeicao(chaveNome).getDescricao();

			}

		}
		if (ExistePratoRefeicao((chaveNome))) {

			switch (atributo.toLowerCase()) {

			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", getNomeRefeicao(chaveNome).getPreco());
				return retorno;

			case "descricao":

				return getNomeRefeicao(chaveNome).toString();

			}

		}

		throw new ConsultaRestauranteInvalidoException(" Nome do prato esto vazio.");
	}

	public double precoPedido(String nomePedido) {
		return getNomeRefeicao(nomePedido).getPreco();
	}

	public void adicionaPedido(String email, String itemMenu) {
		
		
		
		// Pedidos pedido = factoryPedidos.criaPedido(nomePedido,
		// precoPedido(nomePedido));

	}

	/**
	 * @return the refeicao
	 */
	public ArrayList<TiposDeRefeicoes> getRefeicao() {
		return refeicao;
	}

	public void ordenaCardapioPorNome() {
		
		List<TiposDeRefeicoes> listaRefeicoesPorNome = new LinkedList<>(refeicao);
		this.refeicao = (ArrayList<TiposDeRefeicoes>) listaRefeicoesPorNome;
		
	}

	public void ordenaCardapioPorPreco() {
		Collections.sort(refeicao);
	}

}
