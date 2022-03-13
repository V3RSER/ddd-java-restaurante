package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.repartidor.values.IdZona;
import co.com.sofka.domain.values.Ciudad;

public class ActualizarZona extends Command {
    private final IdRepartidor idRepartidor;
    private final IdZona idZona;
    private final Ciudad ciudad;

    public ActualizarZona(IdRepartidor idRepartidor, IdZona idZona, Ciudad ciudad) {
        this.idRepartidor = idRepartidor;
        this.idZona = idZona;
        this.ciudad = ciudad;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public IdZona getIdZona() {
        return idZona;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
