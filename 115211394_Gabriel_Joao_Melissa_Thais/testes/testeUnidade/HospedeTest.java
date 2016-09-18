/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import hotel.Hospede;

import org.junit.Before;
import org.junit.Test;

import exception.StringInvalidaException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HospedeTest {
	
	private Hospede hospedeFour;
	private Hospede hospedeFive;
	
	
	/**
	 * 
	 * @throws Exception 
	 */
	
	@Before
	public void setUp() throws StringInvalidaException  {
	
		hospedeFour = new Hospede("Pamela Nicole", "pamy_beautiful.br", "15/12/1995");
		hospedeFive= new Hospede("Lucas Lucco", "lucaxx_lucco.br","04/04/1991");
		
	}
	
	@Test
	public void testCriaHospede() throws Exception {
		
		Hospede hospedeOne = new Hospede("Sebas Lemos", "sebas_lemos.br", "12/12/1992");
		Hospede hospedeTwo = new Hospede("Patricia Machado", "teoria.graos@phdnafranca.com.br", "31/10/1900");
		Hospede hospedeThree = new Hospede("Luan Santana", "luan_santana.br", "13/03/1991");
		
		assertEquals(hospedeOne.getNome(), "Sebas Lemos");
		assertEquals(hospedeTwo.getEmail(), "teoria.graos@phdnafranca.com.br");
		assertEquals(hospedeThree.getDataNascimento(),"13/03/1991" );
		
	}
	
	//TESTAR EQUALS
	
	@Test
	public void testandoConstrutorWithException() throws StringInvalidaException {
		
		// testando string nome vazio ou null
		
		
		try {
				hospedeFour = new Hospede(" ", "pamy_beautiful.br", "15/12/1995");
				fail("Lancamento de exception com nome do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Nome do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeFive = new Hospede(null, "lucaxx_lucco.br","04/04/1991");
				fail("Lancamento de exception com nome do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Nome do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando string email vazio ou null
		try {
				hospedeFour = new Hospede("Pamela Nicole", " ", "15/12/1995");
				fail("Lancamento de exception com email do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Email do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeFive = new Hospede("Lucas Lucco", null ,"04/04/1991");
				fail("Lancamento de exception com email do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Email do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando string dataNascimento vazio ou null
		try {
				hospedeFour = new Hospede("Pamela Nicole", "pamy_beautiful.br", " ");
				fail("Lancamento de exception com data de nascimento do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Data de Nascimento do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
				hospedeFive = new Hospede("Lucas Lucco", "lucaxx_lucco.br", null);
				fail("Lancamento de exception com data de nascimento do hospede invalido");
		} catch (StringInvalidaException msg) {
				assertEquals("Data de Nascimento do hospede nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
	}
}
