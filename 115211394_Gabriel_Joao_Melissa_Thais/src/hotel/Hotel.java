package hotel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

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
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;
import factorys.FactoryEstadia;
import factorys.FactoryHospedes;
import factorys.FactoryQuartos;
import quartos.QuartoSimples;
import valida.VerificaCadastro;
import valida.VerificaHospede;
import valida.verificaAtualizacao;
import valida.verificaCheckin;
import valida.verificaRemocao;


/**
 * Classe Hotel eh responsavel pelo(a):
 * Cadastro;
 * Edicao/Atualizacao;
 * Busca e Remove hospedes atraves do email;
 * Checkin/Checkout; 
 * Atualiza o historico de lucros.
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
	//private TestaValores testa;
	
	private ArrayList<Checkout> listaCheckouts;
	private HashMap<String, QuartoSimples> quartosLivresDoHotel;
	private HashMap<String, Hospede> meusHospedes;
	private ArrayList<String> lucrosDoHotel;
	private HashMap<String, QuartoSimples> quartosOcupadosDoHotel;


	/**
	 * Construtor do hotel  
	 * 
	 */
	public Hotel(){
		
		//Inicia as factorys
		this.factoryQuarto = new FactoryQuartos();
		this.factoryHospedes = new FactoryHospedes();
		this.factoryEstadia = new FactoryEstadia();

		this.nomesHospedes = "";
		this.valorTransacoes = 0;
		this.numeroTransacoes = 0;

		//Inicia as colecoes
		this.listaCheckouts = new ArrayList<>();
		this.lucrosDoHotel = new ArrayList<String>();
		this.meusHospedes = new HashMap<String, Hospede>();
		this.quartosLivresDoHotel = new HashMap<>();
		this.quartosOcupadosDoHotel = new HashMap<>();
	}

	// #################################################CRUD HOSPEDE#######################################################
	
	/**
	 * Metodo que realiza o cadastro dos hospedes e adiciona na colecao
	 * @param nome do hospede
	 * @param email do hospede
	 * @param dataNascimento do hospede
	 * @return Email do hospede cadastrado
	 * @throws CadastroHospedeInvalidoException
	 * @throws VerificaNuloEVazioException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {
		
		// Faz validacao dos dados do hospede 
		VerificaCadastro.verificaNomeInvalidoCadastro(nome);
		VerificaCadastro.verificaDataInvalidaCadastro(dataNascimento);
		VerificaCadastro.verificaFrDataInvalidaCadastro(dataNascimento);
		VerificaHospede.verificaIdadeInvalido(dataNascimento);

		if (!verificaSeExisteHospede(email)) {
			meusHospedes.put(email, factoryHospedes.criaHospede(nome, email, dataNascimento));			
		}

		return email;	
	}
	
	/**
	 * Atualiza as informacoes do hospede
	 * @param info
	 * @param valor
	 * @param id
	 * @throws CadastroHospedeInvalidoException 
	 */
	public void atualizaCadastro(String email, String valor, String info) throws AtualizacaoInvalidaException, CadastroHospedeInvalidoException {
		
			switch (valor.toLowerCase().trim()) {

			case "nome":
				
				VerificaCadastro.verificaNomeInvalidoCadastro(info);

				meusHospedes.get(email).setNome(info);
				break;

			case "data de nascimento":
				
				verificaAtualizacao.verificaDataInvalidaAtualizacao(info);
				verificaAtualizacao.verificaDataNascInvalidoAtualizacao(info);
				verificaAtualizacao.verificaIdadeInvalidaAtualizacao(info);

				meusHospedes.get(email).setDataNascimento(info);
				break;

			case "email":
				
				verificaAtualizacao.verificaEmailInvalidoAtualizacao(info);

				// salva as informacoes do hospede com antigo email
				Hospede hospede = meusHospedes.get(email);
				// altera o email
				hospede.setEmail(info);
				// remove o hospede com antiga chave/email
				meusHospedes.remove(email);
				// adiciona o mesmo hospede com nova chave/email
				meusHospedes.put(info, hospede);
				break;
			}

	}

	/**
	 * Metodo que retorna informacoes sobre o hospede
	 * 
	 * @param ID do hospede
	 * @param Informcacao desejada 
	 * @return O nome ou data de nascimento ou email do hospede
	 * @throws ConsultaHospedeInvalidaException
	 */
	public String getInfoHospede(String id, String info) throws ConsultaHospedeInvalidaException {
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
	public void removeHospede(String email) throws  RemocaoInvalidaException, ConsultaHospedeInvalidaException {
		
		verificaRemocao.verificaEmailInvalidoRemocao(email);
		//testa.verificaEmailInvalidoRemocao(email);
		
		if (!meusHospedes.containsKey(email)) {
			throw new ConsultaHospedeInvalidaException(email);

		} else {
			meusHospedes.remove(email);

		}
	}
	
	// metodos privados 
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

	// ########################################################### ESTADIA #####################################################
	
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
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException  {
		

		verificaCheckin.verificaIdInvalidaCheckin(IDQuarto);
		verificaCheckin.verificaEmailInvalidoCheckin(email);
		verificaCheckin.verificaEmailFrmInvalidoCheckin(email);
		
		
		if (!meusHospedes.containsKey(email)) {
			throw new CheckinInvalidoException("Hospede de email "+ email + " nao foi cadastrado(a).");
		}
		
		verificaCheckin.verificaQuantDiasInvalidaCheckin(quantDias);
		
		if (!(tipoQuarto.equalsIgnoreCase("luxo") || tipoQuarto.equalsIgnoreCase("simples") || tipoQuarto.equalsIgnoreCase("presidencial"))) {
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
			meusHospedes.get(email).getEstadias().put(IDQuarto, estadiaNova);

		//Se estiver ocupado 
		//Lança excessao
		} else if (quartosOcupadosDoHotel.containsKey(IDQuarto)) {
			
			throw new CheckinInvalidoException("Quarto " + IDQuarto + " ja esta ocupado.");
			
		//Caso não esteja nem livre nem ocupado
		//Cria quarto e adiciona na estadia
		} else {
			quartosOcupadosDoHotel.put(IDQuarto, factoryQuarto.criaQuartos(IDQuarto, tipoQuarto));

			// cria uma estadia com os parametros(Id quarto e quant Dias)
			// Estadia
			Estadia estadiaNova = factoryEstadia.criaEstadia(IDQuarto, quantDias);

			// adiciona no mapa de estadias pertencente ao hospede
			meusHospedes.get(email).getEstadias().put(IDQuarto, estadiaNova);
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
	public String realizaCheckout(String email, String IDQuarto) throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException {
		valida.VerificaCheckout.verificaEmailInvalido(email);
		valida.VerificaCheckout.verificaIdInvalidaCheckout(IDQuarto);
		// se o hospede estiver cadastrado
		if (verificaSeExisteHospede(email)) {
			// e hospedado
			if (meusHospedes.get(email).getEstadias().size() != 0) {

				//Salva o quarto / remove de quartos ocupados / adiciona em quartos vagos
				QuartoSimples quartoLivre = quartosOcupadosDoHotel.get(IDQuarto);
				quartosLivresDoHotel.put(IDQuarto, quartoLivre);

				quartosOcupadosDoHotel.remove(IDQuarto);


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

		throw new ConsultaHospedagemInvalidaException (meusHospedes.get(email).getNome());

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
	public String getInfoHospedagem(String email, String atributo) throws HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException{

		if (email.trim().isEmpty()) {
			throw new HospedagemAtivaInvalidaException("nao pode ser vazio.");

		}
		
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new HospedagemAtivaInvalidaException("esta invalido.");
		}
		
		String nome = meusHospedes.get(email).getNome();
		
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
		throw new ConsultaHospedagemInvalidaException ("Hospede " + nome);
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
	 * @param atributo
	 * @param indice
	 * @return
	 * @throws MensagemErroException
	 * @throws IndiceInvalidoException 
	 */
	public String consultaTransacoes(String atributo, int indice) throws MensagemErroException, IndiceInvalidoException{
		
		valida.verificaConsultaTransacoes.verificaIndiceInvalido(indice);
		
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

	// metodos privados
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
	
	/**
	 * metodo que calcula o total de todas as estadias
	 * @param email
	 * @return
	 */
	private double calculaTodasAsEstadias(String email) {
		double valorTotal = 0;
		Hospede hospede = meusHospedes.get(email);
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
		int diasHospede = meusHospedes.get(email).getEstadias().get(IDQuarto).getQuantDias();
		// pega o preco do quarto(depende do tipo)
		double preco = quartosLivresDoHotel.get(IDQuarto).getPRECO();
		// faz o calculo dos gastos
		return diasHospede * preco;
	}
	
}
