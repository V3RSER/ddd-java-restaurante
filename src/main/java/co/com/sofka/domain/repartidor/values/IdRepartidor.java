package co.com.sofka.domain.repartidor.values;

import co.com.sofka.domain.generic.Identity;

public class IdRepartidor extends Identity {
    private IdRepartidor(String valor) {
        super(valor);
    }

    public IdRepartidor() {
    }

    public static IdRepartidor of(String valor) {
        return new IdRepartidor(valor);
    }
}