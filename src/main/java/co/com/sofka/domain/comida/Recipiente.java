package co.com.sofka.domain.comida;

import co.com.sofka.domain.comida.values.IdRecipiente;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.values.Dimensiones;

import java.util.Objects;

public class Recipiente extends Entity<IdRecipiente> {
    private Dimensiones dimensiones;

    public Recipiente(IdRecipiente idRecipiente, Dimensiones dimensiones) {
        super(idRecipiente);
        this.dimensiones = dimensiones;
    }

    public void modificarDimensiones(Dimensiones dimensiones) {
        this.dimensiones = Objects.requireNonNull(dimensiones, "Las dimensiones no deben ser nulas");
    }

    public void modificarAncho(Double ancho) {
        this.dimensiones.modificarAncho(Objects.requireNonNull(ancho, "El ancho no debe ser nulo"));
    }

    public void modificarAlto(Double alto) {
        this.dimensiones.modificarAncho(Objects.requireNonNull(alto, "El alto no debe ser nulo"));
    }

    public void modificarLargo(Double largo) {
        this.dimensiones.modificarAncho(Objects.requireNonNull(largo, "El largo no debe ser nulo"));
    }

    public Dimensiones dimensiones() {
        return dimensiones;
    }
}