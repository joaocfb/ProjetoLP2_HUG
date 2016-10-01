package cartao;


public class Premium implements TipoDeCartao {

	@Override
	public int bonusPontos(double compra) {


		if (compra > 100){
			
			int bonus = 0;
			
			//bonus de 30% do valor da compra
			bonus += (int) (compra * 0.3);
			
			//bonus adicional para compras acima de 100 gasto
			//10 pontos para cada 100 gasto
			bonus += (int) (compra/100)*10;
			
			return bonus;
			
		}else{
			
			//bonus de 30% do valor da compra
			return (int) (compra * 0.3);
		}	
	}

	@Override
	public double desconto(double compra) {
		
		//desconto de 10%
		return  (compra * 0.1);
	}

	@Override
	public double convertePontos(int qtdPontos) {
		
		double valor = 0;
		valor += (qtdPontos/10) * 0.2;
		valor += qtdPontos*0.3;
		
		return valor;
	}

}
