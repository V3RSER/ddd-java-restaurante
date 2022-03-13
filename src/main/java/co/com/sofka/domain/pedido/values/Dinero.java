package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dinero implements ValueObject<Dinero.Props> {
    private final Double cantidad;
    private final String moneda;

    public Dinero(Double cantidad, String moneda) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no debe ser nula");
        this.moneda = Objects.requireNonNull(moneda, "La moneda no debe ser nula");
        if (this.cantidad < 0.0) {
            throw new IllegalArgumentException("La cantidad no es válida");
        }
        if (this.moneda.isBlank()) {
            throw new IllegalArgumentException("La moneda es requerida");
        }
    }

    public Dinero quitarDinero(Double nuevaCantidad) {
        if (this.cantidad - nuevaCantidad < 0.0) {
            throw new IllegalArgumentException("No hay fondos suficientes");
        }
        return new Dinero(cantidad - nuevaCantidad, moneda);
    }

    public Dinero agregarDinero(Double nuevaCantidad) {
        return new Dinero(cantidad + nuevaCantidad, moneda);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Double cantidad() {
                return cantidad;
            }

            @Override
            public String moneda() {
                return moneda;
            }
        };
    }

    public interface Props {
        Double cantidad();

        String moneda();
    }
}