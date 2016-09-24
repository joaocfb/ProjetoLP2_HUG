package validaRefeicao;

public class VerificaRefeicao {
	
	public static void verificaDescVazio(String descricao) throws Exception {
		if (descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		}

	}
	
	public static void verificaNomeRefvazio(String nomeRef) throws Exception {
		if (nomeRef.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		}

	}

}
