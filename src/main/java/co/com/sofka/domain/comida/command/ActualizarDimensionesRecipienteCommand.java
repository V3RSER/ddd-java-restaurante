package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Dimensiones;

public class ActualizarDimensionesRecipienteCommand extends Command {
    private final IdComida idComida;
    private final Dimensiones dimensiones;

    public ActualizarDimensionesRecipienteCommand(IdComida idComida, Dimensiones dimensiones) {
        this.idComida = idComida;
        this.dimensiones = dimensiones;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
