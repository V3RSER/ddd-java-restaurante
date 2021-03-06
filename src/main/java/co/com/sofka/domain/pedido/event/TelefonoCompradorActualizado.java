package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Telefono;

public class TelefonoCompradorActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoCompradorActualizado(Telefono telefono) {
        super("domain.pedido.telefonocompradoractualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
