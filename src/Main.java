import exceptions.DescontoInaplicavelException;
import exceptions.EstoqueInsuficienteException;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto(1000, 9, "Brusinha");
        System.out.println(produto + " - Estoque: " + produto.getEstoque());

        produto.aplicarDescontoPercentual(30);
        System.out.println(produto + " - Estoque: " + produto.getEstoque());

        try {
            produto.comprar(5);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Tem, mas acabou.");
        }

        try {
            produto.aplicarDesconto(123);
            System.out.println(produto + " - Estoque: " + produto.getEstoque());
        } catch (DescontoInaplicavelException e) {
            System.out.println("Pode não, more.");
        }
    }
}
