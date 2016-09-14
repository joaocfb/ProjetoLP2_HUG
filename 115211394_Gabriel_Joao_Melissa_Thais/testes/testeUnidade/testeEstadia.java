package testeUnidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.StringInvalidaException;
import hotel.Estadia;

public class testeEstadia {

	@Before
	public void setUp() throws StringInvalidaException {
		Estadia estadia1 = new Estadia("A1", 2);
		Estadia estadia2 = new Estadia("2B", 5);
	}

	@Test
	public void testEstadia() {
		try {
			Estadia estadia3 = new Estadia("", 2);
			fail("Deveria lancar excecao.");
		} catch (StringInvalidaException msg) {
			assertEquals("Parametro invalido.", msg.getMessage());
		}
		
		try {
			Estadia estadia4 = new Estadia("2C", -5);
		} catch (StringInvalidaException msg) {
			assertEquals("Parametro invalido.", msg.getMessage());
		}
	}
	
	@Test
	public void testGets() throws StringInvalidaException {
		Estadia estadia5 = new Estadia("2C", 2);
		Estadia estadia6 = new Estadia("5B", 6);
		
		assertEquals("2C", estadia5.getIDQuarto());
		assertEquals("5B", estadia6.getIDQuarto());
		
		assertEquals(2, estadia5.getQuantDias());
		assertEquals(6, estadia6.getQuantDias());
	}

}
