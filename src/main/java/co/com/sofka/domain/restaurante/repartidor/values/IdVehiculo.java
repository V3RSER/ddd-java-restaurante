package co.com.sofka.domain.restaurante.repartidor.values;

import co.com.sofka.domain.generic.Identity;

public class IdVehiculo extends Identity {
    private IdVehiculo(String valor) {
        super(valor);
    }

    public IdVehiculo() {
    }

    public static IdVehiculo of(String valor) {
        return new IdVehiculo(valor);
    }
}