package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.repartidor.values.IdMochila;
import co.com.sofka.domain.values.Dimensiones;

import java.util.Objects;

public class Mochila extends Entity<IdMochila> {
    private Dimensiones dimensiones;

    public Mochila(IdMochila idMochila, Dimensiones dimensiones) {
        super(idMochila);
        this.dimensiones = dimensiones;
    }

    public void modificarDimensiones(Dimensiones dimensiones) {
        this.dimensiones = Objects.requireNonNull(dimensiones, "Las dimensiones no deben ser nulas");
    }

    public void modificarAncho(Double nuevoAncho) {
        this.dimensiones = dimensiones.modificarAncho(nuevoAncho);
    }

    public void modificarAlto(Double nuevoAlto) {
        this.dimensiones = dimensiones.modificarAlto(nuevoAlto);
    }

    public void modificarLargo(Double nuevoLargo) {
        this.dimensiones = dimensiones.modificarLargo(nuevoLargo);
    }

    public Dimensiones dimensiones() {
        return dimensiones;
    }
}
