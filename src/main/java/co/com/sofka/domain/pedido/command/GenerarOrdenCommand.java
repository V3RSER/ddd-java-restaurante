package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.pedido.values.IdPedido;

public class GenerarOrdenCommand extends Command {
    private final IdPedido idPedido;
    private final IdOrden idOrden;
    private final IdDestinatario idDestinatario;

    public GenerarOrdenCommand(IdPedido idPedido, IdOrden idOrden, IdDestinatario idDestinatario) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
        this.idDestinatario = idDestinatario;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }
}
