package cartao;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VIP implements TipoDeCartao {
	
	/**
	 * metodo que adiciona os pontos ao cartao fidelidade do hospede
	 * @return o seu bonus
	 */
	@Override
	public int adicionaPontos(double compra) {

		return (int) (compra * 0.5) ;
	}
	
	/**
	 * metodo que calcula os descontos das compras do hospede
	 * 
	 */
	@Override
	public double desconto(double compra) {
		
		double compraComdesconto = 0;
		
		//desconto de 15%
		compraComdesconto += compra * 0.85;
		
		//desconto adicional de 10 a cada 100 gasto
		compraComdesconto += (int)(compra/100)*10;
		
		return compraComdesconto;
	}

}
