package com.altran.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.altran.api.entities.Compras;

public interface CompraRepository extends MongoRepository<Compras, String> {
	

	 Compras findComprasById(String id);	
	 
}
