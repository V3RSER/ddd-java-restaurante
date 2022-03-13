package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.Telefono;

import java.util.Objects;

public class DatosEnvio implements ValueObject<DatosEnvio.Props> {
    private final DatosPersona datosDestinatario;
    private final Fecha fechaOrden;
    private final Fecha fechaEntregaEstimada;
    private final Direccion direccionEntrega;

    public DatosEnvio(DatosPersona datosDestinatario, Fecha fechaEntregaEstimada, Direccion direccionEntrega) {
        this.datosDestinatario = Objects.requireNonNull(datosDestinatario,
                "Los datos del destinatario no deben ser nulos");
        this.fechaOrden = new Fecha();
        this.fechaEntregaEstimada = Objects.requireNonNull(fechaEntregaEstimada,
                "La fecha estimada de entrega no debe ser nula");
        this.direccionEntrega = Objects.requireNonNull(direccionEntrega,
                "La direccion de entrega  no debe ser nula");
    }

    public DatosEnvio(DatosPersona datosDestinatario, Fecha fechaOrden, Fecha fechaEntregaEstimada, Direccion direccionEntrega) {
        this.datosDestinatario = Objects.requireNonNull(datosDestinatario,
                "Los datos del destinatario no deben ser nulos");
        this.fechaOrden = Objects.requireNonNull(fechaOrden,
                "La fecha de la ordeen no debe ser nula");
        this.fechaEntregaEstimada = Objects.requireNonNull(fechaEntregaEstimada,
                "La fecha estimada de entrega no debe ser nula");
        this.direccionEntrega = Objects.requireNonNull(direccionEntrega,
                "La direccion de entrega  no debe ser nula");
    }

    public DatosEnvio modificarDireccionEntrega(Direccion nuevaDireccionEntrega) {
        return new DatosEnvio(datosDestinatario, fechaOrden, fechaEntregaEstimada, nuevaDireccionEntrega);
    }

    public DatosEnvio modificarTelefonoDestinatario(Telefono nuevoTelefono) {
        return new DatosEnvio(datosDestinatario.modificarTelefono(nuevoTelefono), fechaOrden, fechaEntregaEstimada, direccionEntrega);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public DatosPersona datosDestinatario() {
                return datosDestinatario;
            }

            @Override
            public Fecha fechaOrden() {
                return fechaOrden;
            }

            @Override
            public Fecha fechaEntregaEstimada() {
                return fechaEntregaEstimada;
            }

            @Override
            public Direccion direccionEntrega() {
                return direccionEntrega;
            }
        };
    }

    public interface Props {
        DatosPersona datosDestinatario();

        Fecha fechaOrden();

        Fecha fechaEntregaEstimada();

        Direccion direccionEntrega();
    }
}
