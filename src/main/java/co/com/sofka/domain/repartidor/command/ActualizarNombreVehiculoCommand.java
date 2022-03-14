package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Nombre;

public class ActualizarNombreVehiculoCommand extends Command {
    private final IdRepartidor idRepartidor;
    private final Nombre nombre;

    public ActualizarNombreVehiculoCommand(IdRepartidor idRepartidor, Nombre nombre) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
