package co.com.sofka.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosPersona implements ValueObject<DatosPersona.Props> {
    private final NombrePersona nombre;
    private final Telefono telefono;

    public DatosPersona(NombrePersona nombre, Telefono telefono) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no debe ser nulo");
    }

    public DatosPersona modificarNombre(NombrePersona nuevoNombre) {
        return new DatosPersona(nuevoNombre, telefono);
    }

    public DatosPersona modificarTelefono(Telefono nuevoTelefono) {
        return new DatosPersona(nombre, nuevoTelefono);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public NombrePersona nombre() {
                return nombre;
            }

            @Override
            public Telefono telefono() {
                return telefono;
            }
        };
    }

    public interface Props {
        NombrePersona nombre();

        Telefono telefono();
    }
}
