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

    public void actualizarTarjetaComprador(IdComprador idComprador, Tarjeta tarjeta) {
        appendChange(new TarjetaCompradorActualizada(idComprador, tarjeta)).apply();
    }

    public void actualizarTelefonoComprador(IdComprador idComprador, Telefono telefono) {
        appendChange(new TelefonoCompradorActualizado(idComprador, telefono)).apply();
    }

    public void actualizarDireccionDestinatario(IdDestinatario idDestinatario, Direccion direccion) {
        appendChange(new DireccionDestinatarioActualizada(idDestinatario, direccion)).apply();
    }

    public void actualizarTelefonoDestinatario(IdDestinatario idDestinatario, Telefono telefono) {
        appendChange(new TelefonoDestinatarioActualizado(idDestinatario, telefono)).apply();
    }

    public void generarOrden(IdOrden idOrden, DatosEnvio datosEnvio,
                             Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        appendChange(new OrdenGenerada(idOrden, datosEnvio, datosComidas, nombreComprador)).apply();
    }

    public void actualizarOrden(IdOrden idOrden, DatosEnvio datosEnvio,
                                Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        appendChange(new OrdenActualizada(idOrden, datosEnvio, datosComidas, nombreComprador)).apply();
    }

    public void actualizarDatosDestinatarioOrden(IdOrden idOrden, DatosPersona datosDestinatario) {
        appendChange(new DatosDestinatarioActualizados(idOrden, datosDestinatario)).apply();
    }

    public void actualizarDireccionEntregaOrden(IdOrden idOrden, Direccion direccionEntrega) {
        appendChange(new DireccionEntregaActualizada(idOrden, direccionEntrega)).apply();
    }

    public void entregarOrden(IdPedido idOrden) {
        appendChange(new OrdenEntregada(idOrden)).apply();
    }

    public void generarFactura(IdFactura idFactura, Set<DatosComida> datosComidas,
                               TipoFactura tipo, Dinero costeEnvio) {
        appendChange(new FacturaGenerada(idFactura, datosComidas, tipo, costeEnvio)).apply();
    }

    public void actualizarFactura(IdFactura idFactura, Set<DatosComida> datosComidas,
                                  TipoFactura tipo, Dinero costeEnvio) {
        appendChange(new FacturaActualizada(idFactura, datosComidas, tipo, costeEnvio)).apply();
    }

    public void actualizarTipoFactura(IdFactura idFactura, TipoFactura tipo) {
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

    public Orden orden() {
        return orden;
    }

    public Factura factura() {
        return factura;
    }
}
