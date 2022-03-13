package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdMochila;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Dimensiones;

public class AcualizarMochila extends Command {
    private final IdRepartidor idRepartidor;
    private final IdMochila idMochila;
    private final Dimensiones dimensiones;

    public AcualizarMochila(IdRepartidor idRepartidor, IdMochila idMochila, Dimensiones dimensiones) {
        this.idRepartidor = idRepartidor;
        this.idMochila = idMochila;
        this.dimensiones = dimensiones;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public IdMochila getIdMochila() {
        return idMochila;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
