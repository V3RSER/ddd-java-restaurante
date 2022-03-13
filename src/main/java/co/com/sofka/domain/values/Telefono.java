package co.com.sofka.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String telefono;

    public Telefono(String telefono) {
        this.telefono = Objects.requireNonNull(telefono, "El telefono no debe ser nulo");
        if (this.telefono.length() <= 5 || this.telefono.length() >= 18) {
            throw new IllegalArgumentException("El teléfono no es válido");
        }
    }

    @Override
    public String value() {
        return telefono;
    }
}
