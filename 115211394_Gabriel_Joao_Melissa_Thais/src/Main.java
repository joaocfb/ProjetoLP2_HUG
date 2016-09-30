import easyaccept.EasyAccept;

/**
 * 
 */

/**
 * @author thaisnat
 *
 */
public class Main {

	// main
	public static void main(String[] args) {
		// , "testes/easy/testes_uc3.txt", "testes/easy/testes_uc4.txt",
		// "testes/easy/testes_uc1_exception.txt",
		// "testes/easy/testes_uc4_exception.txt"
		args = new String[] { "sistemaDeControleHotel.Fachada", "testes/easy/testes_uc1.txt",
				"testes/easy/testes_uc1_exception.txt", "testes/easy/testes_uc2.txt",
				"testes/easy/testes_uc2_exception.txt", "testes/easy/testes_uc3.txt",
				"testes/easy/testes_uc3_exception.txt", "testes/easy/testes_uc4.txt",
				"testes/easy/testes_uc4_exception.txt", "testes/easy/testes_uc5.txt" };
																						
		EasyAccept.main(args);
	}
}