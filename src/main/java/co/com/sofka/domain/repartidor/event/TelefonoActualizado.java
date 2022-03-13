package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Telefono;

public class TelefonoActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoActualizado(Telefono telefono) {
        super("domain.repartidor.telefonoactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
