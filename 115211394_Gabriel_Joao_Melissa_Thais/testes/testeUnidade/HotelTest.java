/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hotel.Hotel;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HotelTest {
	private Hotel hotel1, hotel2, hotel3;
	
	
	
	@Test
	public void testHotel() throws Exception {
		hotel1 = new Hotel();
		assertEquals("paulocg@ufcg.br", hotel1.cadastraHospede("Paulo", "paulocg@ufcg.br", "15/4/1991"));
		//hotel1.realizaCheckin("Paulo Ramos", "1S", 2);
		assertEquals("15/4/1991", hotel1.getInfoHospede("paulocg@ufcg.br", "Data de Nascimento"));
		assertEquals("Paulo Ramos", hotel1.getInfoHospede("paulocg@ufcg.br", "Nome"));
		//sassertEquals(300.00, hotel1.checkout("paulocg@ufcg.br", "1S"), 0.001);
	}
/*
	*//**
	 * Test method for {@link hotel.Hotel#atualizaCadastro(java.lang.String, java.lang.String, java.lang.String)}.
	 *//*
	@Test
	public void testAtualizaCadastro() {
		fail("Not yet implemented");
	}

	*//**
	 * Test method for {@link hotel.Hotel#getInfoHospede(java.lang.String, java.lang.String)}.
	 *//*
	@Test
	public void testGetInfoHospede() {
		fail("Not yet implemented");
	}

	*//**
	 * Test method for {@link hotel.Hotel#cadastraHospede(java.lang.String, java.lang.String, java.lang.String)}.
	 *//*
	@Test
	public void testCadastraHospede() {
		fail("Not yet implemented");
	}

	*//**
	 * Test method for {@link hotel.Hotel#removeHospede(java.lang.String)}.
	 *//*
	@Test
	public void testRemoveHospede() {
		fail("Not yet implemented");
	}
*/
}
