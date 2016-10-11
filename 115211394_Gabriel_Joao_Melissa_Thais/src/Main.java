import easyaccept.EasyAccept;

/**
 * Main> executa
 * @author Gabriel Alves 
 * @author Joao Carlos 
 * @author Melissa Diniz 
 * @author Thais Nicoly
 *
 */
public class Main {

	// main
	public static void main(String[] args) {
		args = new String[] {"view.Fachada", "testes/easy/testes_uc1.txt",
				"testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc2.txt",
				"testes/easy/testes_uc2_exception.txt", "testes/easy/testes_uc3.txt",
				"testes/easy/testes_uc3_exception.txt", "testes/easy/testes_uc4.txt",
				"testes/easy/testes_uc4_exception.txt", "testes/easy/testes_uc5.txt", "testes/easy/testes_uc6.txt",
				"testes/easy/testes_uc7.txt" };

		EasyAccept.main(args);
	}
}