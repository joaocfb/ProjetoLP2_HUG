package hotel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Collection;
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
import factorys.FactoryTransacao;
import quartos.QuartoSimples;
import restaurante.Pedidos;
import restaurante.Restaurante;
import restaurante.TiposDeRefeicoes;
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
 * @author Gabriel Alves 
 * @author Joao Carlos 
 * @author Melissa Diniz 
 * @author Thais Nicoly
 *
 */
public class Hotel implements Serializable{

	private static final long serialVersionUID = 1L;
	private FactoryHospedes factoryHospedes;
	private FactoryEstadia factoryEstadia;
	private FactoryQuartos factoryQuarto;
	private FactoryPedidosDoHospede factoryPedidos;
	private FactoryTransacao factoryTransacao;

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
	 * Inicia todos os atributos do hotel
	 */
	public Hotel() {

		this.factoryQuarto = new FactoryQuartos();
		this.factoryHospedes = new FactoryHospedes();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryPedidos = new FactoryPedidosDoHospede();
		this.factoryTransacao = new FactoryTransacao();
		this.restaurante = new Restaurante();

		// armazena os nomes dos hospedes em uma string
		this.nomesHospedes = "";

		// armazena o valor das transacoes
		this.valorTransacoes = 0;
		this.numeroTransacoes = 0;

		this.listaIdsCheckout = new ArrayList<>();
		this.transacoes = new ArrayList<>();
		this.listaCheckouts = new ArrayList<>();
		this.lucrosDoHotel = new ArrayList<String>();
		this.hospedesDoHotel = new HashMap<String, Hospede>();
		this.quartosLivresDoHotel = new HashMap<>();
		this.quartosOcupadosDoHotel = new HashMap<>();
		
		
	}

	//CRUD Hospede
	
	/**
	 * Metodo que realiza o cadastro dos hospedes e adiciona na colecao
	 * 
	 * @param nome
	 *            do hospede
	 * @param email
	 *            do hospede
	 * @param dataNascimento
	 *            do hospede
	 * 
	 * @return Email do hospede cadastrado
	 * 
	 * @throws CadastroHospedeInvalidoException
	 * @throws VerificaNuloEVazioException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {

		// validacao dos parametros - nome/dataNascimento
		VerificaCadastro.verificaNomeInvalidoCadastro(nome);
		VerificaCadastro.verificaDataInvalidaCadastro(dataNascimento);
		VerificaCadastro.verificaFrDataInvalidaCadastro(dataNascimento);
		VerificaHospede.verificaIdadeInvalido(dataNascimento);

		// cadastra o hospede caso ele nao esteja ja cadastrado
		if (!verificaSeExisteHospede(email)) {
			hospedesDoHotel.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));
		}

		return email;
	}

	/**
	 * Atualiza as informacoes do hospede
	 * 
	 * @param email
	 *            do hospede
	 * @param valor
	 *            - informacao que deseja-se atualizar (nome/ data de
	 *            nascimento/ email)
	 * @param info
	 *            - nova informacao a ser atualizada
	 * 
	 * @throws AtualizacaoInvalidaException
	 * @throws CadastroHospedeInvalidoException
	 */
	public void atualizaCadastro(String email, String valor, String info)
			throws AtualizacaoInvalidaException, CadastroHospedeInvalidoException {

		switch (valor.toLowerCase().trim()) {
		case "nome":

			verificaAtualizacao.verificaNomeInvalidoAtualizacao(info);
			hospedesDoHotel.get(email).setNome(info);
			return;

		case "data de nascimento":

			// validacao do parametro - dataNascimento
			verificaAtualizacao.verificaDataInvalidaAtualizacao(info);
			verificaAtualizacao.verificaDataNascInvalidoAtualizacao(info);
			verificaAtualizacao.verificaIdadeInvalidaAtualizacao(info);

			hospedesDoHotel.get(email).setDataNascimento(info);
			return;

		case "email":
			// validacao do parametro - email
			verificaAtualizacao.verificaEmailInvalidoAtualizacao(info);

			// salva as informacoes do hospede com antigo email
			Hospede hospede = hospedesDoHotel.get(email);
			hospede.setEmail(info);
			hospedesDoHotel.remove(email);
			hospedesDoHotel.put(info, hospede);
			return;
		}

	}

	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param id
	 *            - ID do hospede
	 * @param info
	 *            - Informacacao desejada (nome/data de nascimento/email/pontos)
	 * 
	 * @return O nome ou data de nascimento ou email do hospede
	 * 
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

		throw new ConsultaHospedeInvalidaException(id);
	}

	/**
	 * Metodo que remove um hospede atraves do email
	 * 
	 * @param email
	 *            do hospede
	 * 
	 * @throws RemocaoInvalidaException
	 * @throws ConsultaHospedeInvalidaException
	 */
	public void removeHospede(String email) throws RemocaoInvalidaException, ConsultaHospedeInvalidaException {

		// validacao do parametro - email
		verificaRemocao.verificaEmailInvalidoRemocao(email);

		// lanca excecao caso o hospede nao esteja cadastrado no hotel
		if (!hospedesDoHotel.containsKey(email)) {
			throw new ConsultaHospedeInvalidaException(email);

		} else {
			hospedesDoHotel.remove(email);
		}
	}

	// ##### metodos privados referente ao hospede#####
	/**
	 * Metodo que verifica se um email ja esta cadastrado
	 * 
	 * @param email
	 *            do hospede
	 * 
	 * @return o hospede existente
	 */
	private boolean verificaSeExisteHospede(String email) {
		// verifica se ja existe um email sendo usado como chave no map
		if (hospedesDoHotel.size() == 0) {
			return false;
		}
		return hospedesDoHotel.containsKey(email);
	}

	// CRUD Estadia

	/**
	 * Metodo que realiza o checkin do hospede no hotel
	 * 
	 * @param email
	 *            do hospede
	 * @param quantDias
	 *            que o hospede ficara no hotel
	 * @param IDQuarto
	 *            que o hospede ficara hospedado
	 * @param tipoQuarto
	 *            que o hospede ficara hospedado
	 * 
	 * @throws CheckinInvalidoException
	 * @throws CriacaoQuartoInvalidoException
	 * @throws VerificaNuloEVazioException
	 */
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto)
			throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException {

		// validacao dos parametros - IDQuarto/email
		verificaCheckin.verificaIdInvalidaCheckin(IDQuarto);
		verificaCheckin.verificaEmailInvalidoCheckin(email);
		verificaCheckin.verificaEmailFrmInvalidoCheckin(email);

		// verifica se o hospede esta cadastrado
		if (!hospedesDoHotel.containsKey(email)) {
			throw new CheckinInvalidoException("Hospede de email " + email + " nao foi cadastrado(a).");
		}

		verificaCheckin.verificaQuantDiasInvalidaCheckin(quantDias);
		verificaCheckin.verificaTipoQuartoValido(tipoQuarto);

		// livre
		if (quartosLivresDoHotel.containsKey(IDQuarto)) {
			ocupaQuarto(IDQuarto);

			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);
			hospedesDoHotel.get(email).getEstadias().put(IDQuarto, estadiaNova);

			// Se estiver ocupado
		} else if (quartosOcupadosDoHotel.containsKey(IDQuarto)) {

			throw new CheckinInvalidoException("Quarto " + IDQuarto + " ja esta ocupado.");

			// Caso nao esteja nem livre nem ocupado
			// Cria quarto e adiciona na estadia
		} else {
			quartosOcupadosDoHotel.put(IDQuarto, factoryQuarto.criaQuartos(IDQuarto, tipoQuarto));
			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);
			hospedesDoHotel.get(email).getEstadias().put(IDQuarto, estadiaNova);
		}

	}

	/**
	 * Metodo que realiza o checkout de um hospede/atualiza os valores
	 * referentes aos checkouts do hotel
	 * 
	 * @param email
	 *            do hospede
	 * @param IDQuarto
	 *            que o hospede ficara hospedado
	 * 
	 * @return o valor do checkout (no formato string)
	 * 
	 * @throws CheckoutInvalidoException
	 * @throws ConsultaHospedagemInvalidaException
	 */
	public String realizaCheckout(String email, String IDQuarto)
			throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException {

		valida.VerificaCheckout.verificaEmailInvalido(email);
		valida.VerificaCheckout.verificaIdInvalidaCheckout(IDQuarto);

		// se o hospede estiver cadastrado
		if (verificaSeExisteHospede(email)) {
			// e hospedado
			if (hospedesDoHotel.get(email).getEstadias().size() != 0) {

				liberaQuarto(IDQuarto);
				hospedesDoHotel.get(email).alteraTipoDeCartao();

				// calcula o total dessa estadia
				double precoDaEstadia = calculaTotalEstadia(email, IDQuarto);
				double valorDesconto = hospedesDoHotel.get(email).getTipoDeCartao().desconto(precoDaEstadia);
				double precoComDesconto = precoDaEstadia - valorDesconto;

				this.getListaIdsCheckout().add(IDQuarto);

				checkout = new Checkout(hospedesDoHotel.get(email).getNome(), precoComDesconto);
				listaCheckouts.add(checkout);

				Transacao transacaoAtual = factoryTransacao.criaTransacao(precoComDesconto, IDQuarto,
						hospedesDoHotel.get(email).getNome());
				transacoes.add(transacaoAtual);
				atualizaValoresTransacoes(precoComDesconto, email);

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
	 *            do hospede
	 * @param atributo
	 *            - informacao que deseja-se pesquisar (hospedagens ativas/
	 *            quarto / total)
	 * 
	 * @return a informacao referente ao atributo que desejou pesquisar
	 *         (hospedagens ativas/ quarto / total)
	 * 
	 * @throws MensagemErroException
	 * @throws ConsultaHospedagemInvalidaException
	 */
	public String getInfoHospedagem(String email, String atributo)
			throws HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException {

		if (email.trim().isEmpty()) {
			throw new HospedagemAtivaInvalidaException("nao pode ser vazio.");

		}

		//valida email
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
	 * Metodo que retorna dados sobre os checkout do hotel
	 * 
	 * @param atributo
	 *            - informacao que deseja-se consultar (quantidade / total /
	 *            nome)
	 * 
	 * @return a informacao referente ao atributo que desejou pesquisar
	 *         (quantidade / total / nome)
	 * 
	 * @throws MensagemErroException
	 */
	public String consultaTransacoes(String atributo) throws MensagemErroException {

		switch (atributo.toLowerCase()) {

		case "quantidade":
			return Integer.toString(this.getNumeroTransacoes());

		case "total":
			DecimalFormat df = new DecimalFormat("R$.00");
			return df.format(retornarValorDeTransacoes());

		case "nome":
			String modificada = nomesHospedes.substring(0, nomesHospedes.length() - 1);
			return modificada;
		}
		
		throw new MensagemErroException("");
	}

	/**
	 * Metodo que retorna dados sobre os checkout do hotel
	 * 
	 * @param atributo
	 *            - informacao que deseja-se consultar (quantidade / total /
	 *            nome / detalhes)
	 * @param indice
	 *            - quantidade de transacoe realizadas
	 * 
	 * @return a informacao referente ao atributo que desejou pesquisar
	 *         (quantidade / total / nome / detalhes)
	 * 
	 * @throws MensagemErroException
	 * @throws IndiceInvalidoException
	 */
	public String consultaTransacoes(String atributo, int indice)
			throws MensagemErroException, IndiceInvalidoException {

		valida.verificaConsultaTransacoes.verificaIndiceInvalido(indice);

		if (indice <= transacoes.size()) {

			switch (atributo.toLowerCase()) {
			case "quantidade":
				return Integer.toString(transacoes.size());

			case "total":
				DecimalFormat df = new DecimalFormat("R$.00");
				df.setRoundingMode(RoundingMode.HALF_UP);
				return df.format(transacoes.get(indice).getTotal());

			case "nome":
				String nome = transacoes.get(indice).getNome();
				return nome;

			case "detalhes":
				return transacoes.get(indice).getDetalhe();
			}

		}
		throw new MensagemErroException("");

	}

	/**
	 * metodo que calcula os pontos conquistados pelo hospede e adiciona em seu
	 * registro no hotel
	 * 
	 * @param email
	 *            do hospede
	 * @param precoDaEstadia
	 *            do quarto em que o hospede esta
	 */
	public void recompensaPontos(String email, double precoDaEstadia) {
		int pontos = hospedesDoHotel.get(email).getTipoDeCartao().bonusPontos(precoDaEstadia);
		hospedesDoHotel.get(email).setPontos(hospedesDoHotel.get(email).getPontos() + pontos);
	}

	/**
	 * metodo que converte o inteiro pontos em string pontos para ser registrado
	 * no hotel
	 * 
	 * @param email
	 *            do hospede
	 * @param qtdPontos
	 *            que o hospede possui
	 * 
	 * @return a quantidade de pontos que o hospede possui em formato string
	 * @throws IOException
	 */
	public String convertePontos(String email, int qtdPontos) throws IOException {
		
		double pontosConvertidos = hospedesDoHotel.get(email).convertePontos(qtdPontos);

		String retorno = "";
		retorno += String.format("R$%.2f", pontosConvertidos);
		return retorno;
		

	}

	// ##### metodos privados referente a estadia #####
	/**
	 * Metodo que retorna o valor das transacoes
	 * 
	 * @return o valor das transacoes em formato String
	 */
	private double retornarValorDeTransacoes() {
		double preco = 0;

		for (Transacao c : transacoes) {
			preco += c.getTotal();
		}
		return preco;
	}



	/**
	 * Metodo que percorre as estadias e recupera o id dos quartos
	 * 
	 * @param email
	 *            do hospede
	 * 
	 * @return ids dos quartos do hotel
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

		if (!meusIds.isEmpty()) {
			meusIds = meusIds.substring(1);
		}
		return meusIds;

	}

	/**
	 * Metodo que libera um quarto, retira da lista de ocupados e adiciona na
	 * lista de vagos
	 * 
	 * @param ID do quarto
	 */
	private void liberaQuarto(String IDQuarto) {
		QuartoSimples quartoLivre = quartosOcupadosDoHotel.get(IDQuarto);
		quartosLivresDoHotel.put(IDQuarto, quartoLivre);
		quartosOcupadosDoHotel.remove(IDQuarto);
	}

	/**
	 * Metodo que ocupa um quarto, retira da lista de vagos e adiciona na lista
	 * de ocupados
	 * 
	 * @param ID do quarto
	 */
	private void ocupaQuarto(String IDQuarto) {
		QuartoSimples quartoNovo = quartosLivresDoHotel.get(IDQuarto);
		quartosOcupadosDoHotel.put(IDQuarto, quartoNovo);
		quartosLivresDoHotel.remove(IDQuarto);
	}


	/**
	 * metodo que calcula o total de todas as estadias
	 * 
	 * @param email
	 *            do hospede
	 * 
	 * @return o total de todas as estadias
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
	 *            do hospede
	 * @param IDQuarto
	 *            em que o hospede esta hospedado
	 * 
	 * @return o total de todas as estadias do hospede
	 */
	private double calculaTotalEstadia(String email, String IDQuarto) {

		int diasHospede = hospedesDoHotel.get(email).getEstadias().get(IDQuarto).getQuantDias();
		double preco = quartosLivresDoHotel.get(IDQuarto).getPRECO();
		return diasHospede * preco;
	}

	//Restaurante
	/**
	 * Metodo que realiza um pedido do hospede ao restauante
	 * 
	 * @param email
	 *            do hospede
	 * @param itemMenu
	 *            que o hospede deseja pedir
	 * 
	 * @return o valor total referente ao pedido do hospede
	 * @throws PedidosInvalidoException
	 */
	public String realizaPedido(String email, String itemMenu) throws PedidosInvalidoException {

		hospedesDoHotel.get(email).alteraTipoDeCartao();
		double preco = restaurante.precoPedido(itemMenu);
		Pedidos pedido = factoryPedidos.criaPedido(email, preco);
		double valorDesconto = hospedesDoHotel.get(email).getTipoDeCartao().desconto(preco);

		hospedesDoHotel.get(email).getPedidosDoHospede().add(pedido);
		restaurante.getPedidos().add(pedido);
		
		// cria a transacao
		Transacao transacaoAtual = factoryTransacao.criaTransacao(imprimeValor(preco, valorDesconto), itemMenu,
				hospedesDoHotel.get(email).getNome());
		
		transacoes.add(transacaoAtual);
		recompensaPontos(email, preco);

		// atualiza os dados das transacoes do hotel
		atualizaValoresTransacoes((preco - valorDesconto), email);

		double x = (preco - valorDesconto);

		DecimalFormat df = new DecimalFormat("R$.00");
		df.setRoundingMode(RoundingMode.UP);
		

		return df.format(x);

	}

	/**
	 * Metodo que formata a impressao do valor da transacao
	 * @param preco
	 * @param valorDesconto
	 * @return O valor da transacao menos o desconto
	 */
	private double imprimeValor(double preco, double valorDesconto) {
		String valor = "";
		DecimalFormat df = new DecimalFormat(".00");
		df.setRoundingMode(RoundingMode.UP);
		
		valor = df.format(preco - valorDesconto);
		valor = valor.replace(",", ".");
		double valorDouble = Double.parseDouble(valor);
		return valorDouble;
	}

	/**
	 * Metodo que atualiza a quantidade de transacoes o valor das transacoes e o
	 * nome dos hospedes que realizaram transacoes
	 * 
	 * @param valor
	 * @param email
	 */
	private void atualizaValoresTransacoes(double valor, String email) {

		this.setNumeroTransacoes(this.getNumeroTransacoes() + 1);
		this.setValorTransacoes(this.getValorTransacoes() + valor);
		this.setNomesHospedes(this.getNomesHospedes() + hospedesDoHotel.get(email).getNome() + ";");

	}
	
	// Getters

	/**
	 * 
	 * @return the restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * @return the hospedesDoHotel
	 */
	public HashMap<String, Hospede> getHospedesDoHotel() {
		return hospedesDoHotel;
	}

	/**+1
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
	 * @return the valorTransacoes
	 */
	public double getValorTransacoes() {
		return valorTransacoes;
	}

	/**
	 * @return the listaIdsCheckout
	 */
	public ArrayList<String> getListaIdsCheckout() {
		return listaIdsCheckout;
	}

	// Setters

	/**
	 * @param nomesHospedes
	 *            the nomesHospedes to set
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
	 * @param valorTransacoes
	 *            the valorTransacoes to set
	 */
	public void setValorTransacoes(double valorTransacoes) {
		this.valorTransacoes = valorTransacoes;
	}

	/**
	 * Representacao String do hotel
	 */
	@Override
	public String toString() {
		return "Hotel [nomesHospedes=" + nomesHospedes + "]";
	}

	
	//Arquivos
	
	/**
	 * Metodo que escreve os dados dos hospedes no arquivo
	 * @param arquivo que sera escrito
	 * @throws IOException
	 */
	public void arquivoCadastroHospede(FileWriter arquivo) throws IOException {
		Collection<Hospede> h = hospedesDoHotel.values();

		String quntHospedes = String.valueOf(h.size());
		arquivo.write("Cadastro de Hospedes: " + quntHospedes + " hospedes registrados  \r\n");

		int cont = 1;
		for (Hospede hospede : h) {
			arquivo.write("==> Hospede " + String.valueOf(cont) + ":  \r\n");
			cont += 1;
			arquivo.write(hospede.toString());
		}
	}

	/**
	 * Metodo que cria um arquivo e escreve nele dados do restaurante
	 * @param arquivo que sera escrito
	 * @throws IOException
	 */
	public void arquivoCadastroTiposDeRefeicoes(FileWriter arquivo) throws IOException {
		ArrayList<TiposDeRefeicoes> h = getRestaurante().getRefeicao();

		int cont = 1;
		String quntRefeicao = String.valueOf(h.size());
		arquivo.write("Menu do Restaurante: " + quntRefeicao + " itens do cardapio  \r\n");

		for (TiposDeRefeicoes refeicao : h) {
			arquivo.write("==> Item " + String.valueOf(cont) + ":  \r\n");
			arquivo.write(refeicao.toString());
			cont += 1;

		}
	}
	
	/**
	 * Metodo que cria um arquivo e escreve nele dados dos hospedes do hotel
	 * @param path
	 * @throws IOException
	 */
	public void arquivoCompletoHotel(FileWriter arquivo) throws IOException {

		arquivo.write("======================================================  \r\n");
		arquivoCadastroHospede(arquivo);
		arquivo.write("\r\n");
		arquivo.write("======================================================  \r\n");
		arquivoCadastroTiposDeRefeicoes(arquivo);
		arquivo.write("\r\n");
		arquivo.write("======================================================  \r\n");
		arquivoTransacoesHotel(arquivo);
	}
	
	/**
	 * Metodo que cria um arquivo e escreve nele dados das transacoes
	 * @param path
	 * @throws IOException
	 */
	public void arquivoTransacoesHotel(FileWriter arquivo) throws IOException {
		arquivo.write("Historico de Transacoes: \r\n");

		for (Transacao t : transacoes) {
			arquivo.write(t.toString());
			arquivo.write(" \r\n");
		}

		DecimalFormat df = new DecimalFormat("R$.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);

		arquivo.write("==== Resumo de transacoes ====\r\n");
		arquivo.write("Lucro total: R$" + df.format(retornarValorDeTransacoes()) + "\r\n");
		arquivo.write("Total de transacoes: " + numeroTransacoes + "\r\n");
		arquivo.write("Lucro medio por transacao: R$" + df.format(retornarValorDeTransacoes() / transacoes.size()) + "\r\n");
	}
	
	/**
	 * Metodo que inicia os arquivos
	 * @throws IOException
	 */
	public void iniciaArquivoSistema() throws IOException{

		File sub = new File("arquivos_sistema"+File.separator+"relatorios");
		sub.mkdirs();
		
		FileWriter arquivoCadastraHospede = new FileWriter("arquivos_sistema/relatorios/cad_hospedes.txt");
		FileWriter arquivoCadastraTransacoes = new FileWriter("arquivos_sistema/relatorios/cad_transacoes.txt");
		FileWriter arquivoCadastraRefeicoes = new FileWriter("arquivos_sistema/relatorios/cad_restaurante.txt");
		FileWriter arquivoHotel = new FileWriter("arquivos_sistema/relatorios/hotel_principal.txt");

		
		arquivoCadastroHospede(arquivoCadastraHospede);
		arquivoTransacoesHotel(arquivoCadastraTransacoes);
		arquivoCadastroTiposDeRefeicoes(arquivoCadastraRefeicoes);
		arquivoCompletoHotel(arquivoHotel);
		arquivoCadastraHospede.close();
		arquivoCadastraTransacoes.close();
		arquivoCadastraRefeicoes.close();
		arquivoHotel.close();
		
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transacoes == null) ? 0 : transacoes.hashCode());
		return result;
	}

}
