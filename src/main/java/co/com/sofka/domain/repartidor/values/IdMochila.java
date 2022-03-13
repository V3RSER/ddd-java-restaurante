package co.com.sofka.domain.repartidor.values;

import co.com.sofka.domain.generic.Identity;

public class IdMochila extends Identity {
    private IdMochila(String valor) {
        super(valor);
    }

    public IdMochila() {
    }

    public static IdMochila of(String valor) {
        return new IdMochila(valor);
    }
}