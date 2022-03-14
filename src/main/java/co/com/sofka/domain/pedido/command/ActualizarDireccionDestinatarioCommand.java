package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdPedido;

public class ActualizarDireccionDestinatarioCommand extends Command {
    private final IdPedido idPedido;
    private final Direccion direccion;

    public ActualizarDireccionDestinatarioCommand(IdPedido idPedido, Direccion direccion) {
        this.idPedido = idPedido;
        this.direccion = direccion;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }
}
