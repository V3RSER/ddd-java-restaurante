package co.com.sofka.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion, "El descripcion no debe ser nulo");
        if (this.descripcion.length() < 3) {
            throw new IllegalArgumentException("La descripción es demasiado corta");
        }
    }

    @Override
    public String value() {
        return descripcion;
    }
}