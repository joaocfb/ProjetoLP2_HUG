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
public class Fachada{
	
	private ControleDoSistema controller;
	
	public Fachada() throws Exception{
		this.controller = new ControleDoSistema();
	}
	
	public void iniciaSistema() {
		controller.iniciaSistema();
	}
	
	public void fechaSistema() {
		controller.fechaSistema();
	}
	
	public void atualizaCadastro(String id, String valor, String info) throws StringInvalidaException {
		controller.atualizaCadastro(id, valor, info);
	}

	public String getInfoHospede(String info, String id) throws StringInvalidaException {
		return controller.getInfoHospede(info, id);
	}


	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		return controller.cadastraHospede( nome, email, dataNascimento);
	}

	public static void main(String[] args) {
	    args = new String[] {"sistemaDeControleHotel.Fachada", "testes/easy/testes_uc1.txt", "testes/easy/testes_uc2.txt", "testes/easy/testes_uc3.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
	
	public void removeHospede(String email) throws StringInvalidaException {
		controller.removeHospede(email);
		
	}

	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception {
		controller.realizaCheckin(email, quantDias, IDQuarto, tipoQuarto);
		
	}

	public String realizaCheckout(String email, String IDQuarto) throws Exception {
		return controller.realizaCheckout(email, IDQuarto);
		
	}

	public String getInfoHospedagem(String email, String atributo) throws Exception {
		return controller.getInfoHospedagem(email, atributo);
	}
	
	public String consultaTransacoes(String atributo) throws Exception {
		return controller.consultaTransacoes(atributo);
	}
	
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		return controller.consultaTransacoes(atributo, indice);
	}
}
