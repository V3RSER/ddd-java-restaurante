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

    public void actualizarTelefono(Telefono telefono) {
        appendChange(new TelefonoActualizado(telefono)).apply();
    }

    public void agregarMochila(IdMochila idMochila, Dimensiones dimensiones) {
        appendChange(new MochilaAgregada(idMochila, dimensiones)).apply();
    }

    public void actualizarMochila(IdMochila idMochila, Dimensiones dimensiones) {
        appendChange(new MochilaActualizada(idMochila, dimensiones)).apply();
    }

    public void agregarVehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        appendChange(new VehiculoAgregado(idVehiculo, nombre, velocidadMedia)).apply();
    }

    public void actualizarVehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        appendChange(new VehiculoActualizado(idVehiculo, nombre, velocidadMedia)).apply();
    }

    public void agregarZona(IdZona idZona, Ciudad ciudad) {
        appendChange(new ZonaAgregada(idZona, ciudad)).apply();
    }

    public void actualizarZona(IdZona idZona, Ciudad ciudad) {
        appendChange(new ZonaActualizada(idZona, ciudad)).apply();
    }

    public void asignarPedido(IdPedido pedido) {
        appendChange(new PedidoAsignado(pedido)).apply();
    }

    public void quitarPedido(IdPedido pedido) {
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
