package com.altran.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altran.api.dto.ComprasDto;
import com.altran.api.dto.ItemDto;
import com.altran.api.dto.UsuarioDto;
import com.altran.api.entities.Compras;
import com.altran.api.entities.Item;
import com.altran.api.response.Response;
import com.altran.api.services.ComprasService;


@RestController
@RequestMapping("/api/compras-itens")
@CrossOrigin(origins = "*")
public class ComprasController {
	
	private static final Logger log = LoggerFactory.getLogger(ComprasController.class);
	
	@Autowired
	private ComprasService comprasService;

	
	private final static String ORDER_DAFAUL = "NOME"; 
	
	public ComprasController () {
		
	}
	
	
	/**
	 * Busca os itens de carrinho de compras
	 * 
	 * @param comprasId
	 * @param result
	 * @return ResponseEntity<Response<CadastroPJDto>>
	 * @throws NoSuchAlgorithmException
	 */
	@GetMapping(value = "/detalhes/{comprasId}")	
	public ResponseEntity<Response<ComprasDto>> listarComprasPorId(
			@PathVariable("comprasId") String comprasId,
			@RequestParam(value = "Ord", defaultValue = "NOME") String ordenacao,
			BindingResult result) throws NoSuchAlgorithmException  {
		
		log.info("Buscando compras por ID : {}", comprasId);
		Response<ComprasDto> response = new Response<ComprasDto>();

		
		Optional<Compras> compras = this.comprasService.buscarPorId(comprasId);
		
		if (!compras.isPresent()) {
			result.addError(new ObjectError("compras", "Compras não encontrada."));
		}
		

		if (result.hasErrors()) {			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterComprasDto(compras.get(), ordenacao));

		return ResponseEntity.ok(response);
	}
	
	
	/**
	 * Retorna um DTO com os dados da compra.
	 * 
	 * @param compras
	 * @return ComprasDto
	 */
	private ComprasDto converterComprasDto(Compras compras, String order) {
		ComprasDto comprasDto = new ComprasDto();
		
		comprasDto.setId(compras.getId());
		comprasDto.setData(compras.getData());
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setEmail(compras.getUser().getEmail());
		usuarioDto.setId(compras.getUser().getId());
		usuarioDto.setIdade(compras.getUser().getIdade());
		usuarioDto.setNome(compras.getUser().getNome());		
		comprasDto.setUser(usuarioDto);
		
		List<Item> itensOrder;
		if (ORDER_DAFAUL.equalsIgnoreCase(order)) {
			Comparator<Item> byNomeItem = Comparator.comparing(Item -> Item.getNome());			
			itensOrder = compras.getItens().stream().sorted(byNomeItem).collect(Collectors.toList());
		} else {
			Comparator<Item> byNomeItem = Comparator.comparing(Item -> Item.getNome());			
			itensOrder = compras.getItens().stream().sorted(byNomeItem).collect(Collectors.toList());			
		}
		
		List<ItemDto> itensDto = new ArrayList<ItemDto>();
		for (Item itemCompra : itensOrder) {
			ItemDto itemDto = new ItemDto();
			itemDto.setId(itemCompra.getId());
			itemDto.setNome(itemCompra.getNome());
			itemDto.setValor(itemCompra.getValor());
			itensDto.add(itemDto);
		}
		
		comprasDto.setItensDto(itensDto);
		
		return comprasDto;
	}

}
