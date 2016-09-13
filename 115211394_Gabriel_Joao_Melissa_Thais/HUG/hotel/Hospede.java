/**
 * 
 */
package hotel;

import java.util.ArrayList;

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
	private String dataNascimento;
	private FactoryEstadia factoryEstadia;
	private ArrayList<Estadia> estadias;


	/**
	 * Construtor do hospede
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @throws StringInvalidaException 
	 */
	public Hospede(String nome, String email, String dataNascimento) throws StringInvalidaException {
		verificaHospede(nome, email, dataNascimento);
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
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

	/**
	 * @return the dataNascimento
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	private void verificaHospede(String nome, String email, String dataNascimento) throws StringInvalidaException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Parametro invalido.");
		} else if (email == null || email.trim().isEmpty()) {
			throw new StringInvalidaException("Parametro invalido.");
		} else if (email == null || email.trim().isEmpty()) {
			throw new StringInvalidaException("Parametro invalido.");
		}
	}

	
	
}
