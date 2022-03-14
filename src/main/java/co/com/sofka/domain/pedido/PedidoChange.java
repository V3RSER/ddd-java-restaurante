package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.pedido.event.*;
import co.com.sofka.domain.pedido.values.*;
import co.com.sofka.domain.values.Dimensiones;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PedidoChange extends EventChange {
    public PedidoChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.comidas = event.getComidas();
            // TODO: 13/03/2022 Mejorar lógica de empaquetado
            var ancho = 0.0;
            var alto = 0.0;
            var largo = 0.0;
            for (InformacionComida comida : pedido.comidas) {
                if (comida.value().dimensionesRecipiente().value().ancho() > ancho) {
                    ancho = comida.value().dimensionesRecipiente().value().ancho();
                }
                alto += comida.value().dimensionesRecipiente().value().alto();
                if (comida.value().dimensionesRecipiente().value().largo() > largo) {
                    largo = comida.value().dimensionesRecipiente().value().largo();
                }
            }
            pedido.dimensionesPaquete = new Dimensiones(ancho, alto, largo);
        });

        apply((DestinatarioAsignado event) -> {
            pedido.destinatario = new Destinatario(event.getIdDestinatario(), event.getDatosDestinatario(),
                    event.getDireccionDestinatario(), event.getEfectivoDestinatario()
            );
        });

        apply((OrdenGenerada event) -> {
            if (!pedido.destinatario.identity().value().equals(event.getIdDestinatario().value())) {
                throw new IllegalArgumentException("Un id de destinatario válido es requerido");
            }
            pedido.orden = new Orden(
                    event.getIdOrden(),
                    new DatosEnvio(
                            pedido.destinatario.datos(),
                            new Fecha(LocalDateTime.now().plusMinutes(60)), // TODO: 13/03/2022 Mejorar lógica de tiempo promedio de entrega
                            pedido.destinatario.direccion()
                    ),
                    pedido.comidas.stream().map(comida -> comida.value().datosComida()).collect(Collectors.toSet())
            );
        });

        apply((CompradorAsignado event) -> {
            pedido.comprador = new Comprador(event.getIdComprador(),
                    event.getDatosComprador(), event.getTarjetaComprador()
            );
        });

        apply((FacturaGenerada event) -> {
            if (!pedido.comprador.identity().value().equals(event.getIdComprador().value())) {
                throw new IllegalArgumentException("Un id de comprador válido es requerido");
            }
            pedido.factura = new Factura(
                    event.getIdFactura(),
                    pedido.comidas.stream().map(comida -> comida.value().datosComida()).collect(Collectors.toSet()),
                    event.getTipo(),
                    event.getCosteEnvio(),
                    event.getMetodoPago()
            );
            // Si se eligió método de pago por tarjeta, se hace el monto a la tarjeta del comprador
            if (event.getMetodoPago().value().equals(MetodoPago.Tipo.TARJETA)) {
                pedido.comprador.pagarOrden(pedido.factura.costeTotal());
                pedido.factura.asignarComprador(pedido.comprador.datos().value().nombre());
            }
        });

        apply((DireccionDestinatarioActualizada event) -> {
            pedido.destinatario.modificarDireccion(event.getDireccion());
        });

        apply((TelefonoDestinatarioActualizado event) -> {
            pedido.destinatario.modificarTelefono(event.getTelefono());
        });

        apply((DireccionEntregaActualizada event) -> {
            pedido.orden.modificarDireccionEntrega(event.getDireccionEntrega());
        });

        apply((TelefonoOrdenActualizado event) -> {
            pedido.orden.modificarTelefonoDestinatario(event.getTelefono());
        });

        apply((OrdenEntregada event) -> {
            if (!pedido.factura.identity().value().equals(event.getIdFactura().value())) {
                throw new IllegalArgumentException("Un id de factura válido es requerido");
            }
            // Si se eligió método de pago por efectivo, se le pide el monto al destinatario
            if (pedido.factura.metodoPago().value().equals(MetodoPago.Tipo.EFECTIVO)
                    && pedido.factura.estado().value().equals(EstadoFactura.Fase.NO_PAGADO)) {
                pedido.destinatario.pagarOrden(pedido.factura.costeTotal());
                pedido.factura.asignarComprador(pedido.destinatario.datos().value().nombre());
            }
            pedido.orden.entregarOrden();
        });

        apply((TarjetaCompradorActualizada event) -> {
            pedido.comprador.modificarTarjeta(event.getTarjeta());
        });

        apply((TelefonoCompradorActualizado event) -> {
            pedido.comprador.modificarTelefono(event.getTelefono());
        });
    }
}
