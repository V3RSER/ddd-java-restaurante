package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.pedido.values.IdPedido;

public class ActualizarDireccionEntregaOrden extends Command {
    private final IdPedido idPedido;
    private final IdOrden idOrden;
    private final Direccion direccionEntrega;

    public ActualizarDireccionEntregaOrden(IdPedido idPedido, IdOrden idOrden, Direccion direccionEntrega) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
        this.direccionEntrega = direccionEntrega;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public Direccion getDireccionEntrega() {
        return direccionEntrega;
    }
}
