package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import quartos.QuartoSimples;
import exception.CadastroInvalidoException;
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

	private FactoryHospedes factoryHospedes;
	private FactoryEstadia factoryEstadia;
	private FactoryQuartos factoryQuarto;
	
	private HashMap<String, QuartoSimples> quartos;
	private HashMap<String, Hospede> meusHospedes;
	private ArrayList<String> lucrosDoHotel;
	
	private LocalDate hoje = LocalDate.now();
	

	/**
	 * Construtor do hotel / inicializa o mapa de hospedes / inicializa a
	 * fabrica de hospedes
	 * 
	 * @throws Exception
	 */
	public Hotel() throws Exception {
		this.lucrosDoHotel = new ArrayList<String>();
		this.factoryQuarto = new FactoryQuartos();
		this.factoryHospedes = new FactoryHospedes();
		this.factoryEstadia = new FactoryEstadia();
		this.meusHospedes = new HashMap<String, Hospede>();
		this.quartos = new HashMap<>();
		//cria uma lista de quartos
		this.criaListaQuartos();
		
	}

	/**
	 * Metodo que cria os quatos do hotel
	 * 
	 * @throws Exception
	 */
	private void criaListaQuartos() throws Exception {
		java.util.List<String> ids = Arrays.asList("1S", "2S", "3S", "4S", "1LX", "2LX", "3LX", "4LX", "1KIN", "2KIN",
				"3KIN", "4KIN");

		// adiciona no mapa de quartos
		for (String id : ids) {
			quartos.put(id, factoryQuarto.criaQuartos(id));
		}
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
	public void atualizaCadastro(String id, String valor, String info) throws StringInvalidaException {

		switch (valor.toLowerCase().trim()) {
		// info que eh o que quer alterar e id que relaciona ao hospede

		case "nome":
			meusHospedes.get(id).setNome(info);
			return;

		case "data de nascimento":
			meusHospedes.get(id).setDataNascimento(info);
			return;

		case "email":
			// salva as informacoes do hospede com antigo email
			Hospede hospede = meusHospedes.get(id);
			// altera o email
			hospede.setEmail(info);
			// remove o hospede com antiga chave/email
			meusHospedes.remove(id);
			// adiciona o mesmo hospede com nova chave/email
			meusHospedes.put(info, hospede);
			return;

		default:
			// lanca excecao se o parametro nao for um dos tres possiveis
			throw new StringInvalidaException("Parametro invalido.");

		}
	}

	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param info/id
	 * @return String
	 * @throws StringInvalidaException
	 */
	public String getInfoHospede(String id, String info) throws StringInvalidaException {
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
		// se nao houver ele lanca excecao
		throw new StringInvalidaException(
				"Erro na consulta de hospede. Hospede de email " + id + " nao foi cadastrado(a).");

	}

	/**
	 * Metodo que realiza o cadastro dos hospedes e adiciona na colecao
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws StringInvalidaException
	 * @throws TestesHospedeException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws CadastroInvalidoException, StringInvalidaException {
		// se nao existir esse email como chave ele adiciona o hospede
		if (!(verificaSeExisteHospede(email))) {

			meusHospedes.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));
			return email;
		}
		throw new CadastroInvalidoException("Cadastro nao realizado.");

	}

	/**
	 * Metodo que remove um hospede atraves do email
	 * 
	 * @param email
	 * @throws RemocaoInvalidaException
	 */
	public void removeHospede(String email) throws StringInvalidaException {
		if (!meusHospedes.containsKey(email)) {
			throw new StringInvalidaException(
					"Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");

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

	// ########################################################### ESTADIA #######################################################################

	/**
	 * Metodo que adiciona estadias no mapa do hospede
	 * 
	 * @param email
	 * @param IDQuarto
	 * @param quantDias
	 * @throws Exception
	 */
	// lembrete: verificar se o IDQUARTO ta vago
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception {
		
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
		throw new Exception("O quarto esta ocupado.");
	}

	/**
	 * Metodo que remove uma estadia de um hospede
	 * 
	 * @param email
	 * @param idQuarto
	 */
	private void removeEstadia(String email, String idQuarto) {
		// remove uma estadia de um hospede
		meusHospedes.get(email).getEstadias().remove(idQuarto);
	}

	/**
	 * Metodo que realiza o checkout de um hospede
	 * 
	 * @param email
	 * @param IDQuarto
	 * @return double
	 */
	public void checkout(String email, String IDQuarto) {
		
		// altera o status do quarto para vago
		quartos.get(IDQuarto).setStatus(true);

		// remove a estadia
		removeEstadia(email, IDQuarto);

		this.registroHotel(email, IDQuarto);

	}

	/**
	 * Metodo que atualiza os registro de lucro do hotel
	 * 
	 * @param email
	 * @param idQuarto
	 * @return String
	 */
	private String registroHotel(String email, String IDQuarto) {
		StringBuilder dados = new StringBuilder();
		dados.append(hoje);
		dados.append(meusHospedes.get(email).getNome());
		dados.append(IDQuarto);
		dados.append(calculaTotalEstadia(email, IDQuarto));

		lucrosDoHotel.add(dados.toString());
		return dados.toString();
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
