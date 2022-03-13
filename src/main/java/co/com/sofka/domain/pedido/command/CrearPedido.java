package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.MetodoPago;

import java.util.Set;

public class CrearPedido extends Command {
    private final IdPedido idPedido;
    private final Set<IdComida> idProductos;
    private final MetodoPago metodoPago;

    public CrearPedido(IdPedido idPedido, Set<IdComida> idProductos, MetodoPago metodoPago) {
        this.idPedido = idPedido;
        this.idProductos = idProductos;
        this.metodoPago = metodoPago;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Set<IdComida> getIdProductos() {
        return idProductos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
}
