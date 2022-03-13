package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDateTime> {
    private final LocalDateTime fecha;

    public Fecha(LocalDateTime fecha) {
        this.fecha = Objects.requireNonNull(fecha, "La fecha no debe ser nula");
    }

    public Fecha() {
        this(LocalDateTime.now());
    }

    @Override
    public LocalDateTime value() {
        return fecha;
    }
}