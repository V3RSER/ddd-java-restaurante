package co.com.sofka.domain.comida;

import co.com.sofka.domain.comida.event.*;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Dimensiones;
import co.com.sofka.domain.values.Nombre;

import java.util.List;
import java.util.Set;

public class Comida extends AggregateEvent<IdComida> {
    protected DatosComida datos;
    protected Set<Ingrediente> ingredientes;
    protected Recipiente recipiente;

    public Comida(IdComida idComida, DatosComida datos, Set<Ingrediente> ingredientes) {
        super(idComida);
        appendChange(new ComidaCreada(datos, ingredientes)).apply();
        subscribe(new ComidaChange(this));
    }

    public Comida(IdComida idComida) {
        super(idComida);
        subscribe(new ComidaChange(this));
    }

    public static Comida from(IdComida idComida, List<DomainEvent> retrieveEvents) {
        var comida = new Comida(idComida);
        retrieveEvents.forEach(comida::applyEvent);
        return comida;
    }

    public void actualizarNombre(Nombre nombre) {
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        appendChange(new DescripcionActualizada(descripcion)).apply();
    }

    public void actualizarPrecio(Dinero precio) {
        appendChange(new PrecioActualizado(precio)).apply();
    }

    public void agregarIngrediente(IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        appendChange(new IngredienteAgregado(idIngrediente, nombre, descripcion)).apply();
    }

    public void actualizarIngrediente(IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        appendChange(new IngredienteActualizado(idIngrediente, nombre, descripcion)).apply();
    }

    public void actualizarNombreIngrediente(IdIngrediente idIngrediente, Nombre nombre) {
        appendChange(new NombreIngredienteActualizado(idIngrediente, nombre)).apply();
    }

    public void actualizarDescripcionIngrediente(IdIngrediente idIngrediente, Descripcion descripcion) {
        appendChange(new DescripcionIngredienteActualizada(idIngrediente, descripcion)).apply();
    }

    public void quitarIngrediente(IdIngrediente idIngrediente) {
        appendChange(new IngredienteQuitado(idIngrediente)).apply();
    }

    public void agregarRecipiente(IdRecipiente idRecipiente, Dimensiones dimensiones) {
        appendChange(new RecipienteAgregado(idRecipiente, dimensiones)).apply();
    }

    public void actualizarDimensionesRecipiente(Dimensiones dimensiones) {
        appendChange(new DimensionesRecipienteActualizadas(dimensiones)).apply();
    }

    public DatosComida datos() {
        return datos;
    }

    public Recipiente recipiente() {
        return recipiente;
    }

    public Set<Ingrediente> ingredientes() {
        return ingredientes;
    }
}