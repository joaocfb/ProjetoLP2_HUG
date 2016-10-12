
package restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


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
 * @author Gabriel Alves 
 * @author Joao Carlos 
 * @author Melissa Diniz 
 * @author Thais Nicoly
 */
public class Restaurante implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private FactoryPrato factoryPrato;
	private FactoryRefeicao factoryRefeicao;
	private ArrayList<TiposDeRefeicoes> menuRestaurante;
	private ArrayList<Pedidos> pedidosRestaurante;
	private String ordenacaoDoMenu = null;

	
	
	public Restaurante() {
		
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
		this.menuRestaurante = new ArrayList<>();
		this.pedidosRestaurante = new ArrayList<>();
		

	}



	/**
	 * Metodo que realiza o cadastro do prato no restaurante
	 * 
	 * @param nome
	 *            do Prato
	 * @param preco
	 *            do Prato
	 * @param descricao
	 *            do Prato
	 * 
	 * @throws CadastroPratoInvalidoException
	 * @throws ErroOrdenacaoException 
	 */
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)
			throws CadastroPratoInvalidoException, ErroOrdenacaoException {

		// validacao dos parametros - nomePrato / precoPrato / descricaoPrato
		VerificaCadastro.verificaNomePratoInvalido(nomePrato);
		VerificaCadastro.verificaPrecoInvalido(precoPrato);
		VerificaCadastro.verificaDescricaoPratoInvalido(descricaoPrato);

		if (!ExistePratoRefeicao(nomePrato)) {
			menuRestaurante.add(factoryPrato.criaPrato(nomePrato, descricaoPrato, precoPrato));

		}
		//Mantem a ordenacao anterior apos adicionar um novo prato 
		if (ordenacaoDoMenu != null){
			 if (ordenacaoDoMenu.equals("nome")) {
				  ordenaMenuPorNome();
			 }else{
				  ordenaMenuPorPreco();
			  }
			  
		}
		
	}

	/**
	 * Metodo que realiza o cadastro da refeicao no restaurante
	 * 
	 * @param nome da Refeicao @param descricao da Refeicao @param componentes -
	 * os pratos compostos na refeicao escolhida
	 * 
	 * @throws CadastroRefeicaoInvalidaException @throws
	 * @throws ErroOrdenacaoException 
	 */
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes)
			throws CadastroRefeicaoInvalidaException, ErroOrdenacaoException {
		
		// validacao dos parametros - nomeRef / descricaoPrato / componentes
		VerificaCadastro.verificaNomeRefeicaoInvalida(nomeRef);
		VerificaCadastro.verificaDescricaoRefeicaoInvalida(descricaoRef);
		VerificaCadastro.verificaComponentesVazio(componentes);

		ArrayList<Prato> pratosRef = pratosRefeicao(componentes);
		
		if (!ExistePratoRefeicao(nomeRef)) {
			menuRestaurante.add(factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRef));
		}
		
		//Mantem a ordenacao anterior apos adicionar uma nova refeicao
		if (ordenacaoDoMenu != null){
		  if (ordenacaoDoMenu.equals("nome")) {
			  ordenaMenuPorNome();
		  }else{
			  ordenaMenuPorPreco();
		  }
		  
		}
		
	}

	/**
	 * Metodo que retorna uma lista com os pratos da refeicao
	 * 
	 * @param componentes
	 *            - os pratos compostos da refeicao
	 * @return a lista dos pratos da refeicao
	 * 
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

		if ((pratosCadastrados != nomesComponentes.length)) {
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
	 * Metodo que imprime todos os pratos do menu
	 * 
	 * @return todos os pratos e refeicoes que estao no menu do restaurante
	 */
	public String consultaMenuRestaurante() {
		String retorno = "";

		for (TiposDeRefeicoes nomeRef : menuRestaurante) {
			retorno += nomeRef.getNome() + ";";
		}

		if (retorno.length() > 0) {
			retorno = retorno.substring(0, retorno.length() - 1);
		}

		return retorno;
	}

	/**
	 * Metodo que realiza a consulta de pratos e refeicoes no restaurante
	 * 
	 * @param chaveNome
	 *            - nome do prato ou refeicao
	 * @param atributo
	 *            - informacao que deseja-se consultar (preco / descricao)
	 * 
	 * @return a informacao referente ao atributo que desejou consultar (preco /
	 *         descricao)
	 * 
	 * @throws CadastroRefeicaoInvalidaException
	 * @throws ConsultaRestauranteInvalidoException
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

	/**
	 * Metodo que calcula o preco de um pedido
	 * @param nomePedido
	 * @return o valor do pedido
	 */
	public double precoPedido(String nomePedido) {
		double preco = 0;

		for (TiposDeRefeicoes pedido : menuRestaurante) {
			if (pedido.getNome().equalsIgnoreCase(nomePedido)) {
				preco = pedido.getPreco();
			}
		}

		return preco;
	}

	// ########### metodos da ordenacao ###########

	/**
	 * Ordena as refeicoes de acordo a qual deseja no atributo
	 * 
	 * @param tipo
	 *            de ordenacao que deseja (ordem alfabetica ou preco)
	 * @return a string formatada com a lista ordenada
	 */
	public String ordenaMenu(String tipo) throws ErroOrdenacaoException {

		switch (tipo.toLowerCase()) {

		case "nome":
			ordenaMenuPorNome();
			this.ordenacaoDoMenu = "nome";
			return imprimeStringOrdem();

		case "preco":
			ordenaMenuPorPreco();
			this.ordenacaoDoMenu = "preco";
			return imprimeStringOrdem();

		}
		throw new ErroOrdenacaoException("");
	}

	/**
	 * ordena os pratos pelo nome
	 */
	public void ordenaMenuPorNome() {
		Collections.sort(menuRestaurante, new OrdenaPorNome());

	}

	/**
	 * ordena os pratos pelo preco
	 */
	public void ordenaMenuPorPreco() {
		Collections.sort(menuRestaurante, new OrdenaPorPreco());
	}

	// ########## metodos privados ##########

	/**
	 * Metodo que imprime a lista na formatacao adequada
	 * 
	 * @return a lista com as refeicoes ordenada
	 */
	private String imprimeStringOrdem() {
		String retorno = "";
		for (TiposDeRefeicoes element : menuRestaurante) {
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
	 * @param nome
	 *            do Prato a ser buscado
	 * @return se o prato existe ou nao
	 */
	private boolean ExistePratoRefeicao(String nomePrato) {
		for (TiposDeRefeicoes tiposDeRefeicoes : menuRestaurante) {
			if (tiposDeRefeicoes.getNome().equalsIgnoreCase(nomePrato)) {
				return true;
			}
		}
		return false;
	}
	
	

	/**
	 * Metodo privado que retorna um Tipo De Refeiçao a partir de uma busca
	 * feita pelo nome do Prato
	 * 
	 * @param nome
	 *            do Prato
	 * 
	 * @return o seu tipo
	 */
	private TiposDeRefeicoes getRefeicaoNome(String nomePrato) {
		
		for (TiposDeRefeicoes tiposDeRefeicoes : menuRestaurante) {
			if (tiposDeRefeicoes.getNome().equalsIgnoreCase(nomePrato)) {
				return tiposDeRefeicoes;
			
			}
		}
		return null;
	}

	// Getters

	/**
	 * @return the refeicao
	 */
	public ArrayList<TiposDeRefeicoes> getRefeicao() {
		return menuRestaurante;
	}

	/**
	 * @return the pedidos
	 */
	public ArrayList<Pedidos> getPedidos() {
		return pedidosRestaurante;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Restaurante [refeicao=" + menuRestaurante + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuRestaurante == null) ? 0 : menuRestaurante.hashCode());
		result = prime * result + ((pedidosRestaurante == null) ? 0 : pedidosRestaurante.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Restaurante)) {
			return false;
		}
		
		Restaurante outro = (Restaurante) obj;
		
		if (menuRestaurante == null) {
			if (outro.menuRestaurante != null) {
				return false;
			}
		} else if (!menuRestaurante.equals(outro.menuRestaurante)) {
			return false;
		}
		if (pedidosRestaurante == null) {
			if (outro.pedidosRestaurante != null) {
				return false;
			}
		} else if (!pedidosRestaurante.equals(outro.pedidosRestaurante)) {
			return false;
		}
		return true;
	}

}