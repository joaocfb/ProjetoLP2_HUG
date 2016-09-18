package sistemaDeControleHotel;

import hotel.Hotel;
import interfaces.IHotel;
import exception.CadastroInvalidoException;
import exception.StringInvalidaException;

/**
 * Classe que controla as funcionalidades do hotel
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class ControleDoSistema implements IHotel {
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
	
	@Override
	public void atualizaCadastro(String id, String valor, String info) throws StringInvalidaException {
		controleHotel.atualizaCadastro(id, valor, info);

	}

	@Override
	public String getInfoHospede(String info, String id) throws StringInvalidaException {

		return controleHotel.getInfoHospede(info, id);

	}

	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento)	throws Exception {
		return controleHotel.cadastraHospede(nome, email, dataNascimento);
	}

	@Override
	public void removeHospede(String email) throws StringInvalidaException {

		controleHotel.removeHospede(email);

	}

	@Override
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception {
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

}
