/**
 * 
 */
package interfaces;

import exception.AtualizacaoInvalidaException;
import exception.CadastroHospedeInvalidoException;
import exception.CheckinInvalidoException;
import exception.CheckoutInvalidoException;
import exception.ConsultaHospedagemInvalidaException;
import exception.ConsultaHospedeInvalidaException;
import exception.CriacaoQuartoInvalidoException;
import exception.HospedagemAtivaInvalidaException;
import exception.IndiceInvalidoException;
import exception.MensagemErroException;
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface IHotel {
	
	// ## Hotel ##
	
	// Hospede
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws CadastroHospedeInvalidoException, VerificaNuloEVazioException;
	
	public void atualizaCadastro(String id, String valor, String info) throws AtualizacaoInvalidaException;
		
	public String getInfoHospede(String info, String id) throws ConsultaHospedeInvalidaException;
	
	public void removeHospede(String email) throws ConsultaHospedeInvalidaException, RemocaoInvalidaException;
	
	// Estadia
	public void realizaCheckin(String email, int quantDias, String IDQuarto, String tipoQuarto) throws CheckinInvalidoException, CriacaoQuartoInvalidoException, VerificaNuloEVazioException;
	
	public String realizaCheckout(String email, String IDQuarto) throws CheckoutInvalidoException, ConsultaHospedagemInvalidaException;
	
	public String getInfoHospedagem(String email, String atributo) throws HospedagemAtivaInvalidaException, MensagemErroException, ConsultaHospedagemInvalidaException;

	public String consultaTransacoes(String atributo) throws MensagemErroException;
	
	public String consultaTransacoes(String atributo, int indice) throws MensagemErroException, IndiceInvalidoException;

}
