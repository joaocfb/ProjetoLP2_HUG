package gerenciaHotel;

import exception.BuscaHospedeException;
import exception.StringInvalidaException;
import hotel.Hospede;
import interfaces.IHotel;

public class HotelController implements IHotel{

	@Override
	public void atualizaCadastro(String info, String valor, String id) throws StringInvalidaException {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public String getInfoHospede(String info, String id) throws StringInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cadastraHospede(String nome, String email, String dataNascimento) throws StringInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeHospede(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hospede retornaHospede(String email) throws BuscaHospedeException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		
}


