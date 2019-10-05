package com.altran.api.dto;

import java.util.Date;
import java.util.List;


public class ComprasDto {
	
	  	private String id;
	    private Date data;	    
	    private UsuarioDto user;
	    private List<ItemDto> itensDto;
    
	
	public ComprasDto() {
		
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
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}


	/**
	 * @return the user
	 */
	public UsuarioDto getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(UsuarioDto user) {
		this.user = user;
	}


	/**
	 * @return the itensDto
	 */
	public List<ItemDto> getItensDto() {
		return itensDto;
	}


	/**
	 * @param itensDto the itensDto to set
	 */
	public void setItensDto(List<ItemDto> itensDto) {
		this.itensDto = itensDto;
	}
	
	

}
