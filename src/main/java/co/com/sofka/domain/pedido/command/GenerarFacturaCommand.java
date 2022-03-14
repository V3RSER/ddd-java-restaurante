package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.*;

public class GenerarFacturaCommand extends Command {
    private final IdPedido idPedido;
    private final IdFactura idFactura;
    private final TipoFactura tipo;
    private final Dinero costeEnvio;
    private final MetodoPago metodoPago;
    private final IdComprador idComprador;

    public GenerarFacturaCommand(IdPedido idPedido, IdFactura idFactura, TipoFactura tipo, Dinero costeEnvio, MetodoPago metodoPago, IdComprador idComprador) {
        this.idPedido = idPedido;
        this.idFactura = idFactura;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
        this.metodoPago = metodoPago;
        this.idComprador = idComprador;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public TipoFactura getTipo() {
        return tipo;
    }

    public Dinero getCosteEnvio() {
        return costeEnvio;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public IdComprador getIdComprador() {
        return idComprador;
    }
}
