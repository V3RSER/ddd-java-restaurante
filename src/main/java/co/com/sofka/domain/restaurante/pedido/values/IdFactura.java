package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IdFactura extends Identity {
    private IdFactura(String valor) {
        super(valor);
    }

    public IdFactura() {
    }

    public static IdFactura of(String valor) {
        return new IdFactura(valor);
    }
}