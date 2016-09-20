package testeUnidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.StringInvalidaException;
import hotel.Estadia;

public class EstadiaTest {
	
	private Estadia estadia1;
	private Estadia estadia2;
	private Estadia estadia3;
	private Estadia estadia4;
	
	
	@Before
	public void setUp() throws Exception {
		
		try {
			estadia1 = new Estadia("A1", 2);
			estadia2 = new Estadia("2B", 5);
			estadia3 = new Estadia("3C", 7);
			estadia4 = new Estadia("4D", 9);
		} catch (StringInvalidaException e) {
			
		}
	}

	@Test
	public void testEstadia() throws Exception {
		
		// testando string IDQuarto vazio ou null
		
		try {
			estadia1 = new Estadia(" ", 2);
			fail("Lancamento de exception com ID do quarto invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("ID do quarto nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
			estadia2 = new Estadia(null, 5);
			fail("Lancamento de exception com ID do quarto invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("ID do quarto nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando int quantDias menor ou igual a zero
		
		try {
			estadia3 = new Estadia("3C", -7);
			fail("Lancamento de exception com quantidade de dias invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("quantidade de dias nao pode ser menor ou igual a zero.", msg.getMessage());
		}
		
		try {
			estadia4 = new Estadia("4D", 0);
			fail("Lancamento de exception com quantidade de dias invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("quantidade de dias nao pode ser menor ou igual a zero.", msg.getMessage());
		}
	}
	
	@Test
	public void testGets() throws Exception {
		
		try {
			Estadia estadia5 = new Estadia("5E", 11);
			Estadia estadia6 = new Estadia("6F", 13);
			
			assertEquals("5E", estadia5.getIDQuarto());
			assertEquals("6F", estadia6.getIDQuarto());
			
			assertEquals(11, estadia5.getQuantDias());
			assertEquals(13, estadia6.getQuantDias());
			
		} catch (StringInvalidaException e) {
			
		}
		
		

	}

}
