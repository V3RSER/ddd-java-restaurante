package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.Tarjeta;

public class ActualizarTarjetaComprador extends Command {
    private final IdPedido idPedido;
    private final IdComprador idComprador;
    private final Tarjeta tarjeta;

    public ActualizarTarjetaComprador(IdPedido idPedido, IdComprador idComprador, Tarjeta tarjeta) {
        this.idPedido = idPedido;
        this.idComprador = idComprador;
        this.tarjeta = tarjeta;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
}
