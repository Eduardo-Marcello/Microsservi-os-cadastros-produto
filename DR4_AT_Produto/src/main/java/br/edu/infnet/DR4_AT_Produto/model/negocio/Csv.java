package br.edu.infnet.DR4_AT_Produto.model.negocio;

import java.util.List;

public class Csv {
	
	private List<Produto> cotacoes;
	private Produto produto;

	public Csv(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Produto> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
