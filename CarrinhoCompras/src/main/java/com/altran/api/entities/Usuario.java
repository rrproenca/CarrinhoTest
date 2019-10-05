package com.altran.api.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522776613328387994L;

	@Id
    private String id;

    private String nome;
    
    private Integer idade;
    
    private String	email;
	
	public Usuario () {
		
	}
	
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}



	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
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



	@Override
	public String toString() {
		return "Usuario [ Id = " + id + ", nome = " + nome + ", idade = " + idade + ", email = " + 
				email  + "]";
	}
}
