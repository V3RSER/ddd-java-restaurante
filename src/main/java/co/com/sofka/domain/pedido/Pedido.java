package co.com.sofka.domain.pedido;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.pedido.event.*;
import co.com.sofka.domain.pedido.values.*;
import co.com.sofka.domain.values.*;

import java.util.Set;

public class Pedido extends AggregateEvent<IdPedido> {
    protected Set<IdComida> idProductos;
    protected Comprador comprador;
    protected Destinatario destinatario;
    protected MetodoPago metodoPago;
    protected Dimensiones dimensionesPaquete;
    protected EstadoPedido estado;
    protected Orden orden;
    protected Factura factura;

    public Pedido(IdPedido idPedido, Set<IdComida> idProductos, MetodoPago metodoPago,
                  IdComprador idComprador, DatosPersona datosComprador, Tarjeta tarjetaComprador,
                  IdDestinatario idDestinatario, DatosPersona datosDestinatario, Dinero dineroDestinatario) {
        super(idPedido);
        appendChange(new PedidoCreado(idProductos, metodoPago)).apply();
        appendChange(new CompradorAsignado(idComprador, datosComprador, tarjetaComprador)).apply();
        appendChange(new DestinatarioAsignado(idDestinatario, datosDestinatario, dineroDestinatario)).apply();
    }

    public void ActualizarTarjetaComprador(IdComprador idComprador, Tarjeta tarjeta) {
        appendChange(new TarjetaCompradorActualizada(idComprador, tarjeta)).apply();
    }

    public void ActualizarTelefonoComprador(IdComprador idComprador, Telefono telefono) {
        appendChange(new TelefonoCompradorActualizado(idComprador, telefono)).apply();
    }

    public void ActualizarDireccionDestinatario(IdDestinatario idDestinatario, Direccion direccion) {
        appendChange(new DireccionDestinatarioActualizada(idDestinatario, direccion)).apply();
    }

    public void ActualizarTelefonoDestinatario(IdDestinatario idDestinatario, Telefono telefono) {
        appendChange(new TelefonoDestinatarioActualizado(idDestinatario, telefono)).apply();
    }

    public void GenerarOrden(IdOrden idOrden, DatosEnvio datosEnvio,
                             Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        appendChange(new OrdenGenerada(idOrden, datosEnvio, datosComidas, nombreComprador)).apply();
    }

    public void ActualizarOrden(IdOrden idOrden, DatosEnvio datosEnvio,
                                Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        appendChange(new OrdenActualizada(idOrden, datosEnvio, datosComidas, nombreComprador)).apply();
    }

    public void GenerarFactura(IdFactura idFactura, Set<DatosComida> datosComidas,
                               TipoFactura tipo, Dinero costeEnvio) {
        appendChange(new FacturaGenerada(idFactura, datosComidas, tipo, costeEnvio)).apply();
    }

    public void ActualizarFactura(IdFactura idFactura, Set<DatosComida> datosComidas,
                                  TipoFactura tipo, Dinero costeEnvio) {
        appendChange(new FacturaActualizada(idFactura, datosComidas, tipo, costeEnvio)).apply();
    }

    public void ActualizarTipoFactura(IdFactura idFactura, TipoFactura tipo) {
        appendChange(new TipoFacturaActualizada(idFactura, tipo)).apply();
    }

    public Set<IdComida> idProductos() {
        return idProductos;
    }

    public Comprador comprador() {
        return comprador;
    }

    public Destinatario destinatario() {
        return destinatario;
    }

    public MetodoPago metodoPago() {
        return metodoPago;
    }

    public Dimensiones dimensionesPaquete() {
        return dimensionesPaquete;
    }

    public EstadoPedido estado() {
        return estado;
    }

    public Orden orden() {
        return orden;
    }

    public Factura factura() {
        return factura;
    }
}
