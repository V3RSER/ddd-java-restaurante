package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Direccion;

public class DireccionEntregaActualizada extends DomainEvent {
    private final Direccion direccionEntrega;

    public DireccionEntregaActualizada(Direccion direccionEntrega) {
        super("domain.pedido.direccionentregaactualizada");
        this.direccionEntrega = direccionEntrega;
    }

    public Direccion getDireccionEntrega() {
        return direccionEntrega;
    }
}
