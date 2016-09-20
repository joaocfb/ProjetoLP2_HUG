/**
 * 
 */
package sistemaDeControleHotel;

import easyaccept.EasyAccept;
import exception.CadastroInvalidoException;
import exception.RemocaoInvalidaException;
import exception.StringInvalidaException;
import interfaces.IHotel;

/**
 * Classe Hotel Facade que delega funcoes para o controller de Hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

// ********** COLOCAR TRY/CATCH ****************
public class Fachada {
	
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
	
	public void atualizaCadastro(String id, String valor, String info) throws Exception {
		controller.atualizaCadastro(id, valor, info);
	}

	public String getInfoHospede(String info, String id) throws Exception {
		return controller.getInfoHospede(info, id);
	}


	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		return controller.cadastraHospede( nome, email, dataNascimento);
	}

	public static void main(String[] args) {
		//, "testes/easy/testes_uc3.txt", "testes/easy/testes_uc4.txt", "testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc4_exception.txt"
	    args = new String[] {"sistemaDeControleHotel.Fachada", "testes/easy/testes_uc1.txt","testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc2.txt","testes/easy/testes_uc2_exception.txt", "testes/easy/testes_uc3.txt", "testes/easy/testes_uc3_exception.txt",}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
	
	public void removeHospede(String email) throws Exception {
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

	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws Exception {
		controller.cadastraPrato(nomePrato, precoPrato, descricaoPrato);
	}
	
	public String consultaRestaurante(String chaveNome, String atributo) throws Exception {
		return controller.consultaRestaurante(chaveNome, atributo);
	}
	
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws Exception {
		controller.cadastraRefeicao(nomeRef, descricaoRef, componentes);
	}
}
