package com.altran.api.services;

import java.util.Optional;

import com.altran.api.entities.Compras;

public interface ComprasService {

	/**
	 * Retorna uma compra dado o ID.
	 * 
	 * @param id
	 * @return Optional<Compras>
	 */	
	 Optional<Compras> buscarPorId(String id);
	

}
