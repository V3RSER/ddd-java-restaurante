package co.com.sofka.domain.repartidor.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.Dimensiones;

import java.util.Objects;

public class InformacionPedido implements ValueObject<InformacionPedido.Props> {
    private final IdPedido idPedido;
    private final DatosEnvio datosEnvio;
    private final Dimensiones dimensiones;

    public InformacionPedido(IdPedido idPedido, DatosEnvio datosEnvio, Dimensiones dimensiones) {
        this.idPedido = Objects.requireNonNull(idPedido, "El id del pedido no debe ser nulo");
        this.datosEnvio = Objects.requireNonNull(datosEnvio, "Los datos del envio no deben ser nulos");
        this.dimensiones = Objects.requireNonNull(dimensiones, "Las dimensiones no deben ser nulas");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public IdPedido idPedido() {
                return idPedido;
            }

            @Override
            public DatosEnvio datosEnvio() {
                return datosEnvio;
            }

            @Override
            public Dimensiones dimensiones() {
                return dimensiones;
            }
        };
    }

    public interface Props {
        IdPedido idPedido();

        DatosEnvio datosEnvio();

        Dimensiones dimensiones();
    }
}