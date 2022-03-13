package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.DomainEvent;

public class IngredienteQuitado extends DomainEvent {
    private final IdIngrediente idIngrediente;

    public IngredienteQuitado(IdIngrediente idIngrediente) {
        super("domain.comida.ingredientequitado");
        this.idIngrediente = idIngrediente;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }
}
