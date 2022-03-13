package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdPedido;

public class ActualizarDireccionDestinatario extends Command {
    private final IdPedido idPedido;
    private final IdDestinatario idDestinatario;
    private final Direccion direccion;

    public ActualizarDireccionDestinatario(IdPedido idPedido, IdDestinatario idDestinatario, Direccion direccion) {
        this.idPedido = idPedido;
        this.idDestinatario = idDestinatario;
        this.direccion = direccion;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
