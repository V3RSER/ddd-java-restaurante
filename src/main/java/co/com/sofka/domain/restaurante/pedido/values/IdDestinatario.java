package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdDestinatario extends Identity {
    private IdDestinatario(String valor) {
        super(valor);
    }

    public IdDestinatario() {
    }

    public static IdDestinatario of(String valor) {
        return new IdDestinatario(valor);
    }
}