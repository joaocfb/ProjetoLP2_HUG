/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import exception.StringInvalidaException;
import factorys.FactoryHospedes;
import hotel.Hospede;
import hotel.Hotel;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class HotelTest {
	
	private Hotel hotel;
	private HashMap<String, Hospede> meusHospedes;
	private FactoryHospedes factoryHospedes;

	@Before
	public void setUp() {
		
		hotel = new Hotel();

		
		this.meusHospedes = new HashMap<String, Hospede>();
		this.factoryHospedes = new FactoryHospedes();
		
		try {
			hotel.cadastraHospede("hektor farias", "hektor_farias.br", "22/02/1996");
			hotel.cadastraHospede("Hynghrid farias", "hyn_farias.br", "20/09/1999");
			
			hotel.cadastraHospede("Kim Kardashian", "soudiva_kardashian.eua", "21/10/1980");
			hotel.cadastraHospede("Taylor Swift", "loveme_taylor.eua", "13/12/1989");
			
			hotel.cadastraHospede("Beyoncé Giselle", "bey_lemonade2016.eua", "04/09/1981");
			hotel.cadastraHospede("Rihanna Fenty", "thebest_riri.eua", "20/02/1988");
			hotel.cadastraHospede("Ariana Grande", "mepasso_ariana.eua", "26/06/1993");
			
			hotel.cadastraHospede("Drake Graham", "drake_mycellphone.eua", "25/10/1986");
			
		} catch (Exception e) {
		}
		
	}
	
	@Test
	public void testCadastraHospede() {

		try {
			assertEquals("andre_lindo.br",hotel.cadastraHospede("Andre Andrade", "andre_lindo.br", "25/10/1996"));
		} catch (Exception e) {
			
		}
	}
	 
	@Test
	public void testAtualizaCadastro() throws Exception {
		
		// testando o atualizaCadastro pelo nome
		try {
			hotel.cadastraHospede("Isabelly Araujo", "isa_araujo@br", "02/12/1995");

			hotel.atualizaCadastro("isa_araujo.br", "nome", "Isabelly Carla de Araujo");	
			assertEquals("Isabelly Carla de Araujo",hotel.getInfoHospede("isa_araujo.br", "nome"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}
		
		// testando o atualizaCadastro pela data de nascimento
		try {	
			hotel.atualizaCadastro("hektor_farias.br", "data de nascimento", "23/02/1996");
			assertEquals("23/02/1996", hotel.getInfoHospede("hektor_farias.br", "data de nascimento"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}
		
		// testando o atualizaCadastro pelo email
		try {	
			hotel.atualizaCadastro("hyn_farias.br", "email", "hyn_farias.com");
			assertEquals("Hynghrid farias", hotel.getInfoHospede("hyn_farias.com", "nome"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}
	}
	
	@Test
	public void testRemoveHospede() throws Exception{
		
		try {
			
			hotel.removeHospede("soudiva_kardashian.eua");
			assertEquals("soudiva_kardashian.eua",hotel.getInfoHospede("soudiva_kardashian.eua", "email"));
			fail("excecao nao capturada");
			
		} catch (StringInvalidaException e) {
		
		}
	}
	
	@Test
	public void testGetInfoHospede() throws Exception{
		
		// testando o getInfoHospede pelo nome
		try {
			assertEquals("Taylor Swift",hotel.getInfoHospede("loveme_taylor.eua", "nome"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}
		
		// testando o getInfoHospede pelo email
		try {
			assertEquals("loveme_taylor.eua",hotel.getInfoHospede("loveme_taylor.eua", "email"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}

		// testando o getInfoHospede pela data de nascimento
		try {
			assertEquals("13/12/1989",hotel.getInfoHospede("loveme_taylor.eua", "data de nascimento"));
		} catch (StringInvalidaException e) {
			Assert.fail("excecao nao esperada");
		}
		
	}
	
	@Test
	public void testRealizaCheckin(){
		
		// com quarto do tipo presidencial
		try {
			hotel.realizaCheckin("bey_lemonade2016.eua", 5, "3A", "Presidencial");
			assertEquals("3A", hotel.getInfoHospedagem("bey_lemonade2016.eua", "quarto"));
		} catch (Exception e) {
			
		}
		
		// com quarto do tipo luxo
		try {
			hotel.realizaCheckin("thebest_riri.eua", 4, "3B", "Luxo");
			assertEquals("3B", hotel.getInfoHospedagem("thebest_riri.eua", "quarto"));
		} catch (Exception e) {
			Assert.fail("excecao nao esperada");
		}
		
		// com quarto do tipo simples
		try {
			hotel.realizaCheckin("mepasso_ariana.eua", 4, "12A", "Simples");
			assertEquals("12A", hotel.getInfoHospedagem("mepasso_ariana.eua", "quarto"));
		} catch (Exception e) {
			Assert.fail("excecao nao esperada");		
		}
	}
	
	@Test
	public void testRealizaCheckout(){
		
		try {
			hotel.realizaCheckin("drake_mycellphone.eua",  4, "4B", "Luxo");
			assertEquals("4B", hotel.getInfoHospedagem("drake_mycellphone.eua", "quarto"));
		} catch (Exception e1) {
			Assert.fail("excecao nao esperada");
		}
		
		try {
			hotel.realizaCheckout("drake_mycellphone.eua","4B");
			assertEquals("4B", hotel.getInfoHospedagem("drake_mycellphone.eua", "quarto"));
			fail("excecao nao capturada");	
		} catch (Exception e) {
		
		}
		
	}
}
