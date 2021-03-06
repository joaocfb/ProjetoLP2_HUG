/**
 * 
 */
package hotel;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import cartao.TipoDeCartao;
import exception.VerificaNuloEVazioException;

import restaurante.Pedidos;
import cartao.*;
/**
 * Classe Hospede: um hospede possui nome, email e data de nascimento 
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */

public class Hospede implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private int pontos = 0;
	
	private LocalDate dataNascimento;
	private TipoDeCartao tipoDeCartao;

	private LinkedHashMap<String, Estadia> estadias;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private ArrayList<Pedidos> pedidosDoHospede;


	/**
	 * Construtor do hospede
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws VerificaNuloEVazioException 
	 */
	public Hospede(String nome, String email, String dataNascimento) throws VerificaNuloEVazioException  {
		
		
		this.nome = nome;
		this.email = email;
		tipoDeCartao = new Padrao();

		this.estadias = new LinkedHashMap<>();
		this.setDataNascimento(dataNascimento);
		this.pedidosDoHospede = new ArrayList<>();
		outroFormatoData();
	
	}
	
	/**
	 * Modifica o formato da data para ser gravado no arquivo
	 * @return
	 */
	public String outroFormatoData(){
		String retorno = "";
		
		 LocalDate hoje = this.dataNascimento;
		 retorno = hoje.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return retorno;
		
	}
	/**
	 * Metodo que altera o tipo do cartao
	 */
	public void alteraTipoDeCartao(){
		
		//PADRAO
		if(this.pontos < 350){
			setTipoDeCartao(new Padrao());
			
		//PREMIUM
		}else if(this.pontos >= 350 && this.pontos <= 1000){
			setTipoDeCartao(new Premium());	
		
		//VIP
		}else{
			setTipoDeCartao(new VIP());	
		}
	}

	/**
	 * Metodo que converte os pontos em dinheiro
	 * @param qtdPontos
	 * @return o valor em dinheiro convertido
	 */
	public double convertePontos(int qtdPontos){
		
		alteraTipoDeCartao();
		pontos -= qtdPontos;
		
		return getTipoDeCartao().convertePontos(qtdPontos);
	}
	

	/**
	 * @return the pedidosDoHospede
	 */
	public ArrayList<Pedidos> getPedidosDoHospede() {
		return pedidosDoHospede;
	}

	/**
	 * @param pedidosDoHospede the pedidosDoHospede to set
	 */
	public void setPedidosDoHospede(ArrayList<Pedidos> pedidosDoHospede) {
		this.pedidosDoHospede = pedidosDoHospede;
	}
	
	/**
	 * @return
	 */
	public int getIdade(){
		int idade = (int)ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return idade;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPontos() {
		return pontos;
	}
	
	/**
	 * 
	 * @return
	 */
	public TipoDeCartao getTipoDeCartao() {
		return tipoDeCartao;
	}
 
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @param pontos
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	/**
	 * 
	 * @param tipoDeCartao
	 */
	public void setTipoDeCartao(TipoDeCartao tipoDeCartao) {
		this.tipoDeCartao = tipoDeCartao;
	}

	/**
	 * 
	 * @return
	 */
	public HashMap<String, Estadia> getEstadias() {
		return estadias;
	}

	/**
	 * 
	 * @param estadias
	 */
	public void setEstadias(LinkedHashMap<String, Estadia> estadias) {
		this.estadias = estadias;
	}

	/**
	 * 
	 * @param dataNascimento
	 */
	public void setDataNascimento(String dataNascimento) {
		LocalDate data = LocalDate.parse(dataNascimento, formatoData);
		this.dataNascimento = data;

	}
	

	
	/**
	 * 
	 * @return
	 */
	public String getDataNascimento() {
		String dataString = formatoData.format(dataNascimento);
		return dataString;
	}
	
	
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\r\n" + "Email: " + getEmail() + "\r\n" + "Data de Nascimento: "
				+ outroFormatoData() + "\r\n";
	}

	//Hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	/**
	 * Equals hospede: dois hospedes sao iguais se o email for o mesmo
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Hospede)) {
			return false;
		}
		Hospede outro = (Hospede) obj;
		
		if (getEmail().equals(outro.getEmail())) {
			return true;
		}
		return false;
	}
	
}