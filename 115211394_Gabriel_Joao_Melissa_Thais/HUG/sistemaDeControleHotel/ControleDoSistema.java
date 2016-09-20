package sistemaDeControleHotel;

import org.junit.Assert;

import exception.StringInvalidaException;
import hotel.Hotel;
import interfaces.IHotel;
import restaurante.Restaurante;

/**
 * Classe que controla as funcionalidades do hotel
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class ControleDoSistema implements IHotel {
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
	
	@Override
	public void atualizaCadastro(String id, String valor, String info) throws Exception {
		
			controleHotel.atualizaCadastro(id, valor, info);
		

	}

	@Override
	public String getInfoHospede(String info, String id) throws Exception {

		return controleHotel.getInfoHospede(info, id);

	}

	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento)	throws Exception {
		return controleHotel.cadastraHospede(nome, email, dataNascimento);
	}

	@Override
	public void removeHospede(String email) {

		try {
			controleHotel.removeHospede(email);
		} catch (StringInvalidaException e) {
			Assert.fail("Nao foi possivel remover o hospede.");
		}

	}

	@Override
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto)throws Exception {
		
			controleHotel.realizaCheckin(email, quantDias, IDQuarto, tipoQuarto);
		
		
	}

	@Override
	public String realizaCheckout(String email, String IDQuarto) throws Exception {
		return controleHotel.realizaCheckout(email, IDQuarto);
	}

	@Override
	public String getInfoHospedagem(String email, String atributo) throws Exception {
		return controleHotel.getInfoHospedagem(email, atributo);
	}

	@Override
	public String consultaTransacoes(String atributo) throws Exception {
		return controleHotel.consultaTransacoes(atributo);
	}

	@Override
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		return controleHotel.consultaTransacoes(atributo, indice);
	}

	@Override
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws Exception {
		controleRestaurante.cadastraPrato(nomePrato, precoPrato, descricaoPrato);
		
	}

	@Override
	public String consultaRestaurante(String chaveNome, String atributo) throws Exception {
		return controleRestaurante.consultaRestaurante(chaveNome, atributo);
	}

	@Override
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws Exception {
		controleRestaurante.cadastraRefeicao(nomeRef, descricaoRef, componentes);
	}

}
