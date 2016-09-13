/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.StringInvalidaException;
import hotel.Hospede;

/**
 * @author melissadg
 *
 */
public class testeHospede {

	/**
	 * 
	 * @throws StringInvalidaException 
	 */
	
	@Before
	public void setUp() throws StringInvalidaException {
		Hospede hospede1 = new Hospede("Sebas Lemos", "sebas_lemos.br", "12/12/1992"); 
		Hospede hospede2 = new Hospede("Patricia Machado", "teoria.graos@phdnafranca.com.br", "31/10/1900");
	}
	
	@Test
	public void testHospede() throws StringInvalidaException {
		Hospede hospede3, hospede4;
		
		try {
			hospede3 = new Hospede("", "sven@sverige.se", "03/10/1997");
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
		
	}

}
