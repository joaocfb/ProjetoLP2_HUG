package cartao;

public class VIP implements TipoDeCartao {

	@Override
	public int bonusPontos(double compra) {


		return (int) (compra * 0.5) ;
			
	}

	@Override
	public double desconto(double compra) {
		
		double compraDesconto = 0;
		
		//desconto de 15%
		compraDesconto += compra * 0.15;
		
		//desconto adicional de 10 a cada 100 gasto
		compraDesconto += (int)(compra/100)*10;
		
		return compraDesconto;
	}

	@Override
	public double convertePontos(int qtdPontos) {

		double valor = 0;
		valor += (qtdPontos/10) * 0.5;
		valor += qtdPontos*0.70;
		
		return valor;
	}

}
