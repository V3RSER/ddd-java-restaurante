package co.com.sofka.domain.restaurante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimensiones implements ValueObject<Dimensiones.Props> {
    private final Double ancho;
    private final Double alto;
    private final Double largo;
    private final Unidad unidad;

    public Dimensiones(Double ancho, Double alto, Double largo, Unidad unidad) {
        this.ancho = Objects.requireNonNull(ancho, "El ancho no debe ser nulo");
        this.alto = Objects.requireNonNull(alto, "El alto no debe ser nulo");
        this.largo = Objects.requireNonNull(largo, "El largo no debe ser nulo");
        this.unidad = Objects.requireNonNull(unidad, "La unidad no debe ser nula");
        if (this.ancho <= 0.0) {
            throw new IllegalArgumentException("El ancho no es válido");
        }
        if (this.alto <= 0.0) {
            throw new IllegalArgumentException("El alto no es válido");
        }
        if (this.largo <= 0.0) {
            throw new IllegalArgumentException("El largo no es válido");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Double ancho() {
                return ancho;
            }

            @Override
            public Double alto() {
                return alto;
            }

            @Override
            public Double largo() {
                return largo;
            }

            @Override
            public Unidad unidad() {
                return unidad;
            }
        };
    }

    public enum Unidad {
        M, CM
    }

    public interface Props {
        Double ancho();

        Double alto();

        Double largo();

        Unidad unidad();
    }
}