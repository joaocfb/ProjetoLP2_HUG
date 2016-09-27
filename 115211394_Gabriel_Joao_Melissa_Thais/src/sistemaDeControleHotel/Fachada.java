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

public class Fachada implements HotelInterface, RestauranteInterface {
	
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
	
	@Override
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {
		return controller.pratosRefeicao(componentes);
	}
	
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException   {
		return controller.consultaRestaurante(chaveNome, atributo);
		
	}
	
	// main
	public static void main(String[] args) {
		//, "testes/easy/testes_uc3.txt", "testes/easy/testes_uc4.txt", "testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc4_exception.txt"
	    args = new String[] {"sistemaDeControleHotel.Fachada", "testes/easy/testes_uc1.txt","testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc2.txt","testes/easy/testes_uc2_exception.txt", "testes/easy/testes_uc3.txt", "testes/easy/testes_uc3_exception.txt", "testes/easy/testes_uc4.txt","testes/easy/testes_uc4_exception.txt", "testes/easy/testes_uc5.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

	@Override
	public String consultaMenuRestaurante() {
		return controller.consultaMenuRestaurante();
	}
}
