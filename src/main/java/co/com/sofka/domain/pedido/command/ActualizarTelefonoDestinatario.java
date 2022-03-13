package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.Telefono;

public class ActualizarTelefonoDestinatario extends Command {
    private final IdPedido idPedido;
    private final IdDestinatario idDestinatario;
    private final Telefono telefono;

    public ActualizarTelefonoDestinatario(IdPedido idPedido, IdDestinatario idDestinatario, Telefono telefono) {
        this.idPedido = idPedido;
        this.idDestinatario = idDestinatario;
        this.telefono = telefono;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
