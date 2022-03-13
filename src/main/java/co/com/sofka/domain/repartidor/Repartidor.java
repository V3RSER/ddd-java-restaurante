package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.repartidor.event.*;
import co.com.sofka.domain.repartidor.values.*;
import co.com.sofka.domain.values.*;

import java.util.List;

public class Repartidor extends AggregateEvent<IdRepartidor> {
    protected DatosPersona datos;
    protected Mochila mochila;
    protected Zona zona;
    protected List<IdPedido> pedidos;

    public Repartidor(IdRepartidor idRepartidor, DatosPersona datos) {
        super(idRepartidor);
        appendChange(new RepartidorCreado(datos)).apply();
    }

    public void ActualizarTelefono(Telefono telefono) {
        appendChange(new TelefonoActualizado(telefono)).apply();
    }

    public void AgregarMochila(IdMochila idMochila, Dimensiones dimensiones) {
        appendChange(new MochilaAgregada(idMochila, dimensiones)).apply();
    }

    public void ActualizarMochila(IdMochila idMochila, Dimensiones dimensiones) {
        appendChange(new MochilaActualizada(idMochila, dimensiones)).apply();
    }

    public void AgregarVehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        appendChange(new VehiculoAgregado(idVehiculo, nombre, velocidadMedia)).apply();
    }

    public void ActualizarVehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        appendChange(new VehiculoActualizado(idVehiculo, nombre, velocidadMedia)).apply();
    }

    public void AgregarZona(IdZona idZona, Ciudad ciudad) {
        appendChange(new ZonaAgregada(idZona, ciudad)).apply();
    }

    public void ActualizarZona(IdZona idZona, Ciudad ciudad) {
        appendChange(new ZonaActualizada(idZona, ciudad)).apply();
    }

    public void AsignarPedido(IdPedido pedido) {
        appendChange(new PedidoAsignado(pedido)).apply();
    }

    public void QuitarPedido(IdPedido pedido) {
        appendChange(new PedidoQuitado(pedido)).apply();
    }

    public DatosPersona datos() {
        return datos;
    }

    public Mochila mochila() {
        return mochila;
    }

    public Zona zona() {
        return zona;
    }

    public List<IdPedido> pedidos() {
        return pedidos;
    }
}
