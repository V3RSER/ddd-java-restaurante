package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Dimensiones;

public class RecipienteAgregado extends DomainEvent {
    private final IdRecipiente idRecipiente;
    private final Dimensiones dimensiones;

    public RecipienteAgregado(IdRecipiente idRecipiente, Dimensiones dimensiones) {
        super("domain.comida.recipienteagregado");
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
