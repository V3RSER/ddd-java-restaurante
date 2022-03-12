package co.com.sofka.domain.restaurante.repartidor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Velocidad implements ValueObject<Velocidad.Props> {
    private final Double velocidad;
    private final Unidad unidad;

    public Velocidad(Double velocidad, Unidad unidad) {
        this.velocidad = Objects.requireNonNull(velocidad, "La velocidad no debe ser nula");
        this.unidad = Objects.requireNonNull(unidad, "La unidad no debe ser nula");
        if (this.velocidad <= 0.0) {
            throw new IllegalArgumentException("La velocidad no es válida");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Double velocidad() {
                return velocidad;
            }

            @Override
            public Unidad unidad() {
                return unidad;
            }
        };
    }

    public enum Unidad {
        KMH, MPH
    }

    public interface Props {
        Double velocidad();

        Unidad unidad();
    }
}