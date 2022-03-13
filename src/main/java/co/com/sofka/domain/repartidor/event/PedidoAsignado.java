package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdPedido;

public class PedidoAsignado extends DomainEvent {
    private final IdPedido pedido;

    public PedidoAsignado(IdPedido pedido) {
        super("domain.repartidor.pedidoasignado");
        this.pedido = pedido;
    }

    public IdPedido getPedido() {
        return pedido;
    }
}
