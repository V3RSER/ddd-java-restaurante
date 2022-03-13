package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Dimensiones;

import java.util.Objects;

public class InformacionComida implements ValueObject<InformacionComida.Props> {
    private final IdComida idComida;
    private final DatosComida datosComida;
    private final Dimensiones dimensionesRecipiente;

    public InformacionComida(IdComida idComida, DatosComida datosComida, Dimensiones dimensionesRecipiente) {
        this.idComida = Objects.requireNonNull(idComida, "El idComida no debe ser nulo");
        this.datosComida = Objects.requireNonNull(datosComida, "El datosComida no debe ser nulo");
        this.dimensionesRecipiente = Objects.requireNonNull(dimensionesRecipiente, "El dimensionesRecipiente no debe ser nulo");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public IdComida idComida() {
                return idComida;
            }

            @Override
            public DatosComida datosComida() {
                return datosComida;
            }

            @Override
            public Dimensiones dimensionesRecipiente() {
                return dimensionesRecipiente;
            }
        };
    }

    public interface Props {
        IdComida idComida();

        DatosComida datosComida();

        Dimensiones dimensionesRecipiente();
    }
}
