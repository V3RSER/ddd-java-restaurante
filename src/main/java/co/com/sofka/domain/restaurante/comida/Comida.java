package co.com.sofka.domain.restaurante.comida;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.restaurante.comida.values.IdComida;
import co.com.sofka.domain.restaurante.values.DatosComida;

import java.util.Set;

public class Comida extends AggregateEvent<IdComida> {
    protected DatosComida datosComida;
    protected Set<Ingrediente> ingredientes;
    protected Recipiente recipiente;

    public Comida(IdComida idComida) {
        super(idComida);
    }

    public DatosComida datosComida() {
        return datosComida;
    }

    public Recipiente recipiente() {
        return recipiente;
    }

    public Set<Ingrediente> ingredientes() {
        return ingredientes;
    }
}