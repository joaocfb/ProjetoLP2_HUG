/**
 * 
 */
package sistemaDeControleHotel;

import java.util.ArrayList;

import easyaccept.EasyAccept;
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
import exception.HospedagemAtivaInvalidaException;
import exception.IndiceInvalidoException;
import exception.MensagemErroException;
import exception.PedidosInvalidoException;
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;

import restaurante.Prato;

import interfaces.HotelInterface;
import interfaces.RestauranteInterface;

/**
 * Classe Hotel Facade que delega funcoes para o controller de Hotel
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class Fachada {
	
	private ControleDoSistema controller;
	
	public Fachada() throws Exception{
		this.controller = new ControleDoSistema();
	}
	
	public void iniciaSistema() {
		controller.iniciaSistema();
	}
	
	public void fechaSistema() {
		controller.fechaSistema();
	}
	// ## Hotel ## 
	
	// Hospede
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroHospedeInvalidoException, VerificaNuloEVazioException  {
		return controller.cadastraHospede( nome, email, dataNascimento);
	
	}
	
	public void atualizaCadastro(String id, String valor, String info) throws AtualizacaoInvalidaException, CadastroHospedeInvalidoException {
		controller.atualizaCadastro(id, valor, info);
		
	}

	public String getInfoHospede(String info, String id) throws ConsultaHospedeInvalidaException {
		return controller.getInfoHospede(info, id);
		
	}
	
	public void removeHospede(String email) throws ConsultaHospedeInvalidaException, RemocaoInvalidaException  {
		controller.removeHospede(email);
		
		
	}
	
	// Estadia
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException  {
		controller.realizaCheckin(email, quantDias, IDQuarto, tipoQuarto);
			
	}

	public String realizaCheckout(String email, String IDQuarto) throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException   {
		return controller.realizaCheckout(email, IDQuarto);
		
	}

	public String getInfoHospedagem(String email, String atributo) throws HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException  {
		return controller.getInfoHospedagem(email, atributo);
		
	}
	
	public String consultaTransacoes(String atributo) throws MensagemErroException {
		return controller.consultaTransacoes(atributo);
		
	}
	
	public String consultaTransacoes(String atributo, int indice) throws MensagemErroException, IndiceInvalidoException  {
		return controller.consultaTransacoes(atributo, indice);
		
	}
	
	// ## Restaurante ##
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws CadastroPratoInvalidoException   {
		controller.cadastraPrato(nomePrato, precoPrato, descricaoPrato);
		
	}
	
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException   {
		controller.cadastraRefeicao(nomeRef, descricaoRef, componentes);
		
	}
	
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {
		return controller.pratosRefeicao(componentes);
	}
	
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException   {
		return controller.consultaRestaurante(chaveNome, atributo);
		
	}

	public String consultaMenuRestaurante() {
		return controller.consultaMenuRestaurante();
	}

	public String ordenaMenu(String tipoOrdenacao)throws Exception {
		return controller.ordenaMenu(tipoOrdenacao);
	}
	
	public String realizaPedido(String email, String item)throws PedidosInvalidoException {
		return controller.realizaPedido(email, item);
	}
	
    public String convertePontos(String email, int qtdPontos) {
		return controller.convertePontos(email, qtdPontos);
	}
}
