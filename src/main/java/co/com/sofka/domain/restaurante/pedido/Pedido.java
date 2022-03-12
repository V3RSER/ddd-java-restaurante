package co.com.sofka.domain.restaurante.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.restaurante.comida.values.IdComida;
import co.com.sofka.domain.restaurante.pedido.values.EstadoPedido;
import co.com.sofka.domain.restaurante.pedido.values.IdPedido;
import co.com.sofka.domain.restaurante.pedido.values.MetodoPago;
import co.com.sofka.domain.restaurante.values.Dimensiones;

import java.util.Set;

public class Pedido extends AggregateEvent<IdPedido> {
    protected Dimensiones dimensiones;
    protected EstadoPedido estado;
    protected Comprador comprador;
    protected Destinatario destinatario;
    protected Orden orden;
    protected Factura factura;
    protected Set<IdComida> productos;
    protected MetodoPago metodoPago;

    public Pedido(IdPedido idPedido) {
        super(idPedido);
    }

    public Dimensiones dimensiones() {
        return dimensiones;
    }

    public EstadoPedido estado() {
        return estado;
    }

    public Comprador comprador() {
        return comprador;
    }

    public Orden orden() {
        return orden;
    }

    public Factura factura() {
        return factura;
    }

    public Destinatario destinatario() {
        return destinatario;
    }

    public Set<IdComida> productos() {
        return productos;
    }

    public MetodoPago metodoPago() {
        return metodoPago;
    }
}
