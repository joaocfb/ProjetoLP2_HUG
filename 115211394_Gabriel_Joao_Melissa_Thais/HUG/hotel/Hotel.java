package hotel;

import java.util.HashMap;
import java.util.Map;

import exception.BuscaHospedeException;
import exception.StringInvalidaException;
import factorys.FactoryHospedes;
import quartos.QuartoSimples;

/**
 * Classe Hotel: faz o cadastro, edicao/atualizacao, busca e remove hospedes
 * atraves do email
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Hotel {
	

	private HashMap<String, QuartoSimples> quartos;
	private Map<String, Hospede> meusHospedes;
	private FactoryHospedes factoryHospedes;
	

	public Hotel() {
		this.meusHospedes = new HashMap<String, Hospede>();
	}
	
	//#################################################CRUD HOSPEDE#################################################################
	
	/**
	 * Atualiza as informacoes do hospede 
	 * @param info
	 * @param valor
	 * @param id
	 * @throws StringInvalidaException
	 */
	public void atualizaCadastro(String info, String valor, String id)throws StringInvalidaException{
		
		switch (info.trim().toLowerCase()) {
		//info que eh o que quer alterar e id que relaciona ao hospede

		case "nome":
			meusHospedes.get(id).setNome(valor);
		case "datadenascimento":
			meusHospedes.get(id).setDataNascimento(valor);
		case "email":
			meusHospedes.get(id).setEmail(valor);
		default:
			throw new StringInvalidaException("Parametro invalido.");
		}
	}
	
	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * @param info/id 
	 * @return String
	 * @throws StringInvalidaException
	 */
	public String getInfoHospede(String info, String id) throws StringInvalidaException{
		//info que eh o que quer retornar e id que relaciona ao hospede
		switch (info.toLowerCase().trim()) {
		
		case "nome":
			//pega no mapa de hospedes o nome do hospede com o id/chave(email)
			return meusHospedes.get(id).getNome();
		case "datadenascimento":
			return meusHospedes.get(id).getDataNascimento();
		case "email":
			return meusHospedes.get(id).getEmail();
		default:
			throw new StringInvalidaException("Erro na consulta de hospede. Hospede de email " + meusHospedes.get(id).getEmail() + " nao foi cadastrado(a).");
		}
	}
	
	/**
	 * Metodo que realiza o cadastro dos hospedes 
	 * e adiciona na colecao
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws StringInvalidaException{
		//se nao existir esse email como chave ele adiciona o hospede 
		if (!(verificaSeExisteHospede(email))) {
			meusHospedes.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));
			return email;
		}
		throw new StringInvalidaException("O nome do hospede nao eh valido.");
		
	}
	
	/**
	 * Metodo que remove um hospede usando o email
	 * @param email
	 */
	public void removeHospede(String email){
		if (verificaSeExisteHospede(email)) {
			meusHospedes.remove(email);
		}
	}
	
	/**
	 * Metodo que verifica se um email ja esta cadastrado
	 * @param email
	 * @return boolean
	 */
	private boolean verificaSeExisteHospede(String email){
		//verifica se ja existe um email sendo usado como chave no map
		if (meusHospedes.containsKey(email)) {
			return true;
		}return false;
		
	}
	
	/**
	 * Metodo que retorna o Hospede se ele existir
	 * @param email
	 * @return Hospede
	 * @throws BuscaHospedeException
	 */
	public Hospede retornaHospede(String email)throws BuscaHospedeException{
		if (verificaSeExisteHospede(email)) {
			return meusHospedes.get(email);
		}
		throw new BuscaHospedeException("Nao existe um hospede com esse email.");
	}
	
	//########################################################### ESTADIA ########################################################################
	
	/*
	public double calculaTotal(String email){
		estadias.get(email).g
		
		
		
	}
	*/
}
