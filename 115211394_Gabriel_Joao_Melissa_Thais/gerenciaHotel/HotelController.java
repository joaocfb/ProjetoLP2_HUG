package gerenciaHotel;

import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import hotel.Hotel;
import interfaces.IHotel;

/**
 * Classe que controla as funcionalidades do hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HotelController implements IHotel{
	private Hotel controleHotel;

	@Override
	public void atualizaCadastro(String info, String valor, String id) throws StringInvalidaException {
		try {
			controleHotel.atualizaCadastro(info, valor, id);
		} catch (StringInvalidaException msg) {
			msg.getMessage();
		}
		
	}

	@Override
	public String getInfoHospede(String info, String id) throws StringInvalidaException {
		try {
			return controleHotel.getInfoHospede(info, id);
		} catch (StringInvalidaException msg) {
			return msg.getMessage();
		}
	}

	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException {
		try {
			return controleHotel.cadastraHospede(nome, email, dataNascimento);
		} catch (CadastroInvalidoException msg) {
			return msg.getMessage();
		}
	}

	@Override
	public void removeHospede(String email) throws RemocaoInvalidaException {
		try {
			controleHotel.removeHospede(email);
		} catch (RemocaoInvalidaException msg) {
			msg.getMessage();
		}
		
	}
		
}


