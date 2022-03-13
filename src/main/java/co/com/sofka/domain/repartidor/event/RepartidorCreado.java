package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.DatosPersona;

public class RepartidorCreado extends DomainEvent {
    private final DatosPersona datosPersona;

    public RepartidorCreado(DatosPersona datosPersona) {
        super("domain.repartidor.repartidorcreado");
        this.datosPersona = datosPersona;
    }

    public DatosPersona getDatosPersona() {
        return datosPersona;
    }
}
