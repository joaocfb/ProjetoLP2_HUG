package cartao;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public interface TipoDeCartao {

	int adicionaPontos(double compra);
	
	double desconto(double compra);
}

