package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Descripcion;

public class ActualizarDescripcionIngrediente extends Command {
    private final IdComida idComida;
    private final IdIngrediente idIngrediente;
    private final Descripcion descripcion;

    public ActualizarDescripcionIngrediente(IdComida idComida, IdIngrediente idIngrediente, Descripcion descripcion) {
        this.idComida = idComida;
        this.idIngrediente = idIngrediente;
        this.descripcion = descripcion;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public IdIngrediente getIdIngrediente() {
        return idIngrediente;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
