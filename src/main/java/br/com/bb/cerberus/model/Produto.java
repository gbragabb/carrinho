package br.com.bb.cerberus.model;

import java.math.BigDecimal;

public class Produto {

	private String nome;
	private BigDecimal valor;
	private float desconto;
	private BigDecimal taxaExtra;
	private BigDecimal frete;

	public Produto() {
	};

	public Produto(String nome, BigDecimal valor, float desconto, BigDecimal taxaExtra, BigDecimal frete) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.desconto = desconto;
		this.taxaExtra = taxaExtra;
		this.frete = frete;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public BigDecimal getTaxaExtra() {
		return taxaExtra;
	}

	public void setTaxaExtra(BigDecimal taxaExtra) {
		this.taxaExtra = taxaExtra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getValorTotal(int qt) {
		double desconto = 1 - this.desconto/100;
		return this.valor.multiply(BigDecimal.valueOf(desconto)).multiply(BigDecimal.valueOf(qt)).add(taxaExtra).add(frete);
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "Produto: " + nome + ", Preco: R$" + valor.setScale(2).toString();
	}
}