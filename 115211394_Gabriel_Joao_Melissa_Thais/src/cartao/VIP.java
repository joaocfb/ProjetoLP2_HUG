package cartao;

public class VIP implements TipoDeCartao {

	@Override
	public int adicionaPontos(float compra) {

		return (int) (compra * 0.5) ;
	}

	@Override
	public float desconto(float compra) {
		
		float compraComdesconto = 0;
		
		//desconto de 15%
		compraComdesconto += compra * 0.85;
		
		//desconto adicional de 10 a cada 100 gasto
		compraComdesconto += (int)(compra/100)*10;
		
		return compraComdesconto;
	}

}
