package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdDestinatario;

public class DireccionDestinatarioActualizada extends DomainEvent {
    private final IdDestinatario idDestinatario;
    private final Direccion direccion;

    public DireccionDestinatarioActualizada(IdDestinatario idDestinatario, Direccion direccion) {
        super("domain.pedido.direcciondestinatarioactualizada");
        this.idDestinatario = idDestinatario;
        this.direccion = direccion;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
