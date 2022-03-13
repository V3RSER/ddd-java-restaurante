package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdOrden;

public class DireccionEntregaActualizada extends DomainEvent {
    private final IdOrden idOrden;
    private final Direccion direccionEntrega;

    public DireccionEntregaActualizada(IdOrden idOrden, Direccion direccionEntrega) {
        super("domain.pedido.direccionentregaactualizada");
        this.idOrden = idOrden;
        this.direccionEntrega = direccionEntrega;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public Direccion getDireccionEntrega() {
        return direccionEntrega;
    }
}
