/**
 * 
 */
package hotelManagementSystem;

import easyaccept.EasyAccept;
import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;

/**
 * Classe Hotel Facade que delega funcoes para o controller de Hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

// ********** COLOCAR TRY/CATCH ****************
public class SystemFacade {
	private SystemController controller;
	
	public SystemFacade(){
		this.controller = new SystemController();
	}
	
	/**
	 * @param info
	 * @param valor
	 * @param id
	 * @throws StringInvalidaException
	 */
	public void atualizaCadastro(String info, String valor, String id) throws StringInvalidaException {
		controller.atualizaCadastro(info, valor, id);
	}

	/**
	 * 
	 * @param info
	 * @param id
	 * @return string
	 * @throws StringInvalidaException
	 */
	public String getInfoHospede(String info, String id) throws StringInvalidaException {
		return controller.getInfoHospede(info, id);
	}

	/**
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @return String
	 * @throws CadastroInvalidoException
	 * @throws StringInvalidaException 
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException {
		return controller.cadastraHospede( nome, email, dataNascimento);
	}

	/**
	 * 
	 * @param email
	 * @throws RemocaoInvalidaException
	 */
	public void removeHospede(String email) throws RemocaoInvalidaException {
		controller.removeHospede(email);
		
	}
	
	public static void main(String[] args) {
	    args = new String[] {"gerenciaHotel.HotelFacade", "testes/easy/testes_uc1.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
	
}
