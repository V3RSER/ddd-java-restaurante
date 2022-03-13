package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Telefono;

public class TelefonoDestinatarioActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoDestinatarioActualizado(Telefono telefono) {
        super("domain.pedido.telefonodestinatarioactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
