package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdComprador extends Identity {
    private IdComprador(String valor) {
        super(valor);
    }

    public IdComprador() {
    }

    public static IdComprador of(String valor) {
        return new IdComprador(valor);
    }
}