package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Descripcion;

public class ActualizarDescripcionCommand extends Command {
    private final IdComida idComida;
    private final Descripcion descripcion;

    public ActualizarDescripcionCommand(IdComida idComida, Descripcion descripcion) {
        this.idComida = idComida;
        this.descripcion = descripcion;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
