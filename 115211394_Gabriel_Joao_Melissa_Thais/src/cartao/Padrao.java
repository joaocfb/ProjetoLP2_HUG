package cartao;

public class Padrao implements TipoDeCartao {

	@Override
	public int bonusPontos(double compra) {
		
		return (int) (compra * 0.1);
	}

	@Override
	public double desconto(double compra) {
		//Nao a desconto
		return 0;
	}

}



