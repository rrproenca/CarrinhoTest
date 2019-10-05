package com.altran.api.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.altran.api.entities.Compras;
import com.altran.api.services.ComprasService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ComprasControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ComprasService comprasService;

	private static final String BUSCAR_COMPRAS_ID_URL = "/api/compras-itens/detalhes/";
	private static final String ID = "5d96af4e1c9d440000862655";
	

	@Test
	public void testBuscarComprasPorIdInexistente() throws Exception {
		BDDMockito.given(this.comprasService.buscarPorId(Mockito.anyString())).willReturn(Optional.empty());

		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_COMPRAS_ID_URL + ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Compra não encontrada para o ID " + ID));
	}

	@Test	
	public void testBuscarEmpresaCnpjValido() throws Exception {
		BDDMockito.given(this.comprasService.buscarPorId(Mockito.anyString()))
				.willReturn(Optional.of(this.obterDadosCompras()));

		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_COMPRAS_ID_URL + ID)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.errors").isEmpty());
	}

	private Compras obterDadosCompras() {
		Compras compras = new Compras();
		compras.setId(ID);	
		
		return compras;
	}

	
}
