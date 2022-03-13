package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdPedido;

public class PedidoQuitado extends DomainEvent {
    private final IdPedido pedido;

    public PedidoQuitado(IdPedido pedido) {
        super("domain.repartidor.pedidoquitado");
        this.pedido = pedido;
    }

    public IdPedido getPedido() {
        return pedido;
    }
}
