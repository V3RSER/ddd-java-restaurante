package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.MetodoPago;

import java.util.Set;

public class PedidoCreado extends DomainEvent {
    private final Set<IdComida> idProductos;
    private final MetodoPago metodoPago;

    public PedidoCreado(Set<IdComida> idProductos, MetodoPago metodoPago) {
        super("domain.pedido.pedidocreado");
        this.idProductos = idProductos;
        this.metodoPago = metodoPago;
    }

    public Set<IdComida> getIdProductos() {
        return idProductos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
