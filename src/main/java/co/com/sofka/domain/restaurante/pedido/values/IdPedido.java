package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdPedido extends Identity {
    private IdPedido(String valor) {
        super(valor);
    }

    public IdPedido() {
    }

    public static IdPedido of(String valor) {
        return new IdPedido(valor);
    }
}