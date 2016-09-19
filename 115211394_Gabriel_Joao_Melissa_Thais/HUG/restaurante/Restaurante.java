
package restaurante;

import java.util.ArrayList;
import java.util.HashMap;

import factorys.FactoryPrato;
import factorys.FactoryRefeicao;

/**
 * Classe Restaurante 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Restaurante {
	private FactoryPrato factoryPrato;
	private FactoryRefeicao factoryRefeicao;

	private HashMap<String, Prato> pratos;
	private HashMap<String, Refeicao> refeicao;

	
	public Restaurante(){
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
		this.pratos = new HashMap<>();
		this.refeicao = new HashMap<>();

	}
	
	/**
	 * Metodo que cadastra um prato
	 * @param nomePrato
	 * @param precoPrato
	 * @param descricaoPrato
	 * @throws Exception
	 */
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato)throws Exception{
		
		pratos.put(nomePrato, factoryPrato.criaPrato(nomePrato, precoPrato, descricaoPrato));
	}
	
	/**
	 * Metodo
	 * @param chaveNome
	 * @param atributo
	 * @return
	 * @throws Exception
	 */
	public String consultaRestaurante(String chaveNome, String atributo) throws Exception{
		
		if (pratos.containsKey(chaveNome)) {

			switch (atributo.toLowerCase()) {
			
			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", (pratos.get(chaveNome).getPrecoPrato()));
				return retorno;
				
			case "descricao":
				
				return pratos.get(chaveNome).getDescricaoPrato();
			
			}
			
		}if (refeicao.containsKey(chaveNome)) {

			switch (atributo.toLowerCase()) {
			
			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", refeicao.get(chaveNome).getPrecoRefeicao());
				return retorno;
				
			case "descricao":
				
				return refeicao.get(chaveNome).toString();
			
			}
		
		}
		throw new Exception("Erro na consulta do restaurante. Nome do prato esto vazio.");
	}
	
	/**
	 * Metodo que retorna uma lista com os objs prato
	 * @param componentes
	 * @return ArrayList
	 */
	public ArrayList<Prato> pratosRefeicao(String componentes)throws Exception{
		
		if (componentes.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
		
		ArrayList<Prato> pratosRef = new ArrayList<>();
		String[] nomesComponentes = componentes.split(";");
		for (String string : nomesComponentes) {
			pratosRef.add(this.pratos.get(string));
		}
		
		if (pratosRef.size() > 4 || pratosRef.size() < 3) {
			throw new Exception("Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		
		return pratosRef;
	}
	
	/**
	 * Metodo que cadastra uma refeicao
	 * @param nomeRef
	 * @param descricaoRef
	 * @param componentes
	 * @throws Exception
	 */
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws Exception{
		
		refeicao.put(nomeRef, factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRefeicao(componentes)));
	}
	
	
	
	
}
