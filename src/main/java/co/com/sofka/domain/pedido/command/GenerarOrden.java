package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.NombrePersona;

import java.util.Set;

public class GenerarOrden extends Command {
    private final IdPedido idPedido;
    private final IdOrden idOrden;
    private final DatosEnvio datosEnvio;
    private final Set<DatosComida> datosComidas;
    private final NombrePersona nombreComprador;

    public GenerarOrden(IdPedido idPedido, IdOrden idOrden, DatosEnvio datosEnvio, Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        this.idPedido = idPedido;
        this.idOrden = idOrden;
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.nombreComprador = nombreComprador;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public Set<DatosComida> getDatosComidas() {
        return datosComidas;
    }

    public NombrePersona getNombreComprador() {
        return nombreComprador;
    }
}
