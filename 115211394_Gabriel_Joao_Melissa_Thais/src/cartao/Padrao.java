package cartao;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Padrao implements TipoDeCartao {

	/**
	 * metodo que adiciona os pontos ao cartao fidelidade do hospede
	 * @return o seu bonus
	 */
	@Override
	public int adicionaPontos(double compra) {
		
		return (int) (compra * 0.1);
	}

	/**
	 *  metodo que calcula os descontos das compras do hospede
	 */
	@Override
	public double desconto(double compra) {
		//Nao ha desconto
		return 0;
	}

}


