/**
 * 
 */
package interfaces;

import exception.BuscaHospedeException;
import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import hotel.Hospede;

/**
 * @author melissadg
 *
 */
public interface IHotel {
	
	public void atualizaCadastro(String info, String valor, String id)throws StringInvalidaException;
		
	public String getInfoHospede(String info, String id) throws StringInvalidaException;
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException;
	
	public void removeHospede(String email) throws RemocaoInvalidaException;
		
		
}
