/**
 * 
 */
package hotel;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedHashMap;

import exception.StringInvalidaException;
import factorys.FactoryEstadia;

/**
 * Classe Hospede: um hospede possui nome, email e data de nascimento 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class Hospede {
	//atributos do hospede, cada hospede possui uma ou mais estadia
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private FactoryEstadia factoryEstadia;
	private LinkedHashMap<String, Estadia> estadias;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	/**
	 * Construtor do hospede
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws StringInvalidaException 
	 * @throws Exception 
	 */
	public Hospede(String nome, String email, String dataNascimento) throws StringInvalidaException  {
		
		testandoNome(nome);
		testandoEmail(email);
		testandoDataNascimento(dataNascimento);
		
		this.nome = nome;
		this.email = email;
		this.factoryEstadia = new FactoryEstadia();
		this.estadias = new LinkedHashMap<>();
		this.setDataNascimento(dataNascimento);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdade(){
		int idade = (int)ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return idade;
	}
	
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	public HashMap<String, Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(LinkedHashMap<String, Estadia> estadias) {
		this.estadias = estadias;
	}

	
	/**
	 * @param dataNascimento the dataNascimento to set
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


	//teste
	private void testandoNome(String nome) throws StringInvalidaException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome do hospede nao pode ser nulo ou vazio.");
		}
	}
	
	//teste
	private void testandoEmail(String email) throws StringInvalidaException{
		if (email == null || email.trim().isEmpty()) {
			throw new StringInvalidaException("Email do hospede nao pode ser nulo ou vazio.");
		}
	}
	
	//teste
	private void testandoDataNascimento(String dataNascimento) throws StringInvalidaException{
		if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
			throw new StringInvalidaException("Data de Nascimento do hospede nao pode ser nulo ou vazio.");
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hospede [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
