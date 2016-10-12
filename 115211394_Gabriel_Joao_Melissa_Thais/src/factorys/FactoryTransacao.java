/**
 * 
 */
package factorys;

import java.io.Serializable;

import hotel.Transacao;

/**
 * @author Melissa
 *
 */
public class FactoryTransacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public Transacao criaTransacao(double total, String detalhe, String nome){
		return new Transacao(total, detalhe, nome);
	}

}
