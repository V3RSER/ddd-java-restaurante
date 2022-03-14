package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.*;

public class FacturaGenerada extends DomainEvent {
    private final IdFactura idFactura;
    private final TipoFactura tipo;
    private final Dinero costeEnvio;
    private final MetodoPago metodoPago;
    private final IdComprador idComprador;

    public FacturaGenerada(IdFactura idFactura, TipoFactura tipo, Dinero costeEnvio, MetodoPago metodoPago,
                           IdComprador idComprador) {
        super("domain.pedido.facturagenerada");
        this.idFactura = idFactura;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
        this.metodoPago = metodoPago;
        this.idComprador = idComprador;
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

    public IdComprador getIdComprador() {
        return idComprador;
    }
}
