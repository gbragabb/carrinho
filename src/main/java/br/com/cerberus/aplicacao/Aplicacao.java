package br.com.cerberus.aplicacao;
import java.math.BigDecimal;
import br.com.cerberus.utils.PrintUtils;

import br.com.bb.cerberus.model.Carrinho;
import br.com.bb.cerberus.model.Cliente;
import br.com.bb.cerberus.model.PF;
import br.com.bb.cerberus.model.PJ;
import br.com.bb.cerberus.model.Produto;
import br.com.cerberus.repositories.ClienteRepository;
import br.com.cerberus.repositories.ProdutoRepository;
import br.com.cerberus.utils.PrintUtils;

public class Aplicacao {

	public static void main(String[] args) {

		//Repositorios
		ClienteRepository cliRepo = new ClienteRepository();
		ProdutoRepository prodRepo = new ProdutoRepository();
		
		//Produtos
		Produto p1 = new Produto("Produto 1", 
				BigDecimal.valueOf(12.80).setScale(2), 
				0, 
				BigDecimal.ZERO,
				BigDecimal.ZERO);

		Produto p2 = new Produto("Produto 2", 
				BigDecimal.valueOf(44.90).setScale(2), 
				10, 
				BigDecimal.valueOf(10).setScale(2),
				BigDecimal.ZERO);

		Produto p3 = new Produto("Produto 3", 
				BigDecimal.valueOf(149.90).setScale(2), 
				5, 
				BigDecimal.ZERO,
				BigDecimal.valueOf(30));
		
		Produto p4 = new Produto("Produto 4", 
				BigDecimal.valueOf(234.90).setScale(2), 
				0, 
				BigDecimal.ZERO,
				BigDecimal.valueOf(40));
		
		Produto p5 = new Produto("Produto 5", 
				BigDecimal.valueOf(1399.90).setScale(2), 
				20, 
				BigDecimal.ZERO,
				BigDecimal.valueOf(110));
		
		Produto pRemover = new Produto("Produto a ser removido", 
				BigDecimal.valueOf(99.99).setScale(2), 
				99, 
				BigDecimal.ZERO,
				BigDecimal.ZERO);
		
		//Clientes
		Cliente c1 = new PF("Arthur", "12312312311");
		Cliente c2 = new PF("Gabriel", "78978978900");
		Cliente c3 = new PJ("Padaria Massa Fina", "78706557000130");
		
		//Adiciona os clientes e produtos aos repos
		prodRepo.add(p1);
		prodRepo.add(p2);
		prodRepo.add(p3);
		prodRepo.add(p4);
		prodRepo.add(p5);
		prodRepo.add(pRemover);
		cliRepo.add(c1);
		cliRepo.add(c2);
		cliRepo.add(c3);

		//Mostra os objetos salvos
		PrintUtils.cabecalho("Produtos");
		prodRepo.show();
		PrintUtils.cabecalho("Clientes");
		cliRepo.show();
		
		PrintUtils.cabecalho("Produtos Chave/Valor");
		//mostra lista com objeto e o id
		prodRepo.showListaChaveValor();
		
		//Remove o item com ID == 6
		prodRepo.remove(6);
		
		//Mostra a lista já com o item remoido
		PrintUtils.cabecalho("Produtos");
		prodRepo.show();
		PrintUtils.cabecalho("Produtos Chave/Valor");
		prodRepo.showListaChaveValor();
		
		//Cria dois carrinhos com os respectivos donos
		Carrinho carr1 = new Carrinho(c1);
		Carrinho carr2 = new Carrinho(c2);
		
		//Mostra Carrinho vazio
		carr1.lista();
		carr2.lista();
		
		//Adiciona produtos ao carrinho 1
		carr1.adiciona(p1);
		carr1.adiciona(p2);
		
		//Lista os items do carrinho 1
		carr1.lista();
		System.out.println(carr1.calculaTotal());
		//Printa o total dos items de 1
		carr1.printTotal();
		
		//Adiciona produto 2 duas vezes, apenas aumenta a quantidade
		carr1.adiciona(p2);
		carr1.adiciona(p2);
		carr1.lista();
		carr1.printTotal();
		
		//Altera a quantidade de um item
		carr1.alteraQuantidade(p1, 5);
		carr1.lista();
		carr1.printTotal();
		
		//Remove um item do carrinho
		carr1.remove(p1);
		carr1.lista();
		carr1.printTotal();
		
		//Altera a quantidade para 0, mesmo que remover
		carr1.alteraQuantidade(p2, 0);
		carr1.lista();
		carr1.printTotal();
		
	}
}
