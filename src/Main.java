import exceptions.DescontoInaplicavelException;
import exceptions.EstoqueInsuficienteException;
import exceptions.ItemNaoEncontradoNoCarrinhoException;
import exceptions.QuantidadeAcimaEtcException;

public class Main {
    public static void main(String[] args) {
        Produto brusinha = new Produto(100, 9, "Brusinha");
        Produto camiseta = new Produto(35, 50, "Camiseta");
        Produto paozinho = new Produto(3.99, 50, "Pãozinho");
        //System.out.println(brusinha + " - Estoque: " + brusinha.getEstoque());

        brusinha.aplicarDescontoPercentual(30);
        //System.out.println(brusinha + " - Estoque: " + brusinha.getEstoque());

        try {
            brusinha.comprar(5);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Tem, mas acabou.");
        }

        try {
            brusinha.aplicarDesconto(12);
            //System.out.println(brusinha + " - Estoque: " + brusinha.getEstoque());
        } catch (DescontoInaplicavelException e) {
            System.out.println("Pode não, more.");
        }

        Carrinho carrinho = new Carrinho();

        try {
            carrinho.adicionar(brusinha).removerTodos(brusinha).adicionar(camiseta, 5);
            //System.out.println(carrinho);
            carrinho.adicionar(paozinho, 4).adicionar(brusinha).remover(camiseta, 2);
            System.out.println(carrinho);
        } catch (ItemNaoEncontradoNoCarrinhoException | QuantidadeAcimaEtcException e) {

        }

    }
}
