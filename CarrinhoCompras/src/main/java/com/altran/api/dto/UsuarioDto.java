package com.altran.api.dto;

public class UsuarioDto {

	 	private String id;

	    private String nome;
	    
	    private Integer idade;
	    
	    private String	email;
	    
	    public UsuarioDto() {
	    	
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
	    
	    
	    
}
