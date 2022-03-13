package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Direccion;

public class DireccionDestinatarioActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionDestinatarioActualizada(Direccion direccion) {
        super("domain.pedido.direcciondestinatarioactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
