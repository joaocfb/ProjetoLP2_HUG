package cartao;

public interface TipoDeCartao {

	int bonusPontos(double compra);
	
	double desconto(double compra);
	
	double convertePontos (int qtdPontos);
}

