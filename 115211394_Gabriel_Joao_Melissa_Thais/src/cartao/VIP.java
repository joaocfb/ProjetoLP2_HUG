package cartao;


/**
 * Classe que define o cartao tipo VIP
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VIP implements TipoDeCartao {

	/**
	 * Metodo que calcula o bonus aplicado no cartao, sobrescrita
	 */
	@Override
	public int bonusPontos(double compra) {
		return (int) (compra * 0.5) ;
	}

	/**
	 * Metodo que aplica o desconto, sobrescrita
	 */
	@Override
	public double desconto(double compra) {
		
		double compraDesconto = 0;
		
		//desconto de 15%
		compraDesconto += compra * 0.15;
		
		//desconto adicional de 10 a cada 100 gasto
		compraDesconto += (int)(compra/100)*10;
		
		return compraDesconto;
	}

	
	/**
	 * Metodo que converte os pontos do hospede em dinheiro, sobrescrita
	 */
	@Override
	public double convertePontos(int qtdPontos) {

		double valor = 0;
		
		//faz o calculo da conversao dos pontos em dinheiro
		valor += (qtdPontos/10) * 0.5;
		valor += qtdPontos*0.70;
		
		return valor;
	}

}
