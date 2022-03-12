package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdOrden extends Identity {
    private IdOrden(String valor) {
        super(valor);
    }

    public IdOrden() {
    }

    public static IdOrden of(String valor) {
        return new IdOrden(valor);
    }
}