package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.Tarjeta;
import co.com.sofka.domain.values.DatosPersona;

public class AsignarCompradorCommand extends Command {
    private final IdPedido idPedido;
    private final IdComprador idComprador;
    private final DatosPersona datosComprador;
    private final Tarjeta tarjetaComprador;

    public AsignarCompradorCommand(IdPedido idPedido, IdComprador idComprador, DatosPersona datosComprador, Tarjeta tarjetaComprador) {
        this.idPedido = idPedido;
        this.idComprador = idComprador;
        this.datosComprador = datosComprador;
        this.tarjetaComprador = tarjetaComprador;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public DatosPersona getDatosComprador() {
        return datosComprador;
    }

    public Tarjeta getTarjetaComprador() {
        return tarjetaComprador;
    }
}
