package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdPedido;

public class ActualizarDireccionEntregaOrdenCommand extends Command {
    private final IdPedido idPedido;
    private final Direccion direccionEntrega;

    public ActualizarDireccionEntregaOrdenCommand(IdPedido idPedido, Direccion direccionEntrega) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }
}
