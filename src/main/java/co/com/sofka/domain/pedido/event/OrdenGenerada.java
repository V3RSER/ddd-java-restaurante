package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdOrden;

public class OrdenGenerada extends DomainEvent {
    private final IdOrden idOrden;

    public OrdenGenerada(IdOrden idOrden) {
        super("domain.pedido.generarorden");
        this.idOrden = idOrden;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }
}
