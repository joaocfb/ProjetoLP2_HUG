package factorys;

import exception.CadastroHospedeInvalidoException;
import exception.VerificaNuloEVazioException;
import hotel.Hospede;
import validaHospede.VerificaData;
import validaHospede.VerificaEmail;
import validaHospede.VerificaNome;

/**
 * Fabrica de hospede
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryHospedes {
	
	/**
	 * Cria um hospede
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @return
	 * @throws VerificaNuloEVazioException 
	 * @throws Exception
	 * @throws TestesHospedeException
	 */
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {
		
		VerificaNome.verificaNomevazio(nome);
		VerificaEmail.verificaEmailInvalido(email);
		VerificaData.verificaNascimentoVazio(dataNascimento);
		VerificaData.verificaIdadeInvalido(dataNascimento);
		VerificaData.verificaIdadeInvalido(dataNascimento);

		return new Hospede(nome, email, dataNascimento);
	}
	
}

