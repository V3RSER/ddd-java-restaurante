package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.repartidor.values.IdRepartidor;

public class QuitarPedido extends Command {
    private final IdRepartidor idRepartidor;
    private final IdPedido pedido;

    public QuitarPedido(IdRepartidor idRepartidor, IdPedido pedido) {
        this.idRepartidor = idRepartidor;
        this.pedido = pedido;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public IdPedido getPedido() {
        return pedido;
    }
}
