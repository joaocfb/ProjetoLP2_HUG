package validaCheckout;

public class VerificaEmailCheckout {

	public static void verificaEmailInvalido(String email) throws Exception {
		if (email.trim().isEmpty()) {
			throw new Exception("Erro ao realizar checkout. Email do(a) hospede nao pode ser vazio.");
			
		}
		if (!email.matches("[a-zA-Z]+@[a-z]+\\.[a-z|\\.a-z+\\.a-z]+")) {
			throw new Exception("Erro ao realizar checkout. Email do(a) hospede esta invalido.");
		}		
	}
		public static void verificaIdInvalidaCheckout(String id) throws Exception {
		if(!(id.matches("[a-zA-Z0-9]+"))) {
			throw new Exception ("Erro ao realizar checkout. ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	
}

