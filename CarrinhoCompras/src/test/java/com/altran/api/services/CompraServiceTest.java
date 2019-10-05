package com.altran.api.services;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.altran.api.entities.Compras;
import com.altran.api.repositories.CompraRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompraServiceTest {

	
	private CompraRepository compraRepository;

	@Autowired
	private ComprasService comprasService;

	private static final String ID_COMPRA = "5d96af4e1c9d440000862655";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given( this.compraRepository.findById( Mockito.anyString()) ).willReturn(Optional.ofNullable(new Compras()));
	}

	@Test
	public void testBuscarComprasaPorId() {
		Optional<Compras> compras = this.comprasService.buscarPorId(ID_COMPRA);

		assertTrue(compras.isPresent());
	}	
	
}
