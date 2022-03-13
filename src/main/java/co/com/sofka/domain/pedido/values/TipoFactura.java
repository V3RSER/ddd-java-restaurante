package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoFactura implements ValueObject<TipoFactura.Fase> {
    private final Fase tipo;

    public TipoFactura(Fase tipo) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo no debe ser nulo");
    }

    @Override
    public Fase value() {
        return tipo;
    }

    public enum Fase {
        DIGITAL, FISICA
    }
}
