package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.TipoFactura;

public class ActualizarTipoFacturaCommand extends Command {
    private final IdPedido idPedido;
    private final TipoFactura tipo;

    public ActualizarTipoFacturaCommand(IdPedido idPedido, TipoFactura tipo) {
        this.idPedido = idPedido;
        this.tipo = tipo;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public TipoFactura getTipo() {
        return tipo;
    }
}
