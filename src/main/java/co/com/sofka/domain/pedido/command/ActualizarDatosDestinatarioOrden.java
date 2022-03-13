package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.DatosPersona;

public class ActualizarDatosDestinatarioOrden extends Command {
    private final IdPedido idPedido;
    private final IdOrden idOrden;
    private final DatosPersona datosDestinatario;

    public ActualizarDatosDestinatarioOrden(IdPedido idPedido, IdOrden idOrden, DatosPersona datosDestinatario) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
        this.datosDestinatario = datosDestinatario;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public DatosPersona getDatosDestinatario() {
        return datosDestinatario;
    }
}
