package br.com.bb.cerberus.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.bb.cerberus.utils.PrintUtils;

public class Carrinho {
	
	private Cliente dono;
    private HashMap<Produto, Integer> produtos = new HashMap<Produto, Integer>();

    public Carrinho(Cliente dono) {
    	this.dono = dono;
    }
    
    public List<Produto> obterProdutos(){
		return new ArrayList<Produto>(this.produtos.keySet());
	}
    
    public void limpar() {
    	this.produtos.clear();
    }
    
    public void lista(){
    	PrintUtils.cabecalho("Carrinho de " + dono.getNmCLiente());
    	if (produtos.size() > 0) {
    		produtos.keySet().forEach(s-> System.out.println(s.toString() + ", Quantidade: "+ produtos.get(s)));
    	}else {
    		System.out.println("Carrinho Vazio");
    	}
        
    }

    public BigDecimal calculaTotal(){
        //BigDecimal total = BigDecimal.ZERO;
        //produtos.keySet().forEach(p -> total.add(p.getValor().multiply(BigDecimal.valueOf(produtos.get(p)))));
        //Calcula a soma de todos os produtos salvos. 
    	//Valor do produto � calculado em produto de acordo com descontos e taxas.
    	return produtos
        		.keySet()
        		.stream()
        		.map(e-> e.getValorTotal(produtos.get(e)))
        		.reduce(new BigDecimal(0), (acc, e) -> acc.add(e))
        		.setScale(2, RoundingMode.HALF_DOWN);
    }
    
    public void printTotal() {
    	System.out.println("Total: R$ " + this.calculaTotal());
    }

    public void adiciona(Produto p){
        if(produtos.containsKey(p)){
            produtos.put(p, produtos.get(p)+1);
        }else{
            produtos.put(p, 1);
        }
    }

    public void alteraQuantidade(Produto p, int qt){
		if(0 > qt) {
			throw new IllegalArgumentException("Quantidade de produtos n�o pode ser negativa.");
		}
    	//Ao colocar uma quantidade 0 � an�logo � remover do carrinho
    	if(qt == 0) {
    		this.remove(p);
    	}else {
    		produtos.put(p, qt);
    	}
    }

    public void remove(Produto p){
        produtos.remove(p);
    }

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}
}