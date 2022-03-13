package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Dimensiones;

public class AsignarPedido extends Command {
    private final IdRepartidor idRepartidor;
    private final IdPedido idPedido;
    private final DatosEnvio datosEnvio;
    private final Dimensiones dimensiones;

    public AsignarPedido(IdRepartidor idRepartidor, IdPedido idPedido, DatosEnvio datosEnvio, Dimensiones dimensiones) {
        this.idRepartidor = idRepartidor;
        this.idPedido = idPedido;
        this.datosEnvio = datosEnvio;
        this.dimensiones = dimensiones;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
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
