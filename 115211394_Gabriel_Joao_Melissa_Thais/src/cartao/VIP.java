package cartao;

public class VIP implements TipoDeCartao {

	@Override
	public int bonusPontos(double compra) {

		return (int) (compra * 0.5) ;
	}

	@Override
	public double desconto(double compra) {
		
		double compraComdesconto = 0;
		
		//desconto de 15%
		compraComdesconto += compra * 0.15;
		
		//desconto adicional de 10 a cada 100 gasto
		compraComdesconto += (int)(compra/100)*10;
		
		return compraComdesconto;
	}

}
