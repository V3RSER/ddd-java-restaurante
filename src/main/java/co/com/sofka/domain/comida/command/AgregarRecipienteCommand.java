package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Dimensiones;

public class AgregarRecipienteCommand extends Command {
    private final IdComida idComida;
    private final IdRecipiente idRecipiente;
    private final Dimensiones dimensiones;

    public AgregarRecipienteCommand(IdComida idComida, IdRecipiente idRecipiente, Dimensiones dimensiones) {
        this.idComida = idComida;
        this.idRecipiente = idRecipiente;
        this.dimensiones = dimensiones;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public IdRecipiente getIdRecipiente() {
        return idRecipiente;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
