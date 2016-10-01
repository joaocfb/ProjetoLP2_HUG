package factorys;

import exception.CadastroHospedeInvalidoException;
import exception.VerificaNuloEVazioException;
import hotel.Hospede;
import valida.VerificaHospede;

/**
 * Fabrica de hospede
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 */
public class FactoryHospedes {
	
	/**
	 * Cria um hospede
	 * 
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @return Um novo Hospede
	 * @throws VerificaNuloEVazioException 
	 * @throws TestesHospedeException
	 */
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws CadastroHospedeInvalidoException, VerificaNuloEVazioException {
		
		//testes
		VerificaHospede.verificaNomevazio(nome);
		VerificaHospede.verificaEmailInvalido(email);
		VerificaHospede.verificaNascimentoVazio(dataNascimento);
		VerificaHospede.verificaIdadeInvalido(dataNascimento);
		VerificaHospede.verificaIdadeInvalido(dataNascimento);

		return new Hospede(nome, email, dataNascimento);
	}
	
}

