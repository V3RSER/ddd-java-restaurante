package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.Dimensiones;

public class PedidoAsignado extends DomainEvent {
    private final IdPedido idPedido;
    private final DatosEnvio datosEnvio;
    private final Dimensiones dimensiones;

    public PedidoAsignado(IdPedido idPedido, DatosEnvio datosEnvio, Dimensiones dimensiones) {
        super("domain.repartidor.pedidoasignado");
        this.idPedido = idPedido;
        this.datosEnvio = datosEnvio;
        this.dimensiones = dimensiones;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
