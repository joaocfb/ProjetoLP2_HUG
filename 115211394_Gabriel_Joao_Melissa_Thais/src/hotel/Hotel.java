package hotel;

/**
 * Lembrar de: no realiza pedido adicionar desconto no valor de transacoes
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;

import exception.AtualizacaoInvalidaException;
import exception.CadastroHospedeInvalidoException;
import exception.CheckinInvalidoException;
import exception.CheckoutInvalidoException;
import exception.ConsultaHospedagemInvalidaException;
import exception.ConsultaHospedeInvalidaException;
import exception.CriacaoQuartoInvalidoException;
import exception.HospedagemAtivaInvalidaException;
import exception.IndiceInvalidoException;
import exception.MensagemErroException;
import exception.PedidosInvalidoException;
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;
import factorys.FactoryEstadia;
import factorys.FactoryHospedes;
import factorys.FactoryPedidosDoHospede;
import factorys.FactoryQuartos;
import quartos.QuartoSimples;
import restaurante.Pedidos;
import restaurante.Restaurante;
import valida.VerificaCadastro;
import valida.VerificaHospede;
import valida.verificaAtualizacao;
import valida.verificaCheckin;
import valida.verificaRemocao;

/**
 * Classe Hotel eh responsavel pelo(a): Cadastro; Edicao/Atualizacao; Busca e
 * Remove hospedes atraves do email; Checkin/Checkout; Atualiza o historico de
 * lucros.
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Hotel {

	// fabricas
	private FactoryHospedes factoryHospedes;
	private FactoryEstadia factoryEstadia;
	private FactoryQuartos factoryQuarto;
	private FactoryPedidosDoHospede factoryPedidos;

	// varia
	private Checkout checkout;
	private String nomesHospedes;
	private int numeroTransacoes;
	private double valorTransacoes;

	private Restaurante restaurante;
	private ArrayList<Transacao> transacoes;
	private ArrayList<String> listaIdsCheckout;

	private ArrayList<Checkout> listaCheckouts;
	private HashMap<String, QuartoSimples> quartosLivresDoHotel;
	private HashMap<String, Hospede> hospedesDoHotel;
	private ArrayList<String> lucrosDoHotel;
	private HashMap<String, QuartoSimples> quartosOcupadosDoHotel;

	/**
	 * Construtor do hotel
	 * 
	 */
	public Hotel() {

		// Inicia as factorys
		this.factoryQuarto = new FactoryQuartos();
		this.factoryHospedes = new FactoryHospedes();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryPedidos = new FactoryPedidosDoHospede();

		this.restaurante = new Restaurante();
		this.nomesHospedes = "";
		this.valorTransacoes = 0;
		this.numeroTransacoes = 0;

		// Inicia as colecoes
		this.listaIdsCheckout = new ArrayList<>();
		this.transacoes = new ArrayList<>();
		this.listaCheckouts = new ArrayList<>();
		this.lucrosDoHotel = new ArrayList<String>();
		this.hospedesDoHotel = new HashMap<String, Hospede>();
		this.quartosLivresDoHotel = new HashMap<>();
		this.quartosOcupadosDoHotel = new HashMap<>();
	}

	
	// #################################################CRUD HOSPEDE#######################################################

	/**
	 * Metodo que realiza o cadastro dos hospedes e adiciona na colecao
	 * 
	 * @param nome
	 *            do hospede
	 * @param email
	 *            do hospede
	 * @param dataNascimento
	 *            do hospede
	 * @return Email do hospede cadastrado
	 * @throws CadastroHospedeInvalidoException
	 * @throws VerificaNuloEVazioException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {

		// Faz validacao dos dados do hospede
		VerificaCadastro.verificaNomeInvalidoCadastro(nome);
		VerificaCadastro.verificaDataInvalidaCadastro(dataNascimento);
		VerificaCadastro.verificaFrDataInvalidaCadastro(dataNascimento);
		VerificaHospede.verificaIdadeInvalido(dataNascimento);

		if (!verificaSeExisteHospede(email)) {
			hospedesDoHotel.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));
		}

		return email;
	}

	/**
	 * Atualiza as informacoes do hospede
	 * 
	 * @param info
	 * @param valor
	 * @param id
	 * @throws CadastroHospedeInvalidoException
	 */
	public void atualizaCadastro(String email, String valor, String info)
			throws AtualizacaoInvalidaException, CadastroHospedeInvalidoException {

		switch (valor.toLowerCase().trim()) {

		case "nome":

			verificaAtualizacao.verificaNomeInvalidoAtualizacao(info);

			hospedesDoHotel.get(email).setNome(info);
			break;

		case "data de nascimento":

			verificaAtualizacao.verificaDataInvalidaAtualizacao(info);
			verificaAtualizacao.verificaDataNascInvalidoAtualizacao(info);
			verificaAtualizacao.verificaIdadeInvalidaAtualizacao(info);

			hospedesDoHotel.get(email).setDataNascimento(info);
			break;

		case "email":

			verificaAtualizacao.verificaEmailInvalidoAtualizacao(info);

			// salva as informacoes do hospede com antigo email
			Hospede hospede = hospedesDoHotel.get(email);
			// altera o email
			hospede.setEmail(info);
			// remove o hospede com antiga chave/email
			hospedesDoHotel.remove(email);
			// adiciona o mesmo hospede com nova chave/email
			hospedesDoHotel.put(info, hospede);
			break;
		}

	}

	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param ID
	 *            do hospede
	 * @param Informcacao
	 *            desejada
	 * @return O nome ou data de nascimento ou email do hospede
	 * @throws ConsultaHospedeInvalidaException
	 */
	public String getInfoHospede(String id, String info) throws ConsultaHospedeInvalidaException {
		// verifica se existe esse email cadastrado, se sim pesquisa

		if (hospedesDoHotel.containsKey(id)) {
			switch (info.toLowerCase().trim()) {

			case "nome":
				return hospedesDoHotel.get(id).getNome();
			case "data de nascimento":
				return hospedesDoHotel.get(id).getDataNascimento();
			case "email":
				return hospedesDoHotel.get(id).getEmail();
			case "pontos":
				String pontos = "";
				pontos += hospedesDoHotel.get(id).getPontos();
				return pontos;
			}

		}

		// se nao houver ele lanca excecao "Erro na consulta de hospede. Hospede
		// de email " + id + " nao foi cadastrado(a).
		throw new ConsultaHospedeInvalidaException(id);

	}

	/**
	 * Metodo que remove um hospede atraves do email
	 * 
	 * @param email
	 * @throws Exception
	 * @throws RemocaoInvalidaException
	 * @throws ConsultaHospedeInvalidaException
	 * @throws NaoFoiCadastradoException
	 */
	public void removeHospede(String email) throws RemocaoInvalidaException, ConsultaHospedeInvalidaException {

		verificaRemocao.verificaEmailInvalidoRemocao(email);
		// testa.verificaEmailInvalidoRemocao(email);

		if (!hospedesDoHotel.containsKey(email)) {
			throw new ConsultaHospedeInvalidaException(email);

		} else {
			hospedesDoHotel.remove(email);

		}
	}

	// ############################### ESTADIA ###############################

	/**
	 * Metodos que realiza o checkin de um hospede no hotel
	 * 
	 * @param email
	 * @param quantDias
	 * @param IDQuarto
	 * @param tipoQuarto
	 * @throws CheckinInvalidoException
	 * @throws CriacaoQuartoInvalidoException
	 * @throws VerificaNuloEVazioException
	 * @throws Exception
	 */
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto)
			throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException {

		verificaCheckin.verificaIdInvalidaCheckin(IDQuarto);
		verificaCheckin.verificaEmailInvalidoCheckin(email);
		verificaCheckin.verificaEmailFrmInvalidoCheckin(email);

		if (!hospedesDoHotel.containsKey(email)) {
			throw new CheckinInvalidoException("Hospede de email " + email + " nao foi cadastrado(a).");
		}

		verificaCheckin.verificaQuantDiasInvalidaCheckin(quantDias);

		if (!(tipoQuarto.equalsIgnoreCase("luxo") || tipoQuarto.equalsIgnoreCase("simples")
				|| tipoQuarto.equalsIgnoreCase("presidencial"))) {
			throw new CheckinInvalidoException("Tipo de quarto invalido.");
		}

		// Se estiver disponivel.
		// salvar / remover / adicionar
		if (quartosLivresDoHotel.containsKey(IDQuarto)) {

			QuartoSimples quartoNovo = quartosLivresDoHotel.get(IDQuarto);
			quartosOcupadosDoHotel.put(IDQuarto, quartoNovo);
			quartosLivresDoHotel.remove(IDQuarto);

			// cria uma estadia com os parametros(Id quarto e quant Dias)
			// Estadia
			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);

			// adiciona no mapa de estadias pertencente ao hospede
			hospedesDoHotel.get(email).getEstadias().put(IDQuarto, estadiaNova);

			// Se estiver ocupado
			// Lança excessao
		} else if (quartosOcupadosDoHotel.containsKey(IDQuarto)) {

			throw new CheckinInvalidoException("Quarto " + IDQuarto + " ja esta ocupado.");

			// Caso não esteja nem livre nem ocupado
			// Cria quarto e adiciona na estadia
		} else {
			quartosOcupadosDoHotel.put(IDQuarto, factoryQuarto.criaQuartos(IDQuarto, tipoQuarto));

			// cria uma estadia com os parametros(Id quarto e quant Dias)
			// Estadia
			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);

			// adiciona no mapa de estadias pertencente ao hospede
			hospedesDoHotel.get(email).getEstadias().put(IDQuarto, estadiaNova);
		}

	}

	/**
	 * Metodo que realiza o checkout de um hospede/atualiza os valores
	 * referentes aos checkouts do hotel
	 * 
	 * @param email
	 * @param IDQuarto
	 * @return double
	 * @throws CheckoutInvalidoException
	 * @throws ConsultaHospedagemInvalidaException
	 * @throws Exception
	 */
	public String realizaCheckout(String email, String IDQuarto)
			throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException {
		
		valida.VerificaCheckout.verificaEmailInvalido(email);
		valida.VerificaCheckout.verificaIdInvalidaCheckout(IDQuarto);
		
		// se o hospede estiver cadastrado
		if (verificaSeExisteHospede(email)) {
			// e hospedado
			if (hospedesDoHotel.get(email).getEstadias().size() != 0) {

				// Salva o quarto / remove de quartos ocupados / adiciona em
				// quartos vagos
				QuartoSimples quartoLivre = quartosOcupadosDoHotel.get(IDQuarto);
				quartosLivresDoHotel.put(IDQuarto, quartoLivre);

				quartosOcupadosDoHotel.remove(IDQuarto);

				// Verifica se a quantidade de pontos de hospede ja e o
				// suficiente para mudar o tipo de cartao
				hospedesDoHotel.get(email).alteraTipoDeCartao();

				
				// calcula o total dessa estadia
				double precoDaEstadia = calculaTotalEstadia(email, IDQuarto);

				// calcula valor do desconto a ser aplicado
				double valorDesconto = hospedesDoHotel.get(email).getTipoDeCartao().desconto(precoDaEstadia);

				// aplica desconto
				double precoComDesconto = precoDaEstadia - valorDesconto;

				this.getListaIdsCheckout().add(IDQuarto);
				this.nomesHospedes += hospedesDoHotel.get(email).getNome() + ";";
				this.numeroTransacoes += 1;
				this.valorTransacoes += precoComDesconto;

				checkout = new Checkout(hospedesDoHotel.get(email).getNome(), precoComDesconto);
				listaCheckouts.add(checkout);
				transacoes.add(new Transacao(precoComDesconto, IDQuarto, hospedesDoHotel.get(email).getNome()));

				// formata o valor da estadia para String
				String retorno = "";
				retorno += String.format("R$%.2f", precoComDesconto);
				hospedesDoHotel.get(email).getEstadias().remove(IDQuarto);

				// Adiciona no hospede os pontos gerado no chekout
				recompensaPontos(email, precoDaEstadia);

				return retorno;
			}
		}

		throw new ConsultaHospedagemInvalidaException(hospedesDoHotel.get(email).getNome());

	}

	/**
	 * Metodo que recupera as informacoes da hospedagem de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @return String
	 * @throws MensagemErroException
	 * @throws ConsultaHospedagemInvalidaException
	 * @throws Exception
	 */
	public String getInfoHospedagem(String email, String atributo)
			throws HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException {

		if (email.trim().isEmpty()) {
			throw new HospedagemAtivaInvalidaException("nao pode ser vazio.");

		}

		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new HospedagemAtivaInvalidaException("esta invalido.");
		}

		String nome = hospedesDoHotel.get(email).getNome();

		// se o hospede esta cadastrado
		if (hospedesDoHotel.containsKey(email)) {
			// se ele possui estadia ativa
			if (hospedesDoHotel.get(email).getEstadias().size() != 0) {

				switch (atributo.toLowerCase()) {

				case "hospedagens ativas":
					return Integer.toString(hospedesDoHotel.get(email).getEstadias().size());

				case "quarto":
					return retornaStringIdQuartos(email);

				case "total":
					String retorno = "";
					retorno += String.format("R$%.2f", calculaTodasAsEstadias(email));
					return retorno;

				default:
					throw new MensagemErroException("");
				}
			}

		}
		throw new ConsultaHospedagemInvalidaException("Hospede " + nome);
	}

	/**
	 * Metodo que retorna dados sobre os checkout do hotel // um atributo
	 * 
	 * @param atributo
	 * @return String
	 * @throws Exception
	 */
	public String consultaTransacoes(String atributo) throws MensagemErroException {

		switch (atributo.toLowerCase()) {

		case "quantidade":
			// esse valor eh atualizado cada vez que faz um checkout
			return Integer.toString(this.numeroTransacoes);

		case "total":
			// formata a string
			String retorno = "";
			retorno += "R$";
			retorno += String.format("%.2f", valorTransacoes);
			return retorno;

		case "nome":
			// apaga o ; no final da string
			String modificada = nomesHospedes.substring(0, nomesHospedes.length() - 1);
			return modificada;
		}
		throw new MensagemErroException("");
	}

	/**
	 * Metodo que retorna dados sobre os checkout do hotel // dois atributos
	 * 
	 * @param atributo
	 * @param indice
	 * @return
	 * @throws MensagemErroException
	 * @throws IndiceInvalidoException
	 */

	public String consultaTransacoes(String atributo, int indice)throws MensagemErroException, IndiceInvalidoException {
		System.out.println(restaurante.getRefeicao());
		valida.verificaConsultaTransacoes.verificaIndiceInvalido(indice);

		if (indice <= transacoes.size()) {

			switch (atributo.toLowerCase()) {

			case "quantidade":
				
				return Integer.toString(transacoes.size());

			case "total":

				// formata a string
				String retorno = "";
				retorno += "R$";
				retorno += String.format("%.2f", transacoes.get(indice).getTotal());
				return retorno;

			case "nome":
				String nome = listaCheckouts.get(indice).getNome();
				return nome;
				
			case "detalhes":
				return getListaIdsCheckout().get(indice);
			}

		}
		throw new MensagemErroException("");

	}
	
	public void recompensaPontos(String email, double precoDaEstadia) {

		// calcula os pontos gerado com o chekout dessa estadia
		int pontos = hospedesDoHotel.get(email).getTipoDeCartao().bonusPontos(precoDaEstadia);

		// adiciona os pontos no hospede
		hospedesDoHotel.get(email).setPontos(hospedesDoHotel.get(email).getPontos() + pontos);

	}
	
	
	// ######################## RESTAURANTE ########################
	
	/**
	 * 
	 * @param email
	 * @param itemMenu
	 * @return
	 * @throws PedidosInvalidoException
	 */
	public String realizaPedido(String email, String itemMenu) throws PedidosInvalidoException {
		
		
		//pega o preco de uma refeicao/prato
		double preco = restaurante.precoPedido(itemMenu);
		
		//cria um pedido com o email do hospede e o valor do prato
		Pedidos pedido = factoryPedidos.criaPedido(email, preco);

		//atualiza a quantidade de transacoes do hotel
		this.setNumeroTransacoes(this.getNumeroTransacoes() + 1);
		
		// Verifica se a quantidade de pontos de hospede ja e o
		// suficiente para mudar o tipo de cartao
		hospedesDoHotel.get(email).alteraTipoDeCartao();

		//calcula o valor do desconto
		double valorDesconto = hospedesDoHotel.get(email).getTipoDeCartao().desconto(preco);
		
		// APLICAR DESCONTO NESSE VALOR --- atualiza o valor das transacoes do hotel
		this.setValorTransacoes(this.getValorTransacoes() + (preco - valorDesconto));

		//adiciona o nome do hospede que fez pedido
		this.setNomesHospedes(this.getNomesHospedes() + hospedesDoHotel.get(email).getNome() + ";"); 

		//adiciona o pedido na lista de pedidos do hospede
		hospedesDoHotel.get(email).getPedidosDoHospede().add(pedido);
		
		//adiciona na lista de pedidos do restaurante
		restaurante.getPedidos().add(pedido);

		//cria a transacao
		Transacao transacaoAtual = new Transacao((preco - valorDesconto), pedido.getNome(), hospedesDoHotel.get(email).getNome());
		
		//adiciona o obj transacao
		transacoes.add(transacaoAtual);
		
		//adiciona os pontos em hospede
		recompensaPontos(email, preco);
		
		// formata o preco para String
		String retorno = "";
		return retorno += String.format("R$%.2f", (preco - valorDesconto));

		
	}
	


	
	
	public Restaurante getRestaurante() {
		return restaurante;
	}


	// ############# metodos privados #############
		/**
		 * Metodo que verifica se um email ja esta cadastrado
		 * 
		 * @param email
		 * @return boolean
		 */
		private boolean verificaSeExisteHospede(String email) {
			// verifica se ja existe um email sendo usado como chave no map
			if (hospedesDoHotel.size() == 0) {
				return false;
			}
			return hospedesDoHotel.containsKey(email);
		}
	
	/**
	 * Metodo que percorre as estadias e recupera o id dos quartos
	 * 
	 * @param email
	 * @return String
	 */
	private String retornaStringIdQuartos(String email) {
		String meusIds = "";
		ArrayList<String> ids = new ArrayList<String>();

		for (Estadia estadia : hospedesDoHotel.get(email).getEstadias().values()) {
			ids.add(estadia.getIDQuarto());
		}

		for (String string : ids) {
			meusIds = meusIds + "," + string;
		}

		// retira a , da frente
		if (!meusIds.isEmpty()) {
			meusIds = meusIds.substring(1);
		}
		return meusIds;

	}

	/**
	 * Metodo que remove uma estadia de um hospede
	 * 
	 * @param email
	 * @param idQuarto
	 */
	private boolean removeEstadia(String email, String idQuarto) {

		// remove uma estadia de um hospede
		if (hospedesDoHotel.get(email).getEstadias().containsKey(idQuarto)) {
			hospedesDoHotel.get(email).getEstadias().remove(idQuarto);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que atualiza os registro de lucro do hotel
	 * ALTEEEEEEEEEEEEEEERAAAAAAAAAAAAAA
	 * 
	 * @param email
	 * @param idQuarto
	 * @return String
	 */
	private String registroHotel(String email, String IDQuarto) {
		StringBuilder dados = new StringBuilder();
		dados.append(hospedesDoHotel.get(email).getNome());
		dados.append(IDQuarto);
		dados.append(calculaTotalEstadia(email, IDQuarto));

		lucrosDoHotel.add(dados.toString());
		return dados.toString();
	}

	/**
	 * metodo que calcula o total de todas as estadias
	 * 
	 * @param email
	 * @return
	 */
	private double calculaTodasAsEstadias(String email) {
		double valorTotal = 0;
		Hospede hospede = hospedesDoHotel.get(email);
		for (Estadia estadia : hospede.getEstadias().values()) {
			valorTotal += quartosOcupadosDoHotel.get(estadia.getIDQuarto()).getPRECO() * estadia.getQuantDias();
		}

		return valorTotal;
	}

	/**
	 * Metodo que calcula o valor total de uma estadia de um hospede
	 * 
	 * @param email
	 * @param IDQuarto
	 * @return double
	 */
	private double calculaTotalEstadia(String email, String IDQuarto) {

		// pega o numero de dias de hospedagem
		int diasHospede = hospedesDoHotel.get(email).getEstadias().get(IDQuarto).getQuantDias();
		// pega o preco do quarto(depende do tipo)
		double preco = quartosLivresDoHotel.get(IDQuarto).getPRECO();
		// faz o calculo dos gastos
		return diasHospede * preco;
	}

	/**
	 * @return the hospedesDoHotel
	 */
	public HashMap<String, Hospede> getHospedesDoHotel() {
		return hospedesDoHotel;
	}

	/**
	 * @return the numeroTransacoes
	 */
	public int getNumeroTransacoes() {
		return numeroTransacoes;
	}

	/**
	 * @return the nomesHospedes
	 */
	public String getNomesHospedes() {
		return nomesHospedes;
	}

	/**
	 * @param nomesHospedes the nomesHospedes to set
	 */
	public void setNomesHospedes(String nomesHospedes) {
		this.nomesHospedes = nomesHospedes;
	}

	/**
	 * @param numeroTransacoes
	 *            the numeroTransacoes to set
	 */
	public void setNumeroTransacoes(int numeroTransacoes) {
		this.numeroTransacoes = numeroTransacoes;
	}

	/**
	 * @return the valorTransacoes
	 */
	public double getValorTransacoes() {
		return valorTransacoes;
	}

	/**
	 * @param valorTransacoes
	 *            the valorTransacoes to set
	 */
	public void setValorTransacoes(double valorTransacoes) {
		this.valorTransacoes = valorTransacoes;
	}

	/**
	 * @return the listaIdsCheckout
	 */
	public ArrayList<String> getListaIdsCheckout() {
		return listaIdsCheckout;
	}

}
