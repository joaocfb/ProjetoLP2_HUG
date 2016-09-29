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
// Rapadura;Espresso;Tapioca;Pudim de leite;Bresaola com rucula e parmesao;Bruschetta;
//Tiramisu;Kanelbullar;Galeto com farofa;Artsoppa com panquecas;Penne ao pesto;Kotbullar com lingon;
//Delicia da serra;Carne de sol com fritas;Pasto italiano;Algkot com vegetais;Svensk mat
// *************************
// "Rapadura;Espresso;Tapioca;Pudim de Leite;Bruschetta;Bresaola com rucula e parmesao;
//Tiramisu;Kanelbullar;Galeto com farofa;Artsoppa com panquecas;Penne ao pesto;Kotbullar com lingon;
//Delicia da serra;Carne de sol com fritas;Pasto italiano;Algkot com vegetais;Svensk mat"