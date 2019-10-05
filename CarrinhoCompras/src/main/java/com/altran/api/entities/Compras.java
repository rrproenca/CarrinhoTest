package com.altran.api.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "compras")
public class Compras implements Serializable {
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = -7428724292277977139L;

		@Id
	    private String id;

	    private Date data;
	    
	    private Usuario user;


	    private List<Item> itens;
	    
	    
	    public Compras() {
	    	
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
		public Usuario getUser() {
			return user;
		}


		/**
		 * @param user the user to set
		 */
		public void setUser(Usuario user) {
			this.user = user;
		}


		/**
		 * @return the itens
		 */
		public List<Item> getItens() {
			return itens;
		}


		/**
		 * @param itens the itens to set
		 */
		public void setItens(List<Item> itens) {
			this.itens = itens;
		}
	    
		
		public Double valorTotalItens() {			
			return itens.stream().mapToDouble(Item::getValor).sum();
		}
	    
		@Override
		public String toString() {
			return "Compras [ Id = " + id + ", data = " + data.toString() + "]";
		}

}
