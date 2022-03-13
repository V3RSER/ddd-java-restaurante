package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Nombre;

public class IngredienteActualizado extends DomainEvent {
    private final IdIngrediente idIngrediente;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public IngredienteActualizado(IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        super("domain.comida.ingredienteactualizado");
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
