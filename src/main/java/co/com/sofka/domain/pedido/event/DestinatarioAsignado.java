package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.values.DatosPersona;

public class DestinatarioAsignado extends DomainEvent {
    private final IdDestinatario idDestinatario;
    private final DatosPersona datosDestinatario;
    private final Dinero dineroDestinatario;

    public DestinatarioAsignado(IdDestinatario idDestinatario, DatosPersona datosDestinatario,
                                Dinero dineroDestinatario) {
        super("domain.pedido.destinatarioasignado");
        this.idDestinatario = idDestinatario;
        this.datosDestinatario = datosDestinatario;
        this.dineroDestinatario = dineroDestinatario;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public DatosPersona getDatosDestinatario() {
        return datosDestinatario;
    }

    public Dinero getDineroDestinatario() {
        return dineroDestinatario;
    }
}
