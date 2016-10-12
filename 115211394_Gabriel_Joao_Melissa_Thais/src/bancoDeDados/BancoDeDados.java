/**
 * 
 */
package bancoDeDados;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import sistemaDeControleHotel.ControleDoSistema;

/**
 * @author Melissa
 *
 */
public class BancoDeDados implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private ControleDoSistema controller;

	public void fechaEscreveArquivo(ControleDoSistema controller) throws Exception {

		File arquivoUsuario = new File("hug.dat");

		if (arquivoUsuario.exists()) {
			arquivoUsuario.delete();
		}

		try {

			ObjectOutputStream write = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("hug.dat")));

			write.writeObject(controller);

			write.close();

		} catch (Exception e) {

			throw new Exception("aconteceu algum erro no arquivo.");
		}

	}

	public ControleDoSistema iniciaLeArquivo() throws Exception {

		File arquivoUsuario = new File("hug.dat");

		if (arquivoUsuario.exists()) {

			try {

				ObjectInputStream read = new ObjectInputStream(new BufferedInputStream(new FileInputStream("hug.dat")));

				ControleDoSistema controller = (ControleDoSistema) read.readObject();

				read.close();

				return controller;

			} catch (Exception e) {

				throw new Exception("arquivo nao foi lido.");
			}

		} else {

			ControleDoSistema controller = new ControleDoSistema();

			return controller;
		}

	}
	
	
	public ControleDoSistema getControllerSistema() {
		return controller;
	}

}
