package interfaces;

import exceptions.DescontoInaplicavelException;

public interface Descontavel extends Compravel {

    public default double aplicarDesconto(double desconto) throws DescontoInaplicavelException {
        double preco = this.getPreco() - desconto;

        if (0 > preco) {
            throw new DescontoInaplicavelException();
        }

        this.setPreco(preco);

        return this.getPreco();
    }

    public default double aplicarDescontoPercentual(double percentual) {
        if (100 < percentual) {
            throw new IllegalArgumentException();
        }

        this.setPreco((100d - percentual) / 100 * this.getPreco());

        return this.getPreco();
    }
}
