/**
 * 
 */
package factorys;

import hotel.Transacao;

/**
 * @author Melissa
 *
 */
public class FactoryTransacao {
	double total;
	String detalhe;
	String nome;
	
	public Transacao criaTransacao(double total, String detalhe, String nome){
		return new Transacao(total, detalhe, nome);
	}

}
