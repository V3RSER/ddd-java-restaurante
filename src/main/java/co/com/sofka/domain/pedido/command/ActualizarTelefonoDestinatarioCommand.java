package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.Telefono;

public class ActualizarTelefonoDestinatarioCommand extends Command {
    private final IdPedido idPedido;
    private final Telefono telefono;

    public ActualizarTelefonoDestinatarioCommand(IdPedido idPedido, Telefono telefono) {
        this.idPedido = idPedido;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
