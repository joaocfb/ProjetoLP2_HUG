/**
 * 
 */
package hotel;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import cartao.TipoDeCartao;
import exception.VerificaNuloEVazioException;
import factorys.FactoryEstadia;
import factorys.FactoryPedidosDoHospede;
import restaurante.Pedidos;
import cartao.*;
/**
 * Classe Hospede: um hospede possui nome, email e data de nascimento 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class Hospede {
	
	//atributos do hospede, cada hospede possui uma ou mais estadia
	private String nome;
	private String email;
	private int pontos = 0;
	private LocalDate dataNascimento;
	private TipoDeCartao tipoDeCartao;
	private FactoryEstadia factoryEstadia;
	private FactoryPedidosDoHospede factoryPedidos;

	private LinkedHashMap<String, Estadia> estadias;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private ArrayList<Pedidos> pedidosDoHospede;


	/**
	 * @return the pedidosDoHospede
	 */
	public ArrayList<Pedidos> getPedidosDoHospede() {
		return pedidosDoHospede;
	}

	/**
	 * Construtor do hospede
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws VerificaNuloEVazioException 
	 */
	public Hospede(String nome, String email, String dataNascimento) throws VerificaNuloEVazioException  {
		
		testandoNome(nome);
		testandoEmail(email);
		testandoDataNascimento(dataNascimento);
		
		this.nome = nome;
		this.email = email;
		tipoDeCartao = new Padrao();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryPedidos = new FactoryPedidosDoHospede();

		this.estadias = new LinkedHashMap<>();
		this.setDataNascimento(dataNascimento);
		this.pedidosDoHospede = new ArrayList<>();
		
	}
	
	public void alteraTipoDeCartao(){
		
		if(this.pontos < 350){
			setTipoDeCartao(new Padrao());
			
		}else if(this.pontos >= 350 && this.pontos <= 1000){
			setTipoDeCartao(new Premium());	
			
		}else{
			setTipoDeCartao(new VIP());	
		}
	}
	
	//teste do construtor
	private void testandoNome(String nome) throws VerificaNuloEVazioException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new VerificaNuloEVazioException("Nome do hospede");
		}
	}

	//teste do construtor
	private void testandoEmail(String email) throws VerificaNuloEVazioException{
		if (email == null || email.trim().isEmpty()) {
			throw new VerificaNuloEVazioException("Email do hospede");
		}
	}
	
	//teste do construtor
	private void testandoDataNascimento(String dataNascimento) throws VerificaNuloEVazioException{
		if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
			throw new VerificaNuloEVazioException("Data de Nascimento do hospede");
		}
	}
	
	
	public int getIdade(){
		int idade = (int)ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public TipoDeCartao getTipoDeCartao() {
		return tipoDeCartao;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void setTipoDeCartao(TipoDeCartao tipoDeCartao) {
		this.tipoDeCartao = tipoDeCartao;
	}

	public HashMap<String, Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(LinkedHashMap<String, Estadia> estadias) {
		this.estadias = estadias;
	}

	public void setDataNascimento(String dataNascimento) {
		LocalDate data = LocalDate.parse(dataNascimento, formatoData);
		this.dataNascimento = data;

	}
	
	public String getDataNascimento() {
		String dataString = formatoData.format(dataNascimento);
		return dataString;
	}

	
	//toString
	@Override
	public String toString() {
		return "Hospede [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
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
	 * Compara dois hospedes pelo email
	 * 
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