/**
 * 
 */
package testeUnidade;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import factorys.FactoryPrato;
import factorys.FactoryRefeicao;
import restaurante.Prato;
import restaurante.Refeicao;
import restaurante.Restaurante;

/**
 *  @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class RestauranteTest {
	
	private Restaurante restaurante;
	
	private FactoryPrato factoryPrato;
	private FactoryRefeicao factoryRefeicao;

	private HashMap<String, Prato> pratos;
	private HashMap<String, Refeicao> refeicao;
	
	
	@Before
	public void setUp() {
		
		restaurante = new Restaurante();
		
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
		this.pratos = new HashMap<>();
		this.refeicao = new HashMap<>();
		
		
		try {
			
			// criando os pratos
			pratos.put("Artsoppa com panquecas", factoryPrato.criaPrato("Artsoppa com panquecas", "Deliciosa sopa de ervilhas com carne. Essa comida tradicional da Suecia eh saboreada principalmente nas quintas-feiras.", 18.50));
			pratos.put("Kotbullar com lingon", factoryPrato.criaPrato("Kotbullar com lingon", "Almondegas de carne feito no tradicional estilo sueco.", 38.50));
			pratos.put("Kanelbullar", factoryPrato.criaPrato("Kanelbullar", "Um pequeno pao de massa fofinha e sabor de canela", 15.00));	
			
			
			// criando refeicoes
			refeicao.put("Svensk mat", factoryRefeicao.criaRefeicao("Svensk mat", "Uma variedade de comidas populares na Suecia.", restaurante.pratosRefeicao("Artsoppa com panquecas;Algkot com vegetais;Kanelbullar")));
			refeicao.put("Pasto italiano", factoryRefeicao.criaRefeicao("Pasto italiano", "Varios pratos italianos para saborear.", restaurante.pratosRefeicao("Bruschetta;Bresaola com rucula e parmesao;Penne ao pesto;Tiramisu")));
		} catch (Exception e) {
			
		}
			
	}
	@Test
	public void testCadastraPrato() {
		
		try {
			assertEquals(3, pratos.size());
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testCadastraRefeicao(){
		
		try {
			refeicao.put("Svensk mat", factoryRefeicao.criaRefeicao("Svensk mat", "Uma variedade de comidas populares na Suecia.", restaurante.pratosRefeicao("Artsoppa com panquecas;Algkot com vegetais;Kanelbullar")));
			refeicao.put("Pasto italiano", factoryRefeicao.criaRefeicao("Pasto italiano", "Varios pratos italianos para saborear.", restaurante.pratosRefeicao("Bruschetta;Bresaola com rucula e parmesao;Penne ao pesto;Tiramisu")));
			
			assertEquals(2,refeicao.size());
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void testConsultaRestaurante() {
		
		// chaveNome = prato, atributo = preco
		try {
			restaurante.consultaRestaurante("Artsoppa com panquecas", "preco");
			assertEquals("18.50",restaurante.consultaRestaurante("Artsoppa com panquecas", "preco"));
		} catch (CadastroRefeicaoInvalidaException | ConsultaRestauranteInvalidoException e) {
			e.getMessage();
		}
		
		// chaveNome = prato, atributo descricao
		try {
			restaurante.consultaRestaurante("Kotbullar com lingon", "descricao");
			assertEquals("Almondegas de carne feito no tradicional estilo sueco.",restaurante.consultaRestaurante("Kotbullar com lingon", "descricao"));
		} catch (CadastroRefeicaoInvalidaException | ConsultaRestauranteInvalidoException e) {
			e.getMessage();
		}
		
		// chaveNome = refeicao, atributo preco
		try {
			restaurante.consultaRestaurante("Svensk mat", "preco");
			assertEquals("97,65", restaurante.consultaRestaurante("Svensk mat", "preco"));
		} catch (CadastroRefeicaoInvalidaException | ConsultaRestauranteInvalidoException e) {
			e.getMessage();
		}
		
		// chaveNome = refeicao, atributo descricao
		try {
			restaurante.consultaRestaurante("Pasto italiano", "descricao");
			assertEquals("Varios pratos italianos para saborear.",restaurante.consultaRestaurante("Pasto italiano", "descricao"));
		} catch (CadastroRefeicaoInvalidaException | ConsultaRestauranteInvalidoException e) {
			e.getMessage();
		}
	}
	

}