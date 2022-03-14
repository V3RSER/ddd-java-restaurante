package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.Ingrediente;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.DatosComida;

import java.util.Set;

public class CrearComidaCommand extends Command {
    private final IdComida idComida;
    private final DatosComida datos;
    private final Set<Ingrediente> ingredientes;

    public CrearComidaCommand(IdComida idComida, DatosComida datos, Set<Ingrediente> ingredientes) {
        this.idComida = idComida;
        this.datos = datos;
        this.ingredientes = ingredientes;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public DatosComida getDatos() {
        return datos;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

}
