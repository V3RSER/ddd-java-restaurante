package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Dimensiones;

public class DimensionesMochilaActualizadas extends DomainEvent {
    private final Dimensiones dimensiones;

    public DimensionesMochilaActualizadas(Dimensiones dimensiones) {
        super("domain.repartidor.dimensionesmochilaactualizadas");
        this.dimensiones = dimensiones;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
