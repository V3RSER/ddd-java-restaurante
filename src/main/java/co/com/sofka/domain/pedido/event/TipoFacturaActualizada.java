package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.TipoFactura;

public class TipoFacturaActualizada extends DomainEvent {
    private final TipoFactura tipo;

    public TipoFacturaActualizada(TipoFactura tipo) {
        super("domain.pedido.tipofacturaactualizada");
        this.tipo = tipo;
    }

    public TipoFactura getTipo() {
        return tipo;
    }
}
