package co.com.sofka.domain.restaurante.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.restaurante.pedido.values.Dinero;

import java.util.Objects;

public class DatosComida implements ValueObject<DatosComida.Props> {
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final Dinero precio;

    public DatosComida(Nombre nombre, Descripcion descripcion, Dinero precio) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no debe ser nula");
        this.precio = Objects.requireNonNull(precio, "El precio no debe ser nulo");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Nombre nombre() {
                return nombre;
            }

            @Override
            public Descripcion descripcion() {
                return descripcion;
            }

            @Override
            public Dinero precio() {
                return precio;
            }
        };
    }

    public interface Props {
        Nombre nombre();

        Descripcion descripcion();

        Dinero precio();
    }
}