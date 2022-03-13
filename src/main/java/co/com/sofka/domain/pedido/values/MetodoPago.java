package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetodoPago implements ValueObject<MetodoPago.Tipo> {
    private final Tipo metodo;

    public MetodoPago(Tipo metodo) {
        this.metodo = Objects.requireNonNull(metodo, "El tipo de método no debe ser nulo");
    }

    @Override
    public Tipo value() {
        return metodo;
    }

    public enum Tipo {
        EFECTIVO, TARJETA
    }
}
