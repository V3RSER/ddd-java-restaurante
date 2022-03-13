package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.TipoFactura;

public class ActualizarTipoFactura extends Command {
    private final IdPedido idPedido;
    private final IdFactura idFactura;
    private final TipoFactura tipo;

    public ActualizarTipoFactura(IdPedido idPedido, IdFactura idFactura, TipoFactura tipo) {
        this.idPedido = idPedido;
        this.idFactura = idFactura;
        this.tipo = tipo;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public TipoFactura getTipo() {
        return tipo;
    }
}
