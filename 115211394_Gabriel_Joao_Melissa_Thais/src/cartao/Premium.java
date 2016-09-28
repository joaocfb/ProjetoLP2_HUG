package cartao;


public class Premium implements TipoDeCartao {

	@Override
	public int adicionaPontos(float compra) {
		
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
	public float desconto(float compra) {

		float compraComdesconto  = 0;
		
		//desconto de 10% do valor da compra
		compraComdesconto += compra * 0.9;
		
		
		return compraComdesconto;
	}

}