package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.values.Telefono;

public class TelefonoCompradorActualizado extends DomainEvent {
    private final IdComprador idComprador;
    private final Telefono telefono;

    public TelefonoCompradorActualizado(IdComprador idComprador, Telefono telefono) {
        super("domain.pedido.telefonocompradoractualizado");
        this.idComprador = idComprador;
        this.telefono = telefono;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
