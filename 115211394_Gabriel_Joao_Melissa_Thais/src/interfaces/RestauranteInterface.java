/**
 * 
 */
package interfaces;

import java.util.ArrayList;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import exception.PedidosInvalidoException;
import restaurante.Prato;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface RestauranteInterface {
	
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)throws CadastroPratoInvalidoException;
	
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException;
	
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException;
	
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException;
	
	public String consultaMenuRestaurante();
	
	public String ordenaMenu(String tipoOrdenacao) throws Exception;
	
	public String realizaPedido(String email, String item)throws PedidosInvalidoException;
}