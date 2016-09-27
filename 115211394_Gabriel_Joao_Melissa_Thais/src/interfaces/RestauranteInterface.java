/**
 * 
 */
package interfaces;

import java.util.ArrayList;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
import restaurante.Prato;

/**
 * @author nicolly
 *
 */
public interface RestauranteInterface {
	
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)throws CadastroPratoInvalidoException;
	
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException;
	
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException;
	
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException;
	
	public String consultaMenuRestaurante();
}
