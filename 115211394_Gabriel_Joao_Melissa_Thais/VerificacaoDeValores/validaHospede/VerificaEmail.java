package validaHospede;

public class VerificaEmail {

	public static void verificaEmailInvalido(String email) throws Exception {
		if (email.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new Exception("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}		
	}
}
