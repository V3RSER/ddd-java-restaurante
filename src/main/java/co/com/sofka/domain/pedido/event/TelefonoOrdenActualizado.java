package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Telefono;

public class TelefonoOrdenActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoOrdenActualizado(Telefono telefono) {
        super("domain.pedido.telefonoordenactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
