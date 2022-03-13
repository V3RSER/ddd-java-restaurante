package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Nombre;

public class ActualizarNombre extends Command {
    private final IdComida idComida;
    private final Nombre nombre;

    public ActualizarNombre(IdComida idComida, Nombre nombre) {
        this.idComida = idComida;
        this.nombre = nombre;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
