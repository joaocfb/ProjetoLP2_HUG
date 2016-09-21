package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import quartos.QuartoSimples;
import testesValores.TestaValores;
import exception.AtualizacaoInvalidaException;
import exception.CadastroInvalidoException;
import exception.CheckinInvalidoException;
import exception.ConsultaInvalidaException;
import exception.HospedagemAtivaInvalidaException;
import exception.MensagemErroException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import factorys.FactoryEstadia;
import factorys.FactoryHospedes;
import factorys.FactoryQuartos;

/**
 * Classe Hotel: faz o cadastro, edicao/atualizacao, busca e remove hospedes
 * atraves do email Faz checkin/checkout, atualiza o historico de lucros.
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Hotel {
	
	//fabricas
	private FactoryHospedes factoryHospedes;
	private FactoryEstadia factoryEstadia;
	private FactoryQuartos factoryQuarto;
	
	//varia
	private Checkout checkout;
	private String nomesHospedes;
	private int numeroTransacoes;
	private double valorTransacoes;
	private TestaValores testa;

	private ArrayList<Checkout> listaCheckouts;
	private HashMap<String, QuartoSimples> quartos;
	private HashMap<String, Hospede> meusHospedes;
	private ArrayList<String> lucrosDoHotel;


	/**
	 * Construtor do hotel / inicializa o mapa de hospedes / inicializa a
	 * fabrica de hospedes
	 * 
	 * @throws Exception
	 */
	public Hotel(){
		this.factoryQuarto = new FactoryQuartos();
		this.factoryHospedes = new FactoryHospedes();
		this.factoryEstadia = new FactoryEstadia();

		this.nomesHospedes = "";
		this.valorTransacoes = 0;
		this.numeroTransacoes = 0;

		this.listaCheckouts = new ArrayList<>();
		this.lucrosDoHotel = new ArrayList<String>();
		this.meusHospedes = new HashMap<String, Hospede>();
		this.quartos = new HashMap<>();
	}

	// #################################################CRUD HOSPEDE#################################################################

	/**
	 * Atualiza as informacoes do hospede
	 * 
	 * @param info
	 * @param valor
	 * @param id
	 * @throws StringInvalidaException
	 */
	public void atualizaCadastro(String email, String valor, String info) throws Exception, AtualizacaoInvalidaException {
		
			switch (valor.toLowerCase().trim()) {
			// info que eh o que quer alterar e id que relaciona ao hospede

			case "nome":
				if (info.trim().isEmpty()) {
					throw new AtualizacaoInvalidaException("Nome do(a) hospede nao pode ser vazio.");	
				}
				if(!(Pattern.matches("[a-zA-Z ]+", info))) {
					throw new AtualizacaoInvalidaException("Nome do(a) hospede esta invalido.");
				}
				meusHospedes.get(email).setNome(info);
				return;

			case "data de nascimento":
				
				testa.verificaDataInvalidaAtualizacao(info);
				testa.verificaDataNascInvalidoAtualizacao(info);
				testa.verificaIdadeInvalidaAtualizacao(info);
				
				meusHospedes.get(email).setDataNascimento(info);
				return;

			case "email":
				testa.verificaEmailInvalidoAtualizacao(info);
				// salva as informacoes do hospede com antigo email
				Hospede hospede = meusHospedes.get(email);
				// altera o email
				hospede.setEmail(info);
				// remove o hospede com antiga chave/email
				meusHospedes.remove(email);
				// adiciona o mesmo hospede com nova chave/email
				meusHospedes.put(info, hospede);

				return;
			}

	}

		/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param info/id
	 * @return String
	 * @throws Exception 
	 */
	public String getInfoHospede(String id, String info) throws Exception {
		// verifica se existe esse email cadastrado, se sim pesquisa
		
		if (meusHospedes.containsKey(id)) {
			switch (info.toLowerCase().trim()) {

			case "nome":
				return meusHospedes.get(id).getNome();
			case "data de nascimento":
				return meusHospedes.get(id).getDataNascimento();
				
			case "email":

				return meusHospedes.get(id).getEmail();

			}

		}
		// se nao houver ele lanca excecao "Erro na consulta de hospede. Hospede
		// de email " + id + " nao foi cadastrado(a).
		throw new StringInvalidaException(
				"Erro na consulta de hospede. Hospede de email " + id + " nao foi cadastrado(a).");

	}

	/**
	 * Metodo que realiza o cadastro dos hospedes e adiciona na colecao
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws Exception 
	 * @throws TestesHospedeException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)throws Exception, CadastroInvalidoException {
		testa.verificaNomeInvalidoCadastro(nome);
		testa.verificaDataInvalidaCadastro(dataNascimento);
		testa.verificaFrDataInvalidaCadastro(dataNascimento);
		
		if (!verificaSeExisteHospede(email)) {
			meusHospedes.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));
			
		}
		//ALTERAMOS AKIIIIIIIIIIIIIIIIIIIIIIIIIIIIII 
		return email;	
	}
	
	
	  

	/**
	 * Metodo que remove um hospede atraves do email
	 * 
	 * @param email
	 * @throws Exception 
	 * @throws RemocaoInvalidaException
	 */
	public void removeHospede(String email) throws ConsultaInvalidaException, RemocaoInvalidaException {
		testa.verificaEmailInvalidoRemocao(email);
		
		if (!meusHospedes.containsKey(email)) {
			throw new ConsultaInvalidaException("hospede. Hospede de email " + email + " nao foi cadastrado(a).");

		} else {
			meusHospedes.remove(email);

		}
	}

	/**
	 * Metodo que verifica se um email ja esta cadastrado
	 * 
	 * @param email
	 * @return boolean
	 */
	private boolean verificaSeExisteHospede(String email) {
		// verifica se ja existe um email sendo usado como chave no map
		if (meusHospedes.size() == 0) {
			return false;
		}
		return meusHospedes.containsKey(email);
	}

	// ########################################################### ESTADIA
	// #######################################################################

	/**
	 * Metodo que realiza o checkout de um hospede/atualiza os valores
	 * referentes aos checkouts do hotel TODO ERRADO
	 * 
	 * @param email
	 * @param IDQuarto
	 * @return double
	 */
	public String realizaCheckout(String email, String IDQuarto) throws ConsultaInvalidaException {

		// se o hospede estiver cadastrado
		if (verificaSeExisteHospede(email)) {
			// e hospedado
			if (meusHospedes.get(email).getEstadias().size() != 0) {

				// altera o status do quarto para vago
				quartos.get(IDQuarto).setStatus(true);

				this.nomesHospedes += meusHospedes.get(email).getNome() + ";";
				this.numeroTransacoes += 1;
				this.valorTransacoes += calculaTotalEstadia(email, IDQuarto);

				checkout = new Checkout(meusHospedes.get(email).getNome(), calculaTotalEstadia(email, IDQuarto));
				listaCheckouts.add(checkout);

				// formata o valor da estadia para String
				String retorno = "";
				retorno += "R$";
				retorno += String.format("%.2f", calculaTotalEstadia(email, IDQuarto));
				meusHospedes.get(email).getEstadias().remove(IDQuarto);

				return retorno;
			}
		}

		throw new ConsultaInvalidaException("hospedagem. " + meusHospedes.get(email).getNome() + " nao esta hospedado(a).");

	}

	
	public String consultaTransacoes(String atributo, int indice) throws MensagemErroException{
		
		if (indice <= listaCheckouts.size()) {

			switch (atributo.toLowerCase()) {

			case "quantidade":
				return Integer.toString(listaCheckouts.size());

			case "total":
				
				// formata a string
				String retorno = "";
				retorno += "R$";
				retorno += String.format("%.2f", listaCheckouts.get(indice).getValor());
				return retorno;

			case "nome":
				String nome = listaCheckouts.get(indice).getNome();
				return nome;
			}

		}
		throw new MensagemErroException("");

	}

	/**
	 * Metodo que retorna dados sobre os checkout do hotel
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
	 * Metodos que realiza o checkin de um hospede no hotel
	 * 
	 * @param email
	 * @param quantDias
	 * @param IDQuarto
	 * @param tipoQuarto
	 * @throws Exception
	 */
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception, CheckinInvalidoException {
		
		
		if (email.trim().isEmpty()) {
			throw new CheckinInvalidoException("Email do(a) hospede nao pode ser vazio.");
		}
		testa.verificaEmailInvalidoCheckin(email);
		
		if (!meusHospedes.containsKey(email)) {
			throw new CheckinInvalidoException("Hospede de email "+ email + " nao foi cadastrado(a).");
		}
		testa.verificaQuantDiasInvalidaCheckin(quantDias);
		if (!(tipoQuarto.equalsIgnoreCase("luxo") || tipoQuarto.equalsIgnoreCase("simples") || tipoQuarto.equalsIgnoreCase("presidencial"))) {
			throw new CheckinInvalidoException("Tipo de quarto invalido.");
		}
		
		if (!quartos.containsKey(IDQuarto)) {
			quartos.put(IDQuarto, factoryQuarto.criaQuartos(IDQuarto, tipoQuarto));
			
			
			// cria uma estadia com os parametros(Id quarto e quant Dias)
			// Estadia
			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);

			// adiciona no mapa de estadias pertencente ao hospede
			meusHospedes.get(email).getEstadias().put(IDQuarto, estadiaNova);

			// altera o status do quarto
			quartos.get(IDQuarto).setStatus(false);

		} else {

			// se ja existir esse quarto na lista verifica se ele ta livre
			if (quartos.get(IDQuarto).getStatus()) {
				// pega o hospede com o email dado
				Hospede hospede = meusHospedes.get(email);

				// cria uma estadia com os parametros(Id quato e quant Dias)
				Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);

				// adiciona no mapa de estadias pertencente ao hospede
				hospede.getEstadias().put(IDQuarto, estadiaNova);

				// altera o status do quarto
				quartos.get(IDQuarto).setStatus(false);
			}
			throw new CheckinInvalidoException("Quarto " + IDQuarto + " ja esta ocupado.");
		}


	}

	/**
	 * Metodo que percorre as estadias e recupera o id dos quartos
	 * 
	 * @param email
	 * @return String
	 */
	private String retornaIdQuartos(String email) {
		String meusIds = "";
		ArrayList<String> ids = new ArrayList<String>();

		for (Estadia estadia : meusHospedes.get(email).getEstadias().values()) {
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

	// ERRO NA LINHA 31 O NOME DO METODO
	/**
	 * Metodo que recupera as informacoes da hospedagem de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @return String
	 * @throws MensagemErroException 
	 * @throws Exception
	 */
	public String getInfoHospedagem(String email, String atributo) throws ConsultaInvalidaException, HospedagemAtivaInvalidaException, MensagemErroException{
		String nome = meusHospedes.get(email).getNome();
		
		if (email.trim().isEmpty()) {
			throw new HospedagemAtivaInvalidaException("Email do(a) hospede nao pode ser vazio.");

		}
		
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new HospedagemAtivaInvalidaException("Email do(a) hospede esta invalido.");
		}
		
		// se o hospede esta cadastrado
		if (meusHospedes.containsKey(email)) {
			// se ele possui estadia ativa
			if (meusHospedes.get(email).getEstadias().size() != 0) {

				switch (atributo.toLowerCase()) {

				case "hospedagens ativas":
					return Integer.toString(meusHospedes.get(email).getEstadias().size());

				case "quarto":
					return retornaIdQuartos(email);

				case "total":
					String retorno = "";
					retorno += String.format("R$%.2f", calculaTodasAsEstadias(email));
					return retorno;

				default:
					throw new MensagemErroException("");
				}
			}

		}
		throw new ConsultaInvalidaException("hospedagem. Hospede " + nome + " nao esta hospedado(a).");
	}

	/**
	 * Metodo que remove uma estadia de um hospede
	 * 
	 * @param email
	 * @param idQuarto
	 */
	private boolean removeEstadia(String email, String idQuarto) {

		// remove uma estadia de um hospede
		if (meusHospedes.get(email).getEstadias().containsKey(idQuarto)) {
			meusHospedes.get(email).getEstadias().remove(idQuarto);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que atualiza os registro de lucro do hotel
	 * ALTEEEEEEEEEEEEEEERAAAAAAAAAAAAAA
	 * @param email
	 * @param idQuarto
	 * @return String
	 */
	private String registroHotel(String email, String IDQuarto) {
		StringBuilder dados = new StringBuilder();
		dados.append(meusHospedes.get(email).getNome());
		dados.append(IDQuarto);
		dados.append(calculaTotalEstadia(email, IDQuarto));

		lucrosDoHotel.add(dados.toString());
		return dados.toString();
	}

	private double calculaTodasAsEstadias(String email) {
		double valorTotal = 0;
		Hospede hospede = meusHospedes.get(email);
		for (Estadia estadia : hospede.getEstadias().values()) {
			valorTotal += quartos.get(estadia.getIDQuarto()).getPRECO() * estadia.getQuantDias();
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
		int diasHospede = meusHospedes.get(email).getEstadias().get(IDQuarto).getQuantDias();
		// pega o preco do quarto(depende do tipo)
		double preco = quartos.get(IDQuarto).getPRECO();
		// faz o calculo dos gastos
		return diasHospede * preco;
	}

}
