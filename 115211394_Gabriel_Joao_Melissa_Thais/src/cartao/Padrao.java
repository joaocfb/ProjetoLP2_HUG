package cartao;

import java.io.Serializable;

/**
 * Classe que define o cartao tipo PADRAO
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class Padrao implements TipoDeCartao, Serializable {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que calcula o bonus aplicado no cartao, sobrescrita
	 */
	@Override
	public int bonusPontos(double compra) {
		
		return (int) (compra * 0.1);
	}

	/**
	 * Metodo que aplica o desconto, sobrescrita
	 */
	@Override
	public double desconto(double compra) {
		//Nao a desconto
		return 0;
	}

	/**
	 * Metodo que converte os pontos do hospede em dinheiro, sobrescrita
	 */
	@Override
	public double convertePontos(int qtdPontos) {
		//0,10 a cada ponto
		return qtdPontos*0.1;
	}

}



