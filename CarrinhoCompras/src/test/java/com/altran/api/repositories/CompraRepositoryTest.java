package com.altran.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.altran.api.entities.Compras;
import com.altran.api.entities.Item;
import com.altran.api.entities.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompraRepositoryTest {

	@Autowired
	private CompraRepository compraRepository;
	
	
	private String compraId;

	@Before
	public void setUp() throws Exception {
		Compras compras = this.compraRepository.save(obterDadosCompras());
		this.compraId = compras.getId();
		
	}

	@After
	public void tearDown() throws Exception {
		this.compraRepository.deleteAll();
	}

	@Test
	public void testBuscarComprasPorId() {
		Compras compras = this.compraRepository.findComprasById(compraId);
		
		assertEquals("5d96af4e1c9d440000862655", compras.getId());
	}
	
	
	private Compras obterDadosCompras() throws NoSuchAlgorithmException {
		Compras compras = new Compras();
		compras.setData(new Date());
		compras.setId("5d96af4e1c9d440000862655");
		
		Usuario usuario = new Usuario();
		usuario.setEmail("email@email.com");
		usuario.setId("");
		usuario.setIdade(30);
		usuario.setNome("joão");
		
		compras.setUser(usuario);
		
		compras.setItens(obterItens());

		return compras;
	}

	
	private List<Item> obterItens() {
		List<Item> itens = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setId("1");
		item1.setNome("Panela");
		item1.setValor(new Double(10));
		itens.add(item1);
		
		Item item2 = new Item();
		item2.setId("2");
		item2.setNome("Colher");
		item2.setValor(new Double(5));
		itens.add(item2);
		
		return itens;
		
		
	}
	
	
}
