package com.altran.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.api.entities.Compras;
import com.altran.api.repositories.CompraRepository;
import com.altran.api.services.ComprasService;

@Service	
public class ComprasServiceImpl implements ComprasService {
	
		
		private static final Logger log = LoggerFactory.getLogger(ComprasServiceImpl.class);

		@Autowired
		private CompraRepository compraRepository;

		@Override
		public Optional<Compras> buscarPorId(String id) {
			log.info("Buscando uma compra para o ID {}", id);
			return compraRepository.findById(id);
		}

}
