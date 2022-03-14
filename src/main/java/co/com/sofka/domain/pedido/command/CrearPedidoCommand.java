package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.InformacionComida;

import java.util.Set;

public class CrearPedidoCommand extends Command {
    private final IdPedido idPedido;
    private final Set<InformacionComida> comidas;

    public CrearPedidoCommand(IdPedido idPedido, Set<InformacionComida> comidas) {
        this.idPedido = idPedido;
        this.comidas = comidas;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public Set<InformacionComida> getComidas() {
        return comidas;
    }
}
