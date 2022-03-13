package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.values.Telefono;

public class TelefonoDestinatarioActualizado extends DomainEvent {
    private final IdDestinatario idDestinatario;
    private final Telefono telefono;

    public TelefonoDestinatarioActualizado(IdDestinatario idDestinatario, Telefono telefono) {
        super("domain.pedido.telefonodestinatarioactualizado");
        this.idDestinatario = idDestinatario;
        this.telefono = telefono;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
