package co.com.sofka.domain.restaurante.comida;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.comida.values.IdRecipiente;
import co.com.sofka.domain.restaurante.values.Dimensiones;

public class Recipiente extends Entity<IdRecipiente> {
    private Dimensiones dimensiones;

    public Recipiente(IdRecipiente idRecipiente) {
        super(idRecipiente);
    }

    public Dimensiones dimensiones() {
        return dimensiones;
    }
}