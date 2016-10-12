/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.Serializable;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import exception.AtualizacaoInvalidaException;
import exception.CadastroHospedeInvalidoException;
import exception.CheckinInvalidoException;
import exception.CheckoutInvalidoException;
import exception.ConsultaHospedagemInvalidaException;
import exception.ConsultaHospedeInvalidaException;
import exception.CriacaoQuartoInvalidoException;
import exception.HospedagemAtivaInvalidaException;
import exception.IndiceInvalidoException;
import exception.MensagemErroException;
import exception.RemocaoInvalidaException;
import exception.VerificaNuloEVazioException;
import factorys.FactoryHospedes;
import hotel.Hospede;
import hotel.Hotel;


/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class HotelTest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	private HashMap<String, Hospede> meusHospedes;
	private FactoryHospedes factoryHospedes;
	
	private RestauranteTest restaurante;

	@Before
	public void setUp() {
		
		try {
			hotel = new Hotel();
		} catch (Exception e1) {
		
		}
		
		this.meusHospedes = new HashMap<String, Hospede>();
		this.factoryHospedes = new FactoryHospedes();
		
		try {
			
			hotel.cadastraHospede("Kim Kardashian", "soudiva@kardashian.eua", "21/10/1980");
			hotel.cadastraHospede("Taylor Swift", "loveme@taylor.eua", "13/12/1989");
			
			hotel.cadastraHospede("Beyoncé Giselle", "bey@lemonade2016.eua", "04/09/1981");
			hotel.cadastraHospede("Rihanna Fenty", "thebest@riri.eua", "20/02/1988");
			hotel.cadastraHospede("Ariana Grande", "mepasso@ariana.eua", "26/06/1993");
			
			hotel.cadastraHospede("Drake Graham", "drake@mycellphone.eua", "25/10/1986");
			
		} catch (Exception e) {
		}
	}
	
	// testes do crud do hospede
	
	@Test
	public void testCadastraHospede() {

		try {
			assertEquals("andre@lindo.br",hotel.cadastraHospede("Andre Andrade", "andre@lindo.br", "25/10/1996"));
		} catch (CadastroHospedeInvalidoException | VerificaNuloEVazioException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testAtualizaCadastro() {
		
		// testando o atualizaCadastro pelo nome
		
		try {
			hotel.cadastraHospede("Isabelly Araujo", "isa@araujo.br", "02/12/1995");
			
			hotel.atualizaCadastro("isa@araujo.br", "nome", "Isabelly Carla de Araujo");	
			assertEquals("Isabelly Carla de Araujo",hotel.getInfoHospede("isa@araujo.br", "nome"));
			
		}catch(CadastroHospedeInvalidoException | VerificaNuloEVazioException | AtualizacaoInvalidaException | ConsultaHospedeInvalidaException e){
			e.getMessage();
		}
		
		// testando o atualizaCadastro pela data de nascimento
		
		try {	
			hotel.cadastraHospede("hektor farias", "hektor@farias.br", "22/02/1996");
			
			hotel.atualizaCadastro("hektor@farias.br", "data de nascimento", "23/02/1996");
			assertEquals("23/02/1996", hotel.getInfoHospede("hektor@farias.br", "data de nascimento"));
		} catch (CadastroHospedeInvalidoException | VerificaNuloEVazioException | AtualizacaoInvalidaException | ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}
		
		// testando o atualizaCadastro pelo email
		
		
		try {
			
			hotel.cadastraHospede("Hynghrid farias", "hyn@farias.br", "20/09/1999");
			hotel.atualizaCadastro("hyn@farias.br", "email", "hyn@farias.com");
		} catch (AtualizacaoInvalidaException | CadastroHospedeInvalidoException | VerificaNuloEVazioException e) {
			e.getMessage();
		}
		
		try {
			assertEquals("Hynghrid farias", hotel.getInfoHospede("hyn@farias.com", "nome"));
		} catch (ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testRemoveHospede() {
		
		try {
			
			hotel.removeHospede("soudiva@kardashian.eua");
			assertEquals("soudiva@kardashian.eua",hotel.getInfoHospede("soudiva@kardashian.eua", "email"));
			fail("excecao nao capturada");
			
		} catch (RemocaoInvalidaException | ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testGetInfoHospede(){
		
		// testando o getInfoHospede pelo nome
		try {
			assertEquals("Taylor Swift",hotel.getInfoHospede("loveme@taylor.eua", "nome"));
		} catch (ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}
		
		// testando o getInfoHospede pelo email
		try {
			assertEquals("loveme@taylor.eua",hotel.getInfoHospede("loveme@taylor.eua", "email"));
		} catch (ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}

		// testando o getInfoHospede pela data de nascimento
		try {
			assertEquals("13/12/1989",hotel.getInfoHospede("loveme@taylor.eua", "data de nascimento"));
		} catch (ConsultaHospedeInvalidaException e) {
			e.getMessage();
		}
		
	}
	// ##### testes da Estadia #####
	
	@Test
	public void testRealizaCheckin(){
		
		// com quarto do tipo presidencial
		try {
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");
			assertEquals("3A", hotel.getInfoHospedagem("bey@lemonade2016.eua", "quarto"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | HospedagemAtivaInvalidaException | MensagemErroException | ConsultaHospedagemInvalidaException e) {
			e.getMessage();
		}
		
		// com quarto do tipo luxo
		try {
			hotel.realizaCheckin("thebest@riri.eua", 4, "3B", "Luxo");
			assertEquals("3B", hotel.getInfoHospedagem("thebest@riri.eua", "quarto"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | HospedagemAtivaInvalidaException | MensagemErroException | ConsultaHospedagemInvalidaException e) {
			e.getMessage();
		}
		
		// com quarto do tipo simples
		try {
			hotel.realizaCheckin("mepasso@ariana.eua", 4, "12A", "Simples");
			assertEquals("12A", hotel.getInfoHospedagem("mepasso@ariana.eua", "quarto"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | HospedagemAtivaInvalidaException | MensagemErroException | ConsultaHospedagemInvalidaException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testRealizaCheckout(){
		
		
		try {
			hotel.realizaCheckin("drake@mycellphone.eua",  4, "4B", "Luxo");
			hotel.realizaCheckout("drake@mycellphone.eua","4B");
			assertEquals("R$1000,00",hotel.realizaCheckout("drake@mycellphone.eua","4B"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | CheckoutInvalidoException | ConsultaHospedagemInvalidaException e) {
			e.getMessage();
		}
		
	}
	
	@Test
	public void testGetInfoHospedagem() {
		
		// testando pelo atributo hospedagens ativas
		try{
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");

			assertEquals("1", hotel.getInfoHospedagem("bey@lemonade2016.eua", "hospedagens ativas"));
		}catch(CheckinInvalidoException | CriacaoQuartoInvalidoException | VerificaNuloEVazioException | ConsultaHospedagemInvalidaException | HospedagemAtivaInvalidaException | MensagemErroException e){
			e.getMessage();
		}
		
		// testando pelo atributo quarto
		try{
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");

			assertEquals("3A", hotel.getInfoHospedagem("bey@lemonade2016.eua", "quarto"));
		}catch(CheckinInvalidoException | CriacaoQuartoInvalidoException | VerificaNuloEVazioException | ConsultaHospedagemInvalidaException | HospedagemAtivaInvalidaException | MensagemErroException e){
			e.getMessage();
		}
		
		// testando pelo atributo total
		
		try{
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");

			assertEquals("R$2250,00", hotel.getInfoHospedagem("bey@lemonade2016.eua", "total"));
		}catch(CheckinInvalidoException | CriacaoQuartoInvalidoException | VerificaNuloEVazioException | ConsultaHospedagemInvalidaException | HospedagemAtivaInvalidaException | MensagemErroException e){
			e.getMessage();
		}
	}
	
	@Test
	public void testConsultaTransacoes1(){
		
		// teste do metodo consultaTransacoes com um parametro
		
		// consultaTransacoes, atributo quantidade
		try {
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");
			hotel.realizaCheckin("thebest@riri.eua", 4, "3B", "Luxo");
			hotel.realizaCheckin("mepasso@ariana.eua", 4, "12A", "Simples");
			
			assertEquals("3", hotel.consultaTransacoes("quantidade"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | MensagemErroException e) {
			e.getMessage();
		}
		
		// consultaTransacoes, atributo total
		
		try {
			hotel.realizaCheckin("thebest@riri.eua", 4, "3B", "Luxo");
			hotel.realizaCheckin("drake@mycellphone.eua",  4, "4B", "Luxo");
			
			assertEquals("R$2000,00", hotel.consultaTransacoes("total"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | MensagemErroException e) {
			e.getMessage();
		}
		
		// consultaTransacoes, atributo nome
		
		try {
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");
			hotel.realizaCheckin("mepasso@ariana.eua", 4, "12A", "Simples");
			
			assertEquals("Beyoncé Giselle;Ariana Grande", hotel.consultaTransacoes("nome"));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | MensagemErroException e) {
			e.getMessage();
		}	
	}
	
	@Test
	public void testConsultaTransacoes2() {
		
		// teste do metodo consultaTransacoes com dois parametros
		
		// consultaTransacoes, atributo total
		try {
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A", "Presidencial");
			hotel.realizaCheckout("bey@lemonade2016.eua","3A");

			assertEquals("R$2250.00", hotel.consultaTransacoes("total", 0)); 
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | CheckoutInvalidoException | ConsultaHospedagemInvalidaException | MensagemErroException | IndiceInvalidoException e) {
			e.getMessage();
			
		}
		
		// consultaTransacoes, atributo nome
		try {
			hotel.realizaCheckin("bey@lemonade2016.eua", 5, "3A","Presidencial");
			hotel.realizaCheckin("thebest@riri.eua", 4, "3B", "Luxo");
			hotel.realizaCheckin("mepasso@ariana.eua", 4, "12A", "Simples");

			assertEquals("Rihanna Fenty", hotel.consultaTransacoes("nome", 1));
		} catch (CheckinInvalidoException |CriacaoQuartoInvalidoException | VerificaNuloEVazioException | MensagemErroException | IndiceInvalidoException e) {
			e.getMessage();
		}
	}
}
