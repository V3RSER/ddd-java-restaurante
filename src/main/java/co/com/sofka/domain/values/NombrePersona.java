package co.com.sofka.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombrePersona implements ValueObject<NombrePersona.Props> {
    private final String nombre;
    private final String apellido;

    public NombrePersona(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
        this.apellido = Objects.requireNonNull(apellido, "El apellido no debe ser nulo");
        if (this.nombre.length() <= 5) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        }
        if (this.apellido.length() <= 5) {
            throw new IllegalArgumentException("El apellido es demasiado corto");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }
        };
    }

    public interface Props {
        String nombre();

        String apellido();
    }
}