package co.com.sofka.domain.restaurante.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.repartidor.values.IdMochila;
import co.com.sofka.domain.restaurante.values.Dimensiones;

public class Mochila extends Entity<IdMochila> {
    private Dimensiones dimensiones;

    public Mochila(IdMochila idMochila, Dimensiones dimensiones) {
        super(idMochila);
        this.dimensiones = dimensiones;
    }

    public Dimensiones dimensiones() {
        return dimensiones;
    }
}
