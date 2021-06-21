package br.edu.infnet.DR4_AT_Produto.model.negocio;

import java.util.List;

public class Csv {
	
//	private List<Produto> cotacoes;
//	private Produto produto;
	
	private Short idProduto;
	private Short idCotacao;
	private String nomeProduto;
	private double preco;

	public Csv(Short idProduto, Short idCotacao, String nomeProduto, double preco) {
		this.idProduto = idProduto;
		this.idCotacao = idCotacao;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
	}

	public Short getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Short idProduto) {
		this.idProduto = idProduto;
	}
	
	public Short getIdCotacao() {
		return idCotacao;
	}
	
	public void setIdCotacao(Short idCotacao) {
		this.idCotacao = idCotacao;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

//	public Csv(Produto produto) {
//		this.produto = produto;
//	}
//
//	public List<Produto> getCotacoes() {
//		return cotacoes;
//	}
//
//	public void setCotacoes(List<Produto> cotacoes) {
//		this.cotacoes = cotacoes;
//	}
//
//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//	}

}
