package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Nombre;

public class NombreIngredienteActualizado extends DomainEvent {
    private final IdIngrediente idIngrediente;
    private final Nombre nombre;

    public NombreIngredienteActualizado(IdIngrediente idIngrediente, Nombre nombre) {
        super("domain.comida.nombreingredienteactualizado");
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
