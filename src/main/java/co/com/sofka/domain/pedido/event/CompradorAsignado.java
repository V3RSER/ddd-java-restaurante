package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.Tarjeta;
import co.com.sofka.domain.values.DatosPersona;

public class CompradorAsignado extends DomainEvent {
    private final IdComprador idComprador;
    private final DatosPersona datosComprador;
    private final Tarjeta tarjetaComprador;

    public CompradorAsignado(IdComprador idComprador, DatosPersona datosComprador, Tarjeta tarjetaComprador) {
        super("domain.pedido.compradorasignado");
        this.idComprador = idComprador;
        this.datosComprador = datosComprador;
        this.tarjetaComprador = tarjetaComprador;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public DatosPersona getDatosComprador() {
        return datosComprador;
    }

    public Tarjeta getTarjetaComprador() {
        return tarjetaComprador;
    }
}
