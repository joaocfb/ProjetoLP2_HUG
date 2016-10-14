/**
 * 
 */
package interfaces;

import java.util.ArrayList;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import exception.ErroOrdenacaoException;
import exception.PedidosInvalidoException;
import restaurante.Prato;

/**
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public interface RestauranteInterface {
	
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)throws ErroOrdenacaoException, CadastroPratoInvalidoException;
	
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws ErroOrdenacaoException,CadastroRefeicaoInvalidaException;
	
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException;
	
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException;
	
	public String consultaMenuRestaurante();
	
	public String ordenaMenu(String tipoOrdenacao) throws Exception;
	
	public String realizaPedido(String email, String item)throws PedidosInvalidoException;
}



