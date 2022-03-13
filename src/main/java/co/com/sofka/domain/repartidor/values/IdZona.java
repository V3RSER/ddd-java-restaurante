package co.com.sofka.domain.repartidor.values;

import co.com.sofka.domain.generic.Identity;

public class IdZona extends Identity {
    private IdZona(String valor) {
        super(valor);
    }

    public IdZona() {
    }

    public static IdZona of(String valor) {
        return new IdZona(valor);
    }
}