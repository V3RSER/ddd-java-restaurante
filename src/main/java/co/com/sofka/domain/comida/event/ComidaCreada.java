package co.com.sofka.domain.comida.event;

import co.com.sofka.domain.comida.Ingrediente;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.DatosComida;

import java.util.Set;

public class ComidaCreada extends DomainEvent {
    private final DatosComida datos;
    private final Set<Ingrediente> ingredientes;

    public ComidaCreada(DatosComida datos, Set<Ingrediente> ingredientes) {
        super("domain.comida.comidacreada");
        this.datos = datos;
        this.ingredientes = ingredientes;
    }

    public DatosComida getDatos() {
        return datos;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}
