package co.com.sofka.domain.comida;

import co.com.sofka.domain.comida.event.*;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Dimensiones;
import co.com.sofka.domain.values.Nombre;

import java.util.HashSet;
import java.util.Set;

public class Comida extends AggregateEvent<IdComida> {
    protected DatosComida datos;
    protected Set<Ingrediente> ingredientes = new HashSet<>();
    protected Recipiente recipiente;

    public Comida(IdComida idComida, DatosComida datos, Set<Ingrediente> ingredientes) {
        super(idComida);
        appendChange(new ComidaCreada(datos, ingredientes)).apply();
    }

    public void actualizarNombre(Nombre nombre) {
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        appendChange(new DescripcionActualizada(descripcion)).apply();
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

    public void actualizarRecipiente(IdRecipiente idRecipiente, Dimensiones dimensiones) {
        appendChange(new RecipienteActualizado(idRecipiente, dimensiones)).apply();
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