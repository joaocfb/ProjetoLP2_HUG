
package restaurante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaHospedeInvalidaException;
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

	private LinkedHashMap<String, TiposDeRefeicoes> refeicao;
	private LinkedHashMap<String, TiposDeRefeicoes> pedidos;


	public Restaurante() {
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
		this.refeicao = new LinkedHashMap<>();
		this.pedidos = new LinkedHashMap<>();


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

		refeicao.put(nomePrato, factoryPrato.criaPrato(nomePrato, descricaoPrato, precoPrato));
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

		refeicao.put(nomeRef, factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRefeicao(componentes)));
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

			if (refeicao.get(nomePrato) instanceof Prato) {
				Prato prato1 = (Prato) refeicao.get(nomePrato);

				pratosRef.add(prato1);

				if (refeicao.containsKey(nomePrato)) {
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

	public void ordenaMenu(String tipoOrdenacao) {

		List<TiposDeRefeicoes> listaRefeicoes = new LinkedList<TiposDeRefeicoes>(refeicao.values());

		switch (tipoOrdenacao.toLowerCase()) {
		case "nome":

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

		Set<String> ref = refeicao.keySet();

		for (String chave : ref) {
			retorno += refeicao.get(chave).getNome() + ";";
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

		if (refeicao.containsKey(chaveNome)) {

			switch (atributo.toLowerCase()) {

			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", (refeicao.get(chaveNome).getPreco()));
				return retorno;

			case "descricao":

				return refeicao.get(chaveNome).getDescricao();

			}

		}
		if (refeicao.containsKey(chaveNome)) {

			switch (atributo.toLowerCase()) {

			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", refeicao.get(chaveNome).getPreco());
				return retorno;

			case "descricao":

				return refeicao.get(chaveNome).toString();

			}

		}

		throw new ConsultaRestauranteInvalidoException(" Nome do prato esto vazio.");
	}

	public double precoPedido(String nomePedido) {
		return refeicao.get(nomePedido).getPreco();
	}

	public void adicionaPedido(String email, String itemMenu) {
		
		
		
		// Pedidos pedido = factoryPedidos.criaPedido(nomePedido,
		// precoPedido(nomePedido));

	}

	/**
	 * @return the refeicao
	 */
	public LinkedHashMap<String, TiposDeRefeicoes> getRefeicao() {
		return refeicao;
	}

	public void ordenaCardapioPorNome() {

	}

	public void ordenaCardapioPorPreco() {

	}

}
