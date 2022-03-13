package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.values.Nombre;

public class ActualizarNombreIngrediente extends Command {
    private final IdComida idComida;
    private final IdIngrediente idIngrediente;
    private final Nombre nombre;

    public ActualizarNombreIngrediente(IdComida idComida, IdIngrediente idIngrediente, Nombre nombre) {
        this.idComida = idComida;
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
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
}
