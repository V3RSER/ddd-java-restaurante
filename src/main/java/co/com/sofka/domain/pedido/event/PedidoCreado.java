package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.InformacionComida;

import java.util.Set;

public class PedidoCreado extends DomainEvent {
    private final Set<InformacionComida> comidas;

    public PedidoCreado(Set<InformacionComida> comidas) {
        super("domain.pedido.pedidocreado");
        this.comidas = comidas;
    }

    public Set<InformacionComida> getComidas() {
        return comidas;
    }
}
