package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Dimensiones;

public class RecipienteActualizado extends DomainEvent {
    private final IdRecipiente idRecipiente;
    private final Dimensiones dimensiones;

    public RecipienteActualizado(IdRecipiente idRecipiente, Dimensiones dimensiones) {
        super("domain.comida.recipienteactualizado");
        this.idRecipiente = idRecipiente;
        this.dimensiones = dimensiones;
    }

    public IdRecipiente getIdRecipiente() {
        return idRecipiente;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
