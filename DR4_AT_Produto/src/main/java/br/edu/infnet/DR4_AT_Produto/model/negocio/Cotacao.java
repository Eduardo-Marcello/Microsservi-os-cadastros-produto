package br.edu.infnet.DR4_AT_Produto.model.negocio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cotacoes")
public class Cotacao implements Serializable {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_cotacao")
	 private Short id;
	 private double preco;
	 
	 @JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "id_produto", nullable = false)
	 private Produto produto;
	 
	 public Cotacao(){
		 
	 }

	public Cotacao(double preco, Produto produto) {
		this.preco = preco;
		this.produto = produto;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Cotacao [id=" + id + ", preco=" + preco + "]";
	}
}
