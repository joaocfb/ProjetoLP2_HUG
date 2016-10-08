package sistemaDeControleHotel;

import java.util.ArrayList;

import exception.AtualizacaoInvalidaException;
import exception.CadastroHospedeInvalidoException;
import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.CheckinInvalidoException;
import exception.CheckoutInvalidoException;
import exception.ConsultaHospedagemInvalidaException;
import exception.ConsultaHospedeInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import exception.CriacaoQuartoInvalidoException;
import exception.ErroOrdenacaoException;
import exception.HospedagemAtivaInvalidaException;
import exception.IndiceInvalidoException;
import exception.MensagemErroException;
import exception.PedidosInvalidoException;
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;

import hotel.Hotel;
import restaurante.Prato;

import interfaces.HotelInterface;
import interfaces.RestauranteInterface;

/**
 * Classe que controla as funcionalidades do hotel e do restaurante
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class ControleDoSistema implements HotelInterface, RestauranteInterface {
	private Hotel controleHotel;
	
	public ControleDoSistema() throws Exception {
		
		this.controleHotel = new Hotel();
	}

	public void iniciaSistema() {
		//NAO IMPLEMENTADO AINDA.
	}
	
	public void fechaSistema() {
		//NAO IMPLEMENTADO AINDA.
	}
	
	// ##################################### Controle do Hotel #####################################
	
	// ######## Hospede ########
	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento)	throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {
		return controleHotel.cadastraHospede(nome, email, dataNascimento);
	}
	
	@Override
	public void atualizaCadastro(String id, String valor, String info) throws AtualizacaoInvalidaException, CadastroHospedeInvalidoException {
			controleHotel.atualizaCadastro(id, valor, info);
	}

	@Override
	public String getInfoHospede(String info, String id) throws ConsultaHospedeInvalidaException {
		return controleHotel.getInfoHospede(info, id);

	}

	@Override
	public void removeHospede(String email) throws ConsultaHospedeInvalidaException, RemocaoInvalidaException {
			controleHotel.removeHospede(email);
	}
	
	// ######## Estadia ########
	@Override
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException  {
			controleHotel.realizaCheckin(email, quantDias, IDQuarto, tipoQuarto);
			
	}

	@Override
	public String realizaCheckout(String email, String IDQuarto) throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException {
		return controleHotel.realizaCheckout(email, IDQuarto);
	}

	@Override
	public String getInfoHospedagem(String email, String atributo) throws  HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException {
		return controleHotel.getInfoHospedagem(email, atributo);
	}

	@Override
	public String consultaTransacoes(String atributo) throws MensagemErroException {
		return controleHotel.consultaTransacoes(atributo);
	}

	@Override
	public String consultaTransacoes(String atributo, int indice) throws MensagemErroException, IndiceInvalidoException {
		return controleHotel.consultaTransacoes(atributo, indice);
	}
	
	// #####################################  Controle do Restaurante ##################################### 
	@Override
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws CadastroPratoInvalidoException, ErroOrdenacaoException  {
		controleHotel.getRestaurante().cadastraPrato(nomePrato, precoPrato, descricaoPrato);
		
	}

	@Override
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException, ErroOrdenacaoException {
		controleHotel.getRestaurante().cadastraRefeicao(nomeRef, descricaoRef, componentes);
	}

	@Override
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {
		return controleHotel.getRestaurante().pratosRefeicao(componentes);
	}
	
	@Override
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException  {
		return controleHotel.getRestaurante().consultaRestaurante(chaveNome, atributo);
	}

	@Override
	public String consultaMenuRestaurante() {
		return controleHotel.getRestaurante().consultaMenuRestaurante();
	}

	@Override
	public String ordenaMenu(String tipoOrdenacao) throws Exception{
		return controleHotel.getRestaurante().ordenaMenu(tipoOrdenacao);
	}

	@Override
	public String realizaPedido(String email, String item)throws PedidosInvalidoException {
		return controleHotel.realizaPedido(email, item);
	}

	@Override
	public String convertePontos(String email, int qtdPontos) {
		
		return controleHotel.convertePontos(email, qtdPontos);
	}

}
