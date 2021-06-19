package br.edu.infnet.DR4_AT_Cotacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Cotacao;
import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Produto;
import br.edu.infnet.DR4_AT_Cotacoes.service.CotacaoService;

@RestController
@RequestMapping(path = "/cotacoes")
public class CotacaoController {
	
	@Autowired
	private CotacaoService cotacaoService;
	
//	@Autowired
	Produto produto = new Produto();

	@Autowired
	public CotacaoController(CotacaoService cotacaoService) {
		this.cotacaoService = cotacaoService;
	}
	
	@PostMapping(value = "/registraCotacoes")
	Cotacao registra(Double preco, String keyword) {
		produto = cotacaoService.search(keyword);
		System.out.println("OI");
		System.out.println(produto);
		return cotacaoService.registra(preco, produto);
	}
	
	@PostMapping(value = "/ListaCotacoes")
	public List<Cotacao> findList(String keyword) {
//		List<Cotacao> c = cotacaoService.findCotacoes(keyword);
//		System.out.println(c);
		return cotacaoService.findCotacoes(keyword);
	}
	
	@DeleteMapping(value = "/deletaCotacao/{id}")
	public void excluir(@PathVariable Short id) {
		cotacaoService.excluir(id);	
	}
}
