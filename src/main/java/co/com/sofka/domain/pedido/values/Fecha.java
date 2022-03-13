package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = Objects.requireNonNull(fecha, "La fecha no debe ser nula");
    }

    public Fecha() {
        this(LocalDate.now());
    }

    @Override
    public LocalDate value() {
        return fecha;
    }
}