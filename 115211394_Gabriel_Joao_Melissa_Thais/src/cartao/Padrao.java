package cartao;

public class Padrao implements TipoDeCartao {

	@Override
	public int adicionaPontos(float compra) {
		
		return (int) (compra * 0.1);
	}

	@Override
	public float desconto(float compra) {
		//Nao a desconto
		return 0;
	}

}


