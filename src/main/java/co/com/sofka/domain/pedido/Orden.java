package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.EstadoOrden;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.NombrePersona;

import java.util.Objects;
import java.util.Set;

public class Orden extends Entity<IdOrden> {
    private final NombrePersona nombreComprador;
    private DatosEnvio datosEnvio;
    private Set<DatosComida> datosComidas;
    private EstadoOrden estado;

    public Orden(IdOrden idOrden, DatosEnvio datosEnvio, Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        super(idOrden);
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.nombreComprador = nombreComprador;
        this.estado = new EstadoOrden(EstadoOrden.Fase.NO_ENTREGADO);
    }

    public void modificarDatosDestinatario(DatosPersona datosDestinatario) {
        if (this.estado.value().equals(EstadoOrden.Fase.NO_ENTREGADO)) {
            this.datosEnvio.modificarDatosDestinatario(Objects.requireNonNull(datosDestinatario,
                    "Los datos del destinatario no deben ser nulos"));
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

    public void modificarDatosComidas(Set<DatosComida> datosComidas) {
        if (this.estado.value().equals(EstadoOrden.Fase.NO_ENTREGADO)) {
            this.datosComidas = Objects.requireNonNull(datosComidas, "Los datos de comidas no debe ser nulos");
        }
        throw new IllegalArgumentException("No se puede modificar los datos de comidas");
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

    public NombrePersona nombreComprador() {
        return nombreComprador;
    }

    public EstadoOrden estado() {
        return estado;
    }
}