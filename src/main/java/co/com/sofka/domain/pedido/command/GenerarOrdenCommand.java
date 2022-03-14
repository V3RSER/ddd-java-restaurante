package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.pedido.values.IdPedido;

public class GenerarOrdenCommand extends Command {
    private final IdPedido idPedido;
    private final IdOrden idOrden;

    public GenerarOrdenCommand(IdPedido idPedido, IdOrden idOrden) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }
}
