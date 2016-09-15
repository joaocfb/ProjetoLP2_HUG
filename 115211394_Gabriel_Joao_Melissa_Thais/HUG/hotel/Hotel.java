package hotel;

import java.util.HashMap;

import quartos.QuartoSimples;
import exception.BuscaHospedeException;
import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import factorys.FactoryHospedes;

/**
 * Classe Hotel: faz o cadastro, edicao/atualizacao, busca e remove hospedes
 * atraves do email
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Hotel {

	private HashMap<String, QuartoSimples> quartos;
	private HashMap<String, Hospede> meusHospedes;
	private FactoryHospedes factoryHospedes;

	/**
	 * Construtor do hotel / inicializa o mapa de hospedes / inicializa a fabrica de hospedes
	 */
	public Hotel() {
		this.factoryHospedes = new FactoryHospedes();
		this.meusHospedes = new HashMap<String, Hospede>();
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
	public void atualizaCadastro(String info, String valor, String id) throws StringInvalidaException {

		switch (info.toLowerCase().trim()) {
		// info que eh o que quer alterar e id que relaciona ao hospede

		case "nome":
			meusHospedes.get(id).setNome(valor);
		case "data de nascimento":
			meusHospedes.get(id).setDataNascimento(valor);
		case "email":
			meusHospedes.get(id).setEmail(valor);
		default:
			throw new StringInvalidaException("Erro na consulta de hospede. Hospede de email "
					+ meusHospedes.get(id).getEmail() + " nao foi cadastrado(a).");
		}
	}

	/**
	 * @return the meusHospedes
	 */
	public int getMeusHospedes() {
		return meusHospedes.size();
	}

	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param info/id
	 * @return String
	 * @throws StringInvalidaException
	 */
	public String getInfoHospede(String id, String info) throws StringInvalidaException {
		// info que eh o que quer retornar e id que relaciona ao hospede
		switch (info.toLowerCase().trim()) {

		case "nome":
			// pega no mapa de hospedes o nome do hospede com o id/chave(email)
			return meusHospedes.get(id).getNome();
		case "data de nascimento":
			return meusHospedes.get(id).getDataNascimento();
		case "email":
			return meusHospedes.get(id).getEmail();
		default:
			throw new StringInvalidaException("Erro na consulta de hospede. Hospede de email "
					+ meusHospedes.get(id).getEmail() + " nao foi cadastrado(a).");
		}
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
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException {
		// se nao existir esse email como chave ele adiciona o hospede
		if (!(verificaSeExisteHospede(email))) {
			//Hospede hospedeNovo = factoryHospedes.criaHospede(nome, email, dataNascimento);
			meusHospedes.put(email, new Hospede(nome, email, dataNascimento));
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
	public void removeHospede(String email) throws RemocaoInvalidaException {
		if (verificaSeExisteHospede(email)) {
			meusHospedes.remove(email);
		}
		throw new RemocaoInvalidaException("Nao foi possivel remover o hospede, email nao cadastrado.");
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

	/**
	 * Metodo que retorna o Hospede se ele existir
	 * 
	 * @param email
	 * @return Hospede
	 * @throws BuscaHospedeException
	 */
	private Hospede retornaHospede(String email) throws BuscaHospedeException {
		if (verificaSeExisteHospede(email)) {
			return meusHospedes.get(email);
		}
		throw new BuscaHospedeException("Nao existe um hospede com esse email.");
	}

	// ########################################################### ESTADIA
	// ########################################################################

	/*
	 * public double calculaTotal(String email){ estadias.get(email).g
	 * 
	 * 
	 * 
	 * }
	 */
}
