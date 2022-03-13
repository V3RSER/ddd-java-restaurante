package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.MetodoPago;
import co.com.sofka.domain.pedido.values.TipoFactura;

public class FacturaGenerada extends DomainEvent {
    private final IdFactura idFactura;
    private final TipoFactura tipo;
    private final Dinero costeEnvio;
    private final MetodoPago metodoPago;

    public FacturaGenerada(
            IdFactura idFactura, TipoFactura tipo, Dinero costeEnvio, MetodoPago metodoPago) {
        super("domain.pedido.facturagenerada");
        this.idFactura = idFactura;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
        this.metodoPago = metodoPago;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public TipoFactura getTipo() {
        return tipo;
    }

    public Dinero getCosteEnvio() {
        return costeEnvio;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
