package co.com.sofka.domain.restaurante.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.restaurante.values.NombrePersona;

import java.util.Objects;

public class Tarjeta implements ValueObject<Tarjeta.Props> {
    private final NombrePersona titular;
    private final NumeroTarjeta numeroTarjeta;
    private final FechaVencimiento fechaVencimiento;
    private final CVV cvv;

    public Tarjeta(NombrePersona titular, NumeroTarjeta numeroTarjeta,
                   FechaVencimiento fechaVencimiento, CVV cvv) {
        this.titular = Objects.requireNonNull(titular, "El titular no debe ser nulo");
        this.numeroTarjeta = Objects.requireNonNull(numeroTarjeta, "El numero no debe ser nulo");
        this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento, "La fecha de vencimiento no debe ser nula");
        this.cvv = Objects.requireNonNull(cvv, "El cvv no debe ser nulo");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public NombrePersona titular() {
                return titular;
            }

            public NumeroTarjeta numeroTarjeta() {
                return numeroTarjeta;
            }

            @Override
            public FechaVencimiento fechaVencimiento() {
                return fechaVencimiento;
            }

            @Override
            public CVV cvv() {
                return cvv;
            }
        };
    }

    public interface Props {
        NombrePersona titular();

        NumeroTarjeta numeroTarjeta();

        FechaVencimiento fechaVencimiento();

        CVV cvv();
    }
}