package interfaces;

import exceptions.EstoqueInsuficienteException;

public interface Compravel {
    public abstract long getId();

    public abstract int getEstoque();

    public abstract void setEstoque(int estoque);

    public abstract double getPreco();

    public abstract void setPreco(double preco);

    public default void comprar() throws EstoqueInsuficienteException {
        this.comprar(1);
    }

    public default void comprar(int n) throws EstoqueInsuficienteException {
        if (n > this.getEstoque()) {
            throw new EstoqueInsuficienteException();
        }

        this.setEstoque(this.getEstoque() - n);
    }

    public default boolean temEstoque(int n) {
        return n <= this.getEstoque();
    }
}
