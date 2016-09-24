package sistemaDeControleHotel;

import java.util.ArrayList;

import org.junit.Assert;

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
import hotel.Hotel;
import interfaces.IHotel;
import interfaces.IRestaurante;
import restaurante.Prato;
import restaurante.Restaurante;

/**
 * Classe que controla as funcionalidades do hotel e do restaurante
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class ControleDoSistema implements IHotel, IRestaurante {
	private Hotel controleHotel;
	private Restaurante controleRestaurante;
	
	public ControleDoSistema() throws Exception {
		this.controleHotel = new Hotel();
		this.controleRestaurante = new Restaurante();
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
	public void atualizaCadastro(String id, String valor, String info) throws AtualizacaoInvalidaException {
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
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws CadastroPratoInvalidoException  {
		controleRestaurante.cadastraPrato(nomePrato, precoPrato, descricaoPrato);
		
	}

	@Override
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException {
		controleRestaurante.cadastraRefeicao(nomeRef, descricaoRef, componentes);
	}

	@Override
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException {
		return controleRestaurante.pratosRefeicao(componentes);
	}
	
	@Override
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException  {
		return controleRestaurante.consultaRestaurante(chaveNome, atributo);
	}

}
