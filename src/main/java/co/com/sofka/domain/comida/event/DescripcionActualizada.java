package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Descripcion;

public class DescripcionActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionActualizada(Descripcion descripcion) {
        super("domain.comida.descripcionactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
