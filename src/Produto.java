import interfaces.Descontavel;

import static utils.Helpers.brl;

public class Produto implements Descontavel {
    protected static long total = 0;
    protected long id;
    protected double preco;
    protected String titulo;
    protected String descricao;
    protected int estoque;

    public Produto(double preco, int estoque, String titulo) {
        this(preco, estoque, titulo, "");
    }

    public Produto(double preco, int estoque, String titulo, String descricao) {
        this.id = ++ total;
        this.preco = preco;
        this.estoque = estoque;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return this.getId()
            + " - " + this.getTitulo()
            + (this.getDescricao().isEmpty() ?  "" : " - " + this.getDescricao())
            + " - " + brl(this.getPreco())
        ;
    }
}
