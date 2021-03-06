package br.edu.infnet.DR4_AT_Cotacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Cotacao;
import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Produto;
import br.edu.infnet.DR4_AT_Cotacoes.service.CotacaoService;

@RestController
public class CotacaoController {
	
	@Autowired
	private CotacaoService cotacaoService;
	
//	@Autowired
	Produto produto = new Produto();

	@Autowired
	public CotacaoController(CotacaoService cotacaoService) {
		this.cotacaoService = cotacaoService;
	}
	
	@PostMapping("/registraCotacoes")
	Cotacao registra(Double preco, String keyword) {
		produto = cotacaoService.search(keyword);
		System.out.println(produto);
		return cotacaoService.registra(preco, produto);
	}
	
	@DeleteMapping("/deletaCotacao/{id}")
	public void excluir(@PathVariable Short id) {
		cotacaoService.excluir(id);	
	}
}
