package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.EstadoOrden;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Telefono;

import java.util.Objects;
import java.util.Set;

public class Orden extends Entity<IdOrden> {
    private final Set<DatosComida> datosComidas;
    private DatosEnvio datosEnvio;
    private EstadoOrden estado;

    public Orden(
            IdOrden idOrden, DatosEnvio datosEnvio, Set<DatosComida> datosComidas) {
        super(idOrden);
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.estado = new EstadoOrden(EstadoOrden.Fase.NO_ENTREGADO);
    }

    public void modificarDatosEnvio(DatosEnvio datosEnvio) {
        if (this.estado.value().equals(EstadoOrden.Fase.NO_ENTREGADO)) {
            this.datosEnvio = Objects.requireNonNull(datosEnvio,
                    "Los datos de envio no deben ser nulos");
        }
        throw new IllegalArgumentException("No se puede modificar los datos de envio");
    }

    public void modificarTelefonoDestinatario(Telefono telefonoDestinatario) {
        if (this.estado.value().equals(EstadoOrden.Fase.NO_ENTREGADO)) {
            this.datosEnvio.modificarTelefonoDestinatario(Objects.requireNonNull(telefonoDestinatario,
                    "El telefono del destinatario no debe ser nulo"));
        }
        throw new IllegalArgumentException("No se puede modificar los datos del destinatario");
    }

    public void modificarDireccionEntrega(Direccion direccionEntrega) {
        if (this.estado.value().equals(EstadoOrden.Fase.NO_ENTREGADO)) {
            this.datosEnvio.modificarDireccionEntrega(Objects.requireNonNull(direccionEntrega,
                    "La direccion de entrega no debe ser nula"));
        }
        throw new IllegalArgumentException("No se puede modificar la dirección de entrega");
    }

    public void entregarOrden() {
        this.estado = new EstadoOrden(EstadoOrden.Fase.ENTREGADO);
    }

    public DatosEnvio datosEnvio() {
        return datosEnvio;
    }

    public Set<DatosComida> datosComidas() {
        return datosComidas;
    }

    public EstadoOrden estado() {
        return estado;
    }
}