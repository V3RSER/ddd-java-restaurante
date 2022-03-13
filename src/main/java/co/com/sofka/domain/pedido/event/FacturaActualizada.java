package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.TipoFactura;
import co.com.sofka.domain.values.DatosComida;

import java.util.Set;

public class FacturaActualizada extends DomainEvent {
    private final IdFactura idFactura;
    private final Set<DatosComida> datosComidas;
    private final TipoFactura tipo;
    private final Dinero costeEnvio;

    public FacturaActualizada(IdFactura idFactura, Set<DatosComida> datosComidas,
                              TipoFactura tipo, Dinero costeEnvio) {
        super("domain.pedido.facturaactualizada");
        this.idFactura = idFactura;
        this.datosComidas = datosComidas;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public Set<DatosComida> getDatosComidas() {
        return datosComidas;
    }

    public TipoFactura getTipo() {
        return tipo;
    }

    public Dinero getCosteEnvio() {
        return costeEnvio;
    }
}
