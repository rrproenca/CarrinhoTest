package com.altran.api.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4573945159772492043L;

	@Id
    private String id;

    private String nome;
    
    private Double valor;
	
	public Item() {
		
		
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
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}




	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}




	@Override
	public String toString() {
		return "Item [ Id = " + id + ", nome = " + nome + ", valor= " + valor.toString()  + "]";
	}
}
