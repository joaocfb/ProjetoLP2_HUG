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
	

	public void atualizaCadastro(String id, String valor, String info)throws Exception;
		
	public String getInfoHospede(String info, String id) throws Exception;
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroInvalidoException, StringInvalidaException, Exception;
	
	public void removeHospede(String email) throws StringInvalidaException;
		
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws Exception;
	
	public String realizaCheckout(String email, String IDQuarto) throws Exception;
	
	public String getInfoHospedagem(String email, String atributo) throws Exception;

	public String consultaTransacoes(String atributo)throws Exception;
	
	public String consultaTransacoes(String atributo, int indice)throws Exception;
	
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)throws Exception;

	public String consultaRestaurante(String chaveNome, String atributo) throws Exception;

	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws Exception;

}
