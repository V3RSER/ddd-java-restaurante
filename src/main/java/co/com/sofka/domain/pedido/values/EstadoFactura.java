package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoFactura implements ValueObject<EstadoFactura.Fase> {
    private final Fase estado;

    public EstadoFactura(Fase estado) {
        this.estado = Objects.requireNonNull(estado, "El estado no debe ser nulo");
    }

    @Override
    public Fase value() {
        return estado;
    }

    public enum Fase {
        PAGADO, NO_PAGADO
    }
}
