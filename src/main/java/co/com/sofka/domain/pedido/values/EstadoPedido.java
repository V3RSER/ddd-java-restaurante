package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoPedido implements ValueObject<EstadoPedido.Fase> {
    private final Fase estado;

    public EstadoPedido(Fase estado) {
        this.estado = Objects.requireNonNull(estado, "El estado no debe ser nulo");
    }

    @Override
    public Fase value() {
        return estado;
    }

    public enum Fase {
        ENTREGADO, NO_ENTREGADO
    }
}
