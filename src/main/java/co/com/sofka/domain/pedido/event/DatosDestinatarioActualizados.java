package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.values.DatosPersona;

public class DatosDestinatarioActualizados extends DomainEvent {
    private final IdOrden idOrden;
    private final DatosPersona datosDestinatario;

    public DatosDestinatarioActualizados(IdOrden idOrden, DatosPersona datosDestinatario) {
        super("domain.pedido.datosdestinatarioactualizados");
        this.idOrden = idOrden;
        this.datosDestinatario = datosDestinatario;
    }
}
