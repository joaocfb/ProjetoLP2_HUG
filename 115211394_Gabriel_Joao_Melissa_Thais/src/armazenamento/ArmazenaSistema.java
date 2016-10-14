/**
 * 
 */
package armazenamento;

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
 * Classe que gerencia a leitura e gravacao de dados no arquivo
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 *
 */
public class ArmazenaSistema implements Serializable{
	
	private ControleDoSistema controller;
	private static final long serialVersionUID = 1L;
	private static final String CAMINHO_ARQUIVO = "arquivos_sistema/hug.dat";

	
	
	/**
	 * Metodo que grava o controler no arquivo
	 * @param objeto controller
	 * @throws Exception
	 */
	public void fechaSistema(ControleDoSistema controller) throws Exception {

		File arquivo = new File(CAMINHO_ARQUIVO);

		if (arquivo.exists()) {
			arquivo.delete();
		}

		try {

			ObjectOutputStream escrita = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(CAMINHO_ARQUIVO)));

			escrita.writeObject(controller);
			escrita.close();

		} catch (Exception e) {

			throw new Exception("Alguma coisa nao deu muito certo.");
		}

	}

	/**
	 * Metodo que faz a leitura do arquivo
	 * @return o controller
	 * @throws Exception
	 */
	public ControleDoSistema iniciaSistema() throws Exception {

		File arquivo = new File(CAMINHO_ARQUIVO);

		if (arquivo.exists()) {

			try {

				ObjectInputStream leitura = new ObjectInputStream(new BufferedInputStream(new FileInputStream(CAMINHO_ARQUIVO)));
				
				//cast
				ControleDoSistema controller = (ControleDoSistema) leitura.readObject();

				leitura.close();

				return controller;

			} catch (Exception e) {

				throw new Exception("Nao conseguiu le o arquivo :(");
			}

		} else {

			ControleDoSistema controller = new ControleDoSistema();

			return controller;
		}

	}
	
	/**
	 * Metodo que retorna o obj controller
	 * @return o controller
	 */
	public ControleDoSistema getControllerSistema() {
		return controller;
	}

}
