package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.repartidor.event.*;
import co.com.sofka.domain.repartidor.values.InformacionPedido;

import java.util.ArrayList;

public class RepartidorChange extends EventChange {
    public RepartidorChange(Repartidor repartidor) {
        apply((RepartidorCreado event) -> {
            repartidor.datos = event.getDatosPersona();
            repartidor.pedidos = new ArrayList<>();
        });

        apply((TelefonoActualizado event) -> {
            repartidor.datos = repartidor.datos.modificarTelefono(event.getTelefono());
        });

        apply((MochilaAgregada event) -> {
            repartidor.mochila = new Mochila(event.getIdMochila(), event.getDimensiones());
        });

        apply((DimensionesMochilaActualizadas event) -> {
            repartidor.mochila.modificarDimensiones(event.getDimensiones());
        });

        apply((VehiculoAgregado event) -> {
            repartidor.vehiculo = new Vehiculo(event.getIdVehiculo(), event.getNombre(), event.getVelocidadMedia());
        });

        apply((NombreVehiculoActualizado event) -> {
            repartidor.vehiculo.modificarNombre(event.getNombre());
        });

        apply((ZonaAgregada event) -> {
            repartidor.zona = new Zona(event.getIdZona(), event.getCiudad());
        });

        apply((ZonaCiudadActualizada event) -> {
            repartidor.zona.modificarCiudad(event.getCiudad());
        });

        apply((PedidoAsignado event) -> {
            if (!repartidor.zona.ciudad().equals(event.getDatosEnvio().value().direccionEntrega().value().ciudad())) {
                throw new IllegalArgumentException(
                        "El repartidor no corresponde a la zona del pedido");
            }
            if (repartidor.mochila.dimensiones().value().alto() < event.getDimensiones().value().alto()
                    || repartidor.mochila.dimensiones().value().largo() < event.getDimensiones().value().largo()
                    || repartidor.mochila.dimensiones().value().ancho() < event.getDimensiones().value().ancho()) {
                throw new IllegalArgumentException(
                        "La mochila del repartidor no tiene espacio");
            }
            // TODO: 13/03/2022 validaciones en diferentes orientaciones
            repartidor.pedidos.add(
                    new InformacionPedido(event.getIdPedido(), event.getDatosEnvio(), event.getDimensiones()));
        });

        apply((PedidoQuitado event) -> {
            repartidor.pedidos.removeIf(
                    informacionPedido -> informacionPedido.value().idPedido().equals(event.getPedido()));
        });
    }
}
