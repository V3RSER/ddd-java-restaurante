package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.Command;

public class QuitarIngredienteCommand extends Command {
    private final IdComida idComida;
    private final IdIngrediente idIngrediente;

    public QuitarIngredienteCommand(IdComida idComida, IdIngrediente idIngrediente) {
        this.idComida = idComida;
        this.idIngrediente = idIngrediente;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }
}
