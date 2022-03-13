package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;

public class PrecioActualizado extends DomainEvent {
    private final Dinero precio;

    public PrecioActualizado(Dinero precio) {
        super("domain.comida.precioactualizado");
        this.precio = precio;
    }

    public Dinero getPrecio() {
        return precio;
    }
}
