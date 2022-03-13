package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.repartidor.values.IdZona;
import co.com.sofka.domain.values.Ciudad;

import java.util.Objects;

public class Zona extends Entity<IdZona> {
    private Ciudad ciudad;

    public Zona(IdZona idZona, Ciudad ciudad) {
        super(idZona);
        this.ciudad = ciudad;
    }

    public void modificarCiudad(Ciudad ciudad) {
        this.ciudad = Objects.requireNonNull(ciudad, "La ciudad no debe ser nula");
    }

    public Ciudad ciudad() {
        return ciudad;
    }
}