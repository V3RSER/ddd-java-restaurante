package co.com.sofka.domain.restaurante.comida;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.comida.values.IdIngrediente;
import co.com.sofka.domain.restaurante.values.Descripcion;
import co.com.sofka.domain.restaurante.values.Nombre;

public class Ingrediente extends Entity<IdIngrediente> {
    private Nombre nombre;
    private Descripcion descripcion;

    public Ingrediente(IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        super(idIngrediente);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Nombre nombre() {
        return nombre;
    }
}