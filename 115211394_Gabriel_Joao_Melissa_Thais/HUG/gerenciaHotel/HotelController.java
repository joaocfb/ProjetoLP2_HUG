package gerenciaHotel;

import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import hotel.Hotel;
import interfaces.IHotel;

/**
 * Classe que controla as funcionalidades do hotel
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HotelController implements IHotel {
	private Hotel controleHotel;

	public HotelController() {
		this.controleHotel = new Hotel();
	}

	@Override
	public void atualizaCadastro(String info, String valor, String id) throws StringInvalidaException {
		controleHotel.atualizaCadastro(info, valor, id);

	}

	@Override
	public String getInfoHospede(String info, String id) throws StringInvalidaException {

		return controleHotel.getInfoHospede(info, id);

	}

	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws CadastroInvalidoException, StringInvalidaException {
		return controleHotel.cadastraHospede(nome, email, dataNascimento);
	}

	@Override
	public void removeHospede(String email) throws RemocaoInvalidaException {

		controleHotel.removeHospede(email);

	}

}
