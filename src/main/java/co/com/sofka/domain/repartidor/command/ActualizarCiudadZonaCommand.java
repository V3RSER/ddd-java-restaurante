package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.Ciudad;

public class ActualizarCiudadZonaCommand extends Command {
    private final IdRepartidor idRepartidor;
    private final Ciudad ciudad;

    public ActualizarCiudadZonaCommand(IdRepartidor idRepartidor, Ciudad ciudad) {
        this.idRepartidor = idRepartidor;
        this.ciudad = ciudad;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
