package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;

public class EntregarOrden extends Command {
    private final IdPedido idPedido;
    private final IdPedido idOrden;

    public EntregarOrden(IdPedido idPedido, IdPedido idOrden) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdPedido getIdOrden() {
        return idOrden;
    }
}
