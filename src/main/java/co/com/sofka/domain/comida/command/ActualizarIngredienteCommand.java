package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Nombre;

public class ActualizarIngredienteCommand extends Command {
    private final IdComida idComida;
    private final IdIngrediente idIngrediente;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public ActualizarIngredienteCommand(IdComida idComida, IdIngrediente idIngrediente, Nombre nombre, Descripcion descripcion) {
        this.idComida = idComida;
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
