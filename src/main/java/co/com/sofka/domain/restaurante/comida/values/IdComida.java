package co.com.sofka.domain.restaurante.comida.values;

import co.com.sofka.domain.generic.Identity;

public class IdComida extends Identity {
    private IdComida(String valor) {
        super(valor);
    }

    public IdComida() {
    }

    public static IdComida of(String valor) {
        return new IdComida(valor);
    }
}