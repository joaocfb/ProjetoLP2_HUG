/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.Serializable;

import hotel.Hospede;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.VerificaNuloEVazioException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HospedeTest implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Hospede hospedePamela;
	private Hospede hospedeLucas;
	private Hospede hospedeJustin;
	private Hospede hospedeJBieber;
	
	
	/**
	 * 
	 * @throws Exception 
	 */
	
	@Before
	public void setUp()  {
	
		try {
			hospedePamela = new Hospede("Pamela Nicole", "pamy@beautiful.br", "15/12/1995");
			hospedeLucas = new Hospede("Lucas Lucco", "lucaxx@lucco.br","04/04/1991");
			
		} catch (VerificaNuloEVazioException e) {
			
		}
		
	}
	
	@Test
	public void testCriaHospede() {
		
		
		try {
			Hospede hospedeSebas = new Hospede("Sebas Lemos", "sebas@lemos.br", "12/12/1992");
			Hospede hospedePatricia = new Hospede("Patricia Machado", "teoriagraos@phdnafranca.com.br", "31/10/1900");
			Hospede hospedeLuan = new Hospede("Luan Santana", "luan@santana.br", "13/03/1991");
			
			assertEquals(hospedeSebas.getNome(), "Sebas Lemos");
			assertEquals(hospedePatricia.getEmail(), "teoriagraos@phdnafranca.com.br");
			assertEquals(hospedeLuan.getDataNascimento(),"13/03/1991" );
		} catch (VerificaNuloEVazioException e) {
		}
		
		
	}
	
	@Test
	public void testandoConstrutorWithException() {
		
		// testando string nome vazio ou null
		
		
		try {
				hospedePamela = new Hospede(" ", "pamy@beautiful.br", "15/12/1995");
				fail("Lancamento de exception com nome do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Nome do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeLucas = new Hospede(null, "lucaxx@lucco.br","04/04/1991");
				fail("Lancamento de exception com nome do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Nome do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando string email vazio ou null
		try {
			 	hospedePamela = new Hospede("Pamela Nicole", " ", "15/12/1995");
				fail("Lancamento de exception com email do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Email do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeLucas = new Hospede("Lucas Lucco", null ,"04/04/1991");
				fail("Lancamento de exception com email do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Email do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando string dataNascimento vazio ou null
		try {
				hospedePamela = new Hospede("Pamela Nicole","pamy@beautiful.br", " ");
				fail("Lancamento de exception com data de nascimento do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Data de Nascimento do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeLucas = new Hospede("Lucas Lucco", "lucaxx@lucco.br", null);
				fail("Lancamento de exception com data de nascimento do hospede invalido");
		} catch (VerificaNuloEVazioException msg) {
				assertEquals("Data de Nascimento do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
	}
	
	@Test
	public void testEquals(){
		
		
		try {
			hospedeJustin = new Hospede("Justin Drew","sorry@baby.or", "01/03/1994");
			hospedeJBieber = new Hospede("Justin Bieber","sorry@baby.or", "01/03/1994");
			
			assertEquals(hospedeJustin.getEmail(), hospedeJBieber.getEmail());
			Assert.assertNotEquals(hospedePamela.getEmail(), hospedeJustin.getEmail());
		} catch (VerificaNuloEVazioException e) {
		}
		
		equals(hospedeJustin.equals(hospedeJBieber));
	}
	
	
	
}