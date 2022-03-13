package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.DatosPersona;

public class CrearRepartidor extends Command {
    private final IdRepartidor idRepartidor;
    private final DatosPersona datosPersona;

    public CrearRepartidor(IdRepartidor idRepartidor, DatosPersona datosPersona) {
        this.idRepartidor = idRepartidor;
        this.datosPersona = datosPersona;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
    }

    public DatosPersona getDatosPersona() {
        return datosPersona;
    }
}
