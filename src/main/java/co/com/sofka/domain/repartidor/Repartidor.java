package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.repartidor.event.*;
import co.com.sofka.domain.repartidor.values.*;
import co.com.sofka.domain.values.*;

import java.util.List;

public class Repartidor extends AggregateEvent<IdRepartidor> {
    protected DatosPersona datos;
    protected Mochila mochila;
    protected Vehiculo vehiculo;
    protected Zona zona;
    protected List<InformacionPedido> pedidos;

    public Repartidor(IdRepartidor idRepartidor, DatosPersona datos) {
        super(idRepartidor);
        appendChange(new RepartidorCreado(datos)).apply();
        subscribe(new RepartidorChange(this));
    }

    public Repartidor(IdRepartidor idRepartidor) {
        super(idRepartidor);
        subscribe(new RepartidorChange(this));
    }

    public static Repartidor from(IdRepartidor idRepartidor, List<DomainEvent> retrieveEvents) {
        var repartidor = new Repartidor(idRepartidor);
        retrieveEvents.forEach(repartidor::applyEvent);
        return repartidor;
    }

    public void actualizarTelefono(Telefono telefono) {
        appendChange(new TelefonoActualizado(telefono)).apply();
    }

    public void agregarMochila(IdMochila idMochila, Dimensiones dimensiones) {
        appendChange(new MochilaAgregada(idMochila, dimensiones)).apply();
    }

    public void actualizarDimensionesMochila(Dimensiones dimensiones) {
        appendChange(new DimensionesMochilaActualizadas(dimensiones)).apply();
    }

    public void agregarVehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        appendChange(new VehiculoAgregado(idVehiculo, nombre, velocidadMedia)).apply();
    }

    public void actualizarNombreVehiculo(Nombre nombre) {
        appendChange(new NombreVehiculoActualizado(nombre)).apply();
    }

    public void agregarZona(IdZona idZona, Ciudad ciudad) {
        appendChange(new ZonaAgregada(idZona, ciudad)).apply();
    }

    public void actualizarCiudadZona(Ciudad ciudad) {
        appendChange(new ZonaCiudadActualizada(ciudad)).apply();
    }

    public void asignarPedido(IdPedido idPedido, DatosEnvio datosEnvio, Dimensiones dimensiones) {
        appendChange(new PedidoAsignado(idPedido, datosEnvio, dimensiones)).apply();
    }

    public void quitarPedido(IdPedido idPedido) {
        appendChange(new PedidoQuitado(idPedido)).apply();
    }

    public DatosPersona datos() {
        return datos;
    }

    public Mochila mochila() {
        return mochila;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }

    public Zona zona() {
        return zona;
    }

    public List<InformacionPedido> pedidos() {
        return pedidos;
    }
}
