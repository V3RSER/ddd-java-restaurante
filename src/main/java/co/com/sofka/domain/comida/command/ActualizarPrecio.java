package co.com.sofka.domain.comida.command;

import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Dinero;

public class ActualizarPrecio extends Command {
    private final IdComida idComida;
    private final Dinero precio;

    public ActualizarPrecio(IdComida idComida, Dinero precio) {
        this.idComida = idComida;
        this.precio = precio;
    }

    public IdComida getIdComida() {
        return idComida;
    }

    public Dinero getPrecio() {
        return precio;
    }
}
