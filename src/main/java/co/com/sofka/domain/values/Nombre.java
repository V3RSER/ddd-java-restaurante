package co.com.sofka.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
        if (this.nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}