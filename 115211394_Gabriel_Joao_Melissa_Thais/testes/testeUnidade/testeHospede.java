/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.*;
import hotel.Hotel;
import org.junit.Before;
import org.junit.Test;

import exception.CadastroInvalidoException;
import exception.StringInvalidaException;
import gerenciaHotel.HotelController;
import hotel.Hospede;

/**
 * @author melissadg
 *
 */
public class testeHospede {
	private HotelController controle;
	private Hotel hotel;
	/**
	 * 
	 * @throws StringInvalidaException 
	 */
	
	@Before
	public void setUp() throws StringInvalidaException {
		Hospede hospede1 = new Hospede("Sebas Lemos", "sebas_lemos.br", "12/12/1992"); 
		Hospede hospede2 = new Hospede("Patricia Machado", "teoria.graos@phdnafranca.com.br", "31/10/1900");
	}
	
	/**
	 * Testa a criacao do hospede com valores invalidos
	 * @throws StringInvalidaException
	 */
	@Test
	public void testCriaHospede() throws StringInvalidaException {
		Hospede hospede3, hospede4;
		
		try {
			hospede3 = new Hospede("", "sven@sverige.se", "03/10/1997");
			fail("Deveria lancar excecao");
		} catch (StringInvalidaException e) {
			assertEquals("Parametro invalido.", e.getMessage());
		}
		
		try {
			hospede3 = new Hospede(null, "sven@sverige.se", "03/10/1997");
			fail("Deveria lancar excecao");
		} catch (StringInvalidaException e) {
			assertEquals("Parametro invalido.", e.getMessage());
		}
	
		try {
			hospede4 = new Hospede("Agnetha Faltskog", "", "25/01/2001");
			fail("Deveria lancar excecao");
		} catch (StringInvalidaException e) {
			assertEquals("Parametro invalido.", e.getMessage());
		}
		
		try {
			hospede4 = new Hospede("Agnetha Faltskog", null, "25/01/2001");
			fail("Deveria lancar excecao");
		} catch (StringInvalidaException e) {
			assertEquals("Parametro invalido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testAdicionaHospede() throws CadastroInvalidoException, StringInvalidaException{
		assertEquals("meelissa", controle.cadastraHospede("Melissa", "meelissa", "01/10/1992"));

	}

}
