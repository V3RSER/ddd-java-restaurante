package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdFactura;

public class OrdenEntregada extends DomainEvent {
    private final IdFactura idFactura;

    public OrdenEntregada(IdFactura idFactura) {
        super("domain.pedido.ordenentregada");
        this.idFactura = idFactura;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }
}
