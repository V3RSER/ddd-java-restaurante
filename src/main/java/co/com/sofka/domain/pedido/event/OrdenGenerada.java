package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdOrden;

public class OrdenGenerada extends DomainEvent {
    private final IdOrden idOrden;
    private final IdDestinatario idDestinatario;

    public OrdenGenerada(IdOrden idOrden, IdDestinatario idDestinatario) {
        super("domain.pedido.ordengenerada");
        this.idOrden = idOrden;
        this.idDestinatario = idDestinatario;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }
}
