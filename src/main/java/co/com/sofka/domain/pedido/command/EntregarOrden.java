package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.IdPedido;

public class EntregarOrden extends Command {
    private final IdPedido idPedido;
    private final IdFactura idFactura;

    public EntregarOrden(IdPedido idPedido, IdFactura idFactura) {
        this.idPedido = idPedido;
        this.idFactura = idFactura;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }
}
