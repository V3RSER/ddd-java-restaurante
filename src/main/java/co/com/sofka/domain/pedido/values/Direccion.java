package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.values.Ciudad;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Props> {
    private final Ciudad ciudad;
    private final String barrio;
    private final String calle;
    private final String casa;

    public Direccion(Ciudad ciudad, String barrio, String calle, String casa) {
        this.ciudad = Objects.requireNonNull(ciudad, "El barrio no debe ser nulo");
        this.barrio = Objects.requireNonNull(barrio, "El barrio no debe ser nulo");
        this.calle = Objects.requireNonNull(calle, "La calle no debe ser nula");
        this.casa = Objects.requireNonNull(casa, "La casa no debe ser nula");
        if (this.barrio.isBlank()) {
            throw new IllegalArgumentException("El barrio es requerido");
        }
        if (this.calle.isBlank()) {
            throw new IllegalArgumentException("La calle es requerida");
        }
        if (this.casa.isBlank()) {
            throw new IllegalArgumentException("La casa es requerida");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Ciudad ciudad() {
                return ciudad;
            }

            @Override
            public String barrio() {
                return barrio;
            }

            @Override
            public String calle() {
                return calle;
            }

            @Override
            public String casa() {
                return casa;
            }
        };
    }

    public interface Props {
        Ciudad ciudad();

        String barrio();

        String calle();

        String casa();
    }
}