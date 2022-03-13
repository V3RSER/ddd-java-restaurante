package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.TipoFactura;

public class TipoFacturaActualizada extends DomainEvent {
    private final IdFactura idFactura;
    private final TipoFactura tipo;

    public TipoFacturaActualizada(IdFactura idFactura, TipoFactura tipo) {
        super("domain.pedido.tipofacturaactualizada");
        this.idFactura = idFactura;
        this.tipo = tipo;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public TipoFactura getTipo() {
        return tipo;
    }
}
