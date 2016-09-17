/**
 * 
 */
package sistemaDeControleHotel;

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
public class Facada{
	private ControleDoSistema controller;
	
	public Facada() throws Exception{
		this.controller = new ControleDoSistema();
	}
	
	/**
	 * @param info
	 * @param valor
	 * @param id
	 * @throws StringInvalidaException
	 */
	
	public void iniciaSistema() {
		controller.iniciaSistema();
	}
	
	public void fechaSistema() {
		controller.fechaSistema();
	}
	
	public void atualizaCadastro(String id, String valor, String info) throws StringInvalidaException {
		controller.atualizaCadastro(id, valor, info);
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
	 * @throws TestesHospedeException 
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException {
		return controller.cadastraHospede( nome, email, dataNascimento);
	}

	/**
	 * 
	 * @param email
	 * @throws RemocaoInvalidaException
	 */
	public void removeHospede(String email) throws StringInvalidaException {
		controller.removeHospede(email);
		
	}
	
	public static void main(String[] args) {
	    args = new String[] {"sistemaDeControleHotel.Facada", "testes/easy/testes_uc1.txt", "testes/easy/testes_uc2.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception {
		controller.realizaCheckin(email, quantDias, IDQuarto, tipoQuarto);
		
	}

	public void realizaCheckout(String email, String IDQuarto) {
		controller.realizaCheckout(email, IDQuarto);
		
	}

	public String getInfoHospedagem(String email, String atributo) throws Exception {
		return controller.getInfoHospedagem(email, atributo);
	}
	
}
