package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.TipoFactura;
import co.com.sofka.domain.values.DatosComida;

import java.util.Set;

public class ActualizarFactura extends Command {
    private final IdPedido idPedido;
    private final IdFactura idFactura;
    private final Set<DatosComida> datosComidas;
    private final TipoFactura tipo;
    private final Dinero costeEnvio;

    public ActualizarFactura(IdPedido idPedido, IdFactura idFactura, Set<DatosComida> datosComidas, TipoFactura tipo, Dinero costeEnvio) {
        this.idPedido = idPedido;
        this.idFactura = idFactura;
        this.datosComidas = datosComidas;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public Set<DatosComida> getDatosComidas() {
        return datosComidas;
    }

    public TipoFactura getTipo() {
        return tipo;
    }

    public Dinero getCosteEnvio() {
        return costeEnvio;
    }
}
