
package restaurante;

import java.util.ArrayList;
import java.util.HashMap;

import exception.CadastroPratoInvalidoException;
import exception.CadastroRefeicaoInvalidaException;
import exception.ConsultaHospedeInvalidaException;
import exception.ConsultaRestauranteInvalidoException;
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
	 * @throws CadastroPratoInvalidoException 
	 * @throws Exception
	 */
	public void cadastraPrato(String nomePrato, double precoPrato, String descricaoPrato) throws CadastroPratoInvalidoException{
		
		pratos.put(nomePrato, factoryPrato.criaPrato(nomePrato, descricaoPrato,precoPrato));
	}
	
	/**
	 * Metodo que cadastra uma refeicao
	 * @param nomeRef
	 * @param descricaoRef
	 * @param componentes
	 * @throws CadastroRefeicaoInvalidaException 
	 * @throws Exception
	 */
	public void cadastraRefeicao(String nomeRef, String descricaoRef, String componentes) throws CadastroRefeicaoInvalidaException {
		
		refeicao.put(nomeRef, factoryRefeicao.criaRefeicao(nomeRef, descricaoRef, pratosRefeicao(componentes)));
	}
	
	/**
	 * Metodo que retorna uma lista com os objs prato
	 * @param componentes
	 * @return ArrayList
	 * @throws CadastroRefeicaoInvalidaException 
	 */
	public ArrayList<Prato> pratosRefeicao(String componentes) throws CadastroRefeicaoInvalidaException{
		
		if (componentes.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Componente(s) esta(o) vazio(s).");
		}
		
		int pratosCadastrados = 0;
		
		ArrayList<Prato> pratosRef = new ArrayList<>();
		String[] nomesComponentes = componentes.split(";");
		
		for (String nomePrato : nomesComponentes) {
			pratosRef.add(this.pratos.get(nomePrato));
			if(pratos.containsKey(nomePrato)) {
				pratosCadastrados ++;
			}
		}
		
		if (!(pratosCadastrados == pratosRef.size())) {
			throw new CadastroRefeicaoInvalidaException(". So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
		
		if (pratosRef.size() > 4 || pratosRef.size() < 3) {
			throw new CadastroRefeicaoInvalidaException(" completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		
		return pratosRef;
	}
	
	/**
	 * Metodo
	 * @param chaveNome
	 * @param atributo
	 * @return
	 * @throws ConsultaRestauranteInvalidoException 
	 * @throws Exception
	 */
	public String consultaRestaurante(String chaveNome, String atributo) throws CadastroRefeicaoInvalidaException, ConsultaRestauranteInvalidoException{
		
		if (pratos.containsKey(chaveNome)) {

			switch (atributo.toLowerCase()) {
			
			case "preco":
				String retorno = "";
				retorno += String.format("R$%.2f", (pratos.get(chaveNome).getPrecoPrato()));
				return retorno;
				
			case "descricao":
				
				return pratos.get(chaveNome).getDescricao();
			
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
		throw new ConsultaRestauranteInvalidoException(" Nome do prato esto vazio.");
	}
	
	
	
}
