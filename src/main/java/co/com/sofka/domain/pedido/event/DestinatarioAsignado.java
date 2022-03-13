package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.values.DatosPersona;

public class DestinatarioAsignado extends DomainEvent {
    private final IdDestinatario idDestinatario;
    private final DatosPersona datosDestinatario;
    private final Direccion direccionDestinatario;
    private final Dinero efectivoDestinatario;

    public DestinatarioAsignado(
            IdDestinatario idDestinatario, DatosPersona datosDestinatario, Direccion direccionDestinatario, Dinero efectivoDestinatario) {
        super("domain.pedido.destinatarioasignado");
        this.idDestinatario = idDestinatario;
        this.datosDestinatario = datosDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.efectivoDestinatario = efectivoDestinatario;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public DatosPersona getDatosDestinatario() {
        return datosDestinatario;
    }

    public Direccion getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public Dinero getEfectivoDestinatario() {
        return efectivoDestinatario;
    }
}
