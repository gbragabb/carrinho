import exceptions.ItemNaoEncontradoNoCarrinhoException;
import exceptions.QuantidadeAcimaEtcException;
import interfaces.Compravel;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import static utils.Helpers.brl;

public class Carrinho {
    private HashMap<Compravel, AtomicInteger> conteudo;

    public Carrinho(HashMap<Compravel, AtomicInteger> conteudo) {
        this.conteudo = conteudo;
    }

    public Carrinho() {
        this(new HashMap<>());
    }

    public void esvaziar() {
        this.conteudo = new HashMap<>();
    }

    public AtomicInteger getItem(Compravel produto)
            throws ItemNaoEncontradoNoCarrinhoException
    {
        if ( ! this.conteudo.containsKey(produto)) {
            throw new ItemNaoEncontradoNoCarrinhoException();
        }

        return this.conteudo.get(produto);
    }

    public Carrinho removerTodos(Compravel produto)
        throws ItemNaoEncontradoNoCarrinhoException
    {
        this.getItem(produto);

        this.conteudo.remove(produto);

        return this;
    }

    public Carrinho remover(Compravel produto, int quantidade)
        throws ItemNaoEncontradoNoCarrinhoException, QuantidadeAcimaEtcException
    {
        int atual = this.getItem(produto).intValue();

        if (quantidade > atual) {
            throw new QuantidadeAcimaEtcException();
        }

        if (quantidade == atual) {
            this.conteudo.remove(produto);

            return this;
        }

        this.conteudo.get(produto).addAndGet( - quantidade);

        return this;
    }

    public Carrinho adicionar(Compravel produto) {
        return adicionar(produto, 1);
    }

    // @TODO validar quantidade
    public Carrinho adicionar(Compravel produto, int quantidade) {
        this.conteudo.putIfAbsent(produto, new AtomicInteger(0));
        this.conteudo.get(produto).addAndGet(quantidade);

        return this;
    }

    private Stream<Entry<Compravel, AtomicInteger>> conteudo() {
        return this.conteudo.entrySet().stream();
    }

    public double total() {
        return this.conteudo().mapToDouble(Carrinho::precoTotal).sum();
    }

    private static double precoTotal(Entry<Compravel, AtomicInteger> e) {
        return e.getValue().doubleValue() * e.getKey().getPreco();
    }

    private static String formataLinha(Entry<Compravel, AtomicInteger> e) {
        return e.getKey().toString() + " x" + e.getValue() + " " + brl(precoTotal(e)) + "\n";
    }

    public String toString() {
        return this.conteudo()
                .map(Carrinho::formataLinha)
                .reduce("", String::concat)
            + "Total: " + brl(this.total())
        ;
    }
}
