package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdPedido;

public class OrdenEntregada extends DomainEvent {
    private final IdPedido idOrden;

    public OrdenEntregada(IdPedido idOrden) {
        super("domain.pedido.ordenentregada");
        this.idOrden = idOrden;
    }

    public IdPedido getIdOrden() {
        return idOrden;
    }
}
