package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.Tarjeta;

public class ActualizarTarjetaCompradorCommand extends Command {
    private final IdPedido idPedido;
    private final Tarjeta tarjeta;

    public ActualizarTarjetaCompradorCommand(IdPedido idPedido, Tarjeta tarjeta) {
        this.idPedido = idPedido;
        this.tarjeta = tarjeta;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
