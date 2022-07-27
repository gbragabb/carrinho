package br.com.bb.cerberus.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class Carrinho {
    HashMap<Produto, Integer> produtos = new HashMap<>();

    public void lista(){
        produtos.keySet().forEach(System.out::println);
    }

    public BigDecimal calculaTotal(){
        BigDecimal total = BigDecimal.ZERO;
        produtos.keySet().forEach(p -> total.add(p.getValor().multiply(BigDecimal.valueOf(produtos.get(p)))));
        return total;
    }

    public void adiciona(Produto p){
        if(produtos.containsKey(p)){
            produtos.put(p, produtos.get(p)+1);
        }else{
            produtos.put(p, 1);
        }
    }

    public void alteraQuantidade(Produto p, int qt){
        produtos.put(p, qt);
    }

    public void remove(Produto p){
        produtos.remove(p);
    }
}
