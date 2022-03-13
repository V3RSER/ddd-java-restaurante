package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Dimensiones;

public class ActualizarDimensionesMochila extends Command {
    private final IdRepartidor idRepartidor;
    private final Dimensiones dimensiones;

    public ActualizarDimensionesMochila(IdRepartidor idRepartidor, Dimensiones dimensiones) {
        this.idRepartidor = idRepartidor;
        this.dimensiones = dimensiones;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
