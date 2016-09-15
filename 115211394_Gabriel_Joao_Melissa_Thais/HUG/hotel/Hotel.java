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
	 * Construtor do hotel / inicializa o mapa de hospedes / inicializa a
	 * fabrica de hospedes
	 */
	public Hotel() {
		this.factoryHospedes = new FactoryHospedes();
		this.meusHospedes = new HashMap<String, Hospede>();
	}

	// #################################################CRUD
	// HOSPEDE#################################################################

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
			//lanca excecao se o parametro nao for um dos tres possiveis
			throw new StringInvalidaException("Parametro invalido.");

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
		//verifica se existe esse email cadastrado, se sim pesquisa
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
		//se nao houver ele lanca excecao
		throw new StringInvalidaException("Erro na consulta de hospede. Hospede de email " + id +" nao foi cadastrado(a).");
		
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
			throw new StringInvalidaException("Erro na consulta de hospede. Hospede de email " + email +" nao foi cadastrado(a).");

		}else{
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
	// ########################################################################

	/*
	 * public double calculaTotal(String email){ estadias.get(email).g
	 * 
	 * 
	 * 
	 * }
	 */
}
