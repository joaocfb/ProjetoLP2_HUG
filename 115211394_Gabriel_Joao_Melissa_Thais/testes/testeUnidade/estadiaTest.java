package testeUnidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.StringInvalidaException;
import hotel.Estadia;

public class estadiaTest {
	
	private Estadia estadiaOne;
	private Estadia estadiaTwo;
	private Estadia estadiaThree;
	private Estadia estadiaFour;
	
	
	@Before
	public void setUp() throws StringInvalidaException {
		estadiaOne = new Estadia("A1", 2);
		estadiaTwo = new Estadia("2B", 5);
		estadiaThree = new Estadia("3C", 7);
		estadiaFour = new Estadia("4D", 9);
	}

	@Test
	public void testEstadia() {
		
		// testando string IDQuarto vazio ou null
		
		try {
			estadiaOne = new Estadia(" ", 2);
			fail("Lancamento de exception com ID do quarto invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("ID do quarto nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		try {
			estadiaTwo = new Estadia(null, 5);
			fail("Lancamento de exception com ID do quarto invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("ID do quarto nao pode ser nulo ou vazio.", msg.getMessage());
		}
		
		// testando int quantDias menor ou igual a zero
		
		try {
			estadiaThree = new Estadia("3C", -7);
			fail("Lancamento de exception com quantidade de dias invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("quantidade de dias nao pode ser menor ou igual a zero.", msg.getMessage());
		}
		
		try {
			estadiaFour = new Estadia("4D", 0);
			fail("Lancamento de exception com quantidade de dias invalido");
		} catch (StringInvalidaException msg) {
			assertEquals("quantidade de dias nao pode ser menor ou igual a zero.", msg.getMessage());
		}
	}
	
	@Test
	public void testGets() throws StringInvalidaException {
		
		Estadia estadiaFive = new Estadia("5E", 11);
		Estadia estadiaSix = new Estadia("6F", 13);
		
		assertEquals("5E", estadiaFive.getIDQuarto());
		assertEquals("6F", estadiaSix.getIDQuarto());
		
		assertEquals(11, estadiaFive.getQuantDias());
		assertEquals(13, estadiaSix.getQuantDias());
	}

}
