/**
 * 
 */
package interfaces;

import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import exception.TestesHospedeException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface IHotel {
	
	public void atualizaCadastro(String info, String valor, String id)throws StringInvalidaException;
		
	public String getInfoHospede(String info, String id) throws StringInvalidaException;
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException, TestesHospedeException;
	
	public void removeHospede(String email) throws RemocaoInvalidaException;
		
		
}
