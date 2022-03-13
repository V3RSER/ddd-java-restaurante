package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Descripcion;

public class DescripcionIngredienteActualizada extends DomainEvent {
    private final IdIngrediente idIngrediente;
    private final Descripcion descripcion;

    public DescripcionIngredienteActualizada(IdIngrediente idIngrediente, Descripcion descripcion) {
        super("domain.comida.descripcioningredienteactualizada");
        this.idIngrediente = idIngrediente;
        this.descripcion = descripcion;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
