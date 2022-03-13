package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Dimensiones;

public class DimensionesRecipienteActualizadas extends DomainEvent {
    private final Dimensiones dimensiones;

    public DimensionesRecipienteActualizadas(Dimensiones dimensiones) {
        super("domain.comida.dimensionesrecipienteactualizadas");
        this.dimensiones = dimensiones;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
