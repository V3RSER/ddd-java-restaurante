package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.NombrePersona;

import java.util.Objects;
import java.util.Set;

public class Orden extends Entity<IdOrden> {
    private final NombrePersona nombreComprador;
    private DatosEnvio datosEnvio;
    private Set<DatosComida> datosComidas;

    public Orden(IdOrden idOrden, DatosEnvio datosEnvio, Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        super(idOrden);
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.nombreComprador = nombreComprador;
    }

    public void modificarDireccionEntrega(Direccion direccionEntrega) {
        this.datosEnvio.modificarDireccionEntrega(Objects.requireNonNull(direccionEntrega,
                "La direccion de entrega no debe ser nula"));
    }

    public void modificarDatosComidas(Set<DatosComida> datosComidas) {
        this.datosComidas = Objects.requireNonNull(datosComidas, "Los datos de comidas no debe ser nulos");
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

}