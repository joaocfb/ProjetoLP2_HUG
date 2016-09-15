/**
 * 
 */
package interfaces;

import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface IHotel {
	
	public void atualizaCadastro(String id, String valor, String info)throws StringInvalidaException;
		
	public String getInfoHospede(String info, String id) throws StringInvalidaException;
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException;
	
	public void removeHospede(String email) throws StringInvalidaException;
		
		
}
