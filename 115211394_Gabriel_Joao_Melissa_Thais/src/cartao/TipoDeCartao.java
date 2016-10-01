package cartao;

/**
 * Interface que implementa o tipo do cartao
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface TipoDeCartao {

	/**
	 * Metodo que calcula o bonus aplicado no cartao
	 * @param compra
	 * @return Bonus equivalente a transacao realizada
	 */
	int bonusPontos(double compra);
	
	/**
	 * Metodo que aplica o desconto
	 * @param compra
	 * @return o desconto aplicado dependendo do tipo do cartao
	 */
	double desconto(double compra);
	
	/**
	 * Metodo que converte os pontos do hospede em dinheiro
	 * @param qtdPontos
	 * @return o valor em dinheiro equivalente a quantidade de pontos resgatados
	 */
	double convertePontos(int qtdPontos);
}

