package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Nombre;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("domain.comida.nombreactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
