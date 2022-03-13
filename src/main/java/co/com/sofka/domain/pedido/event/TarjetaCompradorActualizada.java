package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.Tarjeta;

public class TarjetaCompradorActualizada extends DomainEvent {
    private final IdComprador idComprador;
    private final Tarjeta tarjeta;

    public TarjetaCompradorActualizada(IdComprador idComprador, Tarjeta tarjeta) {
        super("domain.pedido.tarjetacompradoractualizada");
        this.idComprador = idComprador;
        this.tarjeta = tarjeta;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
