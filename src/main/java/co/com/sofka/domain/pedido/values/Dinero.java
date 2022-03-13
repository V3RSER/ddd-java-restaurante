package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dinero implements ValueObject<Dinero.Props> {
    private final Double cantidad;
    private final String moneda;

    public Dinero(Double cantidad, String moneda) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no debe ser nula");
        this.moneda = Objects.requireNonNull(moneda, "La moneda no debe ser nula");
        if (this.moneda.isBlank()) {
            throw new IllegalArgumentException("La moneda es requerida");
        }
    }

    public Dinero(Double cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no debe ser nula");
        this.moneda = "COP";
        if (this.cantidad < 0.0) {
            throw new IllegalArgumentException("La cantidad no es válida");
        }
    }

    public Dinero quitarDinero(Dinero dineroAQuitar) {
        if (cantidad - dineroAQuitar.value().cantidad() < 0.0) {
            throw new IllegalArgumentException("No hay fondos suficientes");
        }
        return new Dinero(cantidad - dineroAQuitar.value().cantidad(), moneda);
    }

    public Dinero agregarDinero(Dinero dineroAAgregar) {
        return new Dinero(cantidad + dineroAAgregar.value().cantidad(), moneda);
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