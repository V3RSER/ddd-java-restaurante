package co.com.sofka.domain.restaurante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ciudad implements ValueObject<Nombre> {
    private final Nombre ciudad;

    public Ciudad(Nombre ciudad) {
        this.ciudad = Objects.requireNonNull(ciudad, "La ciudad no debe ser nula");
    }

    @Override
    public Nombre value() {
        return ciudad;
    }
}