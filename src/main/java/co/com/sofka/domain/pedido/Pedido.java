package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.event.*;
import co.com.sofka.domain.pedido.values.*;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.Dimensiones;
import co.com.sofka.domain.values.Telefono;

import java.util.List;
import java.util.Set;

public class Pedido extends AggregateEvent<IdPedido> {
    protected Set<InformacionComida> comidas;
    protected Dimensiones dimensionesPaquete;
    protected Destinatario destinatario;
    protected Orden orden;
    protected Comprador comprador;
    protected Factura factura;

    public Pedido(IdPedido idPedido, Set<InformacionComida> comidas,
                  IdDestinatario idDestinatario, DatosPersona datosDestinatario,
                  Direccion direccionDestinatario, Dinero efectivoDestinatario, IdOrden idOrden,
                  IdComprador idComprador, DatosPersona datosComprador, Tarjeta tarjetaComprador,
                  IdFactura idFactura, TipoFactura tipo, Dinero costeEnvio, MetodoPago metodoPago) {
        super(idPedido);
        appendChange(new PedidoCreado(comidas)).apply();
        appendChange(new DestinatarioAsignado(
                idDestinatario, datosDestinatario, direccionDestinatario, efectivoDestinatario)).apply();
        appendChange(new OrdenGenerada(idOrden)).apply();
        appendChange(new CompradorAsignado(idComprador, datosComprador, tarjetaComprador)).apply();
        appendChange(new FacturaGenerada(idFactura, tipo, costeEnvio, metodoPago)).apply();
        subscribe(new PedidoChange(this));
    }

    public Pedido(IdPedido idPedido) {
        super(idPedido);
        subscribe(new PedidoChange(this));
    }

    public static Pedido from(IdPedido idPedido, List<DomainEvent> retrieveEvents) {
        var pedido = new Pedido(idPedido);
        retrieveEvents.forEach(pedido::applyEvent);
        return pedido;
    }

    public void actualizarDireccionDestinatario(Direccion direccion) {
        appendChange(new DireccionDestinatarioActualizada(direccion)).apply();
        appendChange(new DireccionEntregaActualizada(direccion)).apply();
    }

    public void actualizarTelefonoDestinatario(Telefono telefono) {
        appendChange(new TelefonoDestinatarioActualizado(telefono)).apply();
        appendChange(new TelefonoOrdenActualizado(telefono)).apply();
    }

    public void actualizarDireccionEntregaOrden(Direccion direccionEntrega) {
        appendChange(new DireccionEntregaActualizada(direccionEntrega)).apply();
    }

    public void actualizarTelefonoDestinatarioOrden(Telefono telefono) {
        appendChange(new TelefonoOrdenActualizado(telefono)).apply();
    }

    public void entregarOrden(IdFactura idFactura) {
        appendChange(new OrdenEntregada(idFactura)).apply();
    }

    public void actualizarTarjetaComprador(Tarjeta tarjeta) {
        appendChange(new TarjetaCompradorActualizada(tarjeta)).apply();
    }

    public void actualizarTelefonoComprador(Telefono telefono) {
        appendChange(new TelefonoCompradorActualizado(telefono)).apply();
    }

    public void actualizarTipoFactura(TipoFactura tipo) {
        appendChange(new TipoFacturaActualizada(tipo)).apply();
    }

    public Set<InformacionComida> comidas() {
        return comidas;
    }

    public Dimensiones dimensionesPaquete() {
        return dimensionesPaquete;
    }

    public Destinatario destinatario() {
        return destinatario;
    }

    public Orden orden() {
        return orden;
    }

    public Comprador comprador() {
        return comprador;
    }

    public Factura factura() {
        return factura;
    }
}
