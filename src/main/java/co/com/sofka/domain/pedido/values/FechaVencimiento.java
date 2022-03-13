package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaVencimiento implements ValueObject<FechaVencimiento.Props> {
    private final Integer anio;
    private final Integer mes;

    public FechaVencimiento(Integer anio, Integer mes) {
        this.anio = Objects.requireNonNull(anio, "El año no debe ser nulo");
        this.mes = Objects.requireNonNull(mes, "El mes no debe ser nulo");

        if (this.anio < LocalDate.now().getYear() - 2000 || this.anio > 99) {
            throw new IllegalArgumentException("El año no es válido");
        }
        if (this.mes < 0 || this.mes > 12) {
            throw new IllegalArgumentException("El mes no es válido");
        }
        if (this.anio == LocalDate.now().getYear() - 2000 && this.mes < LocalDate.now().getMonthValue()) {
            throw new IllegalArgumentException("Fecha no válida");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer anio() {
                return anio;
            }

            @Override
            public Integer mes() {
                return mes;
            }
        };
    }

    public interface Props {
        Integer anio();

        Integer mes();
    }
}