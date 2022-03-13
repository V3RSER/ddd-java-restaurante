package co.com.sofka.domain.comida;

import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Nombre;

import java.util.Objects;

public class Ingrediente extends Entity<IdIngrediente> {
    private Nombre nombre;
    private Descripcion descripcion;

    public Ingrediente(IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        super(idIngrediente);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void modificarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void modificarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion, "La descripcion no debe ser nula");
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Nombre nombre() {
        return nombre;
    }
}