package br.edu.infnet.DR4_AT_Cotacoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Cotacao;
import br.edu.infnet.DR4_AT_Cotacoes.model.negocio.Produto;
import br.edu.infnet.DR4_AT_Cotacoes.repository.ICotacaoRepository;

@Service
public class CotacaoService {
	
	@Autowired
	private ICotacaoRepository cr;
	
//	@Autowired
	private Produto produto = new Produto();
	
	public CotacaoService(ICotacaoRepository cr) {
        this.cr = cr;
    }
	
	public Produto search(String keyword){
		produto = cr.search(keyword);
		return produto;
	}
	
	public Cotacao registra(Double preco, Produto produto) {
		Cotacao cotacao = new Cotacao(preco, produto);
		return this.cr.save(cotacao);
	}
	
	public void excluir(Short id) {
		this.cr.deleteById(id);
	}
	
}
