package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.Telefono;

public class ActualizarTelefonoComprador extends Command {
    private final IdPedido idPedido;
    private final IdComprador idComprador;
    private final Telefono telefono;

    public ActualizarTelefonoComprador(IdPedido idPedido, IdComprador idComprador, Telefono telefono) {
        this.idPedido = idPedido;
        this.idComprador = idComprador;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
