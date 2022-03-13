package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Tarjeta;

public class TarjetaCompradorActualizada extends DomainEvent {
    private final Tarjeta tarjeta;

    public TarjetaCompradorActualizada(Tarjeta tarjeta) {
        super("domain.pedido.tarjetacompradoractualizada");
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
