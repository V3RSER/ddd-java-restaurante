package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Telefono;

public class ActualizarTelefonoCommand extends Command {
    private final IdRepartidor idRepartidor;
    private final Telefono telefono;

    public ActualizarTelefonoCommand(IdRepartidor idRepartidor, Telefono telefono) {
        this.idRepartidor = idRepartidor;
        this.telefono = telefono;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
