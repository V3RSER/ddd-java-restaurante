package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Nombre;

public class NombreVehiculoActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreVehiculoActualizado(Nombre nombre) {
        super("domain.repartidor.nombrevehiculoactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
