package co.com.sofka.domain.restaurante.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.repartidor.values.IdZona;
import co.com.sofka.domain.restaurante.values.Ciudad;

public class Zona extends Entity<IdZona> {
    private Ciudad ciudad;

    public Zona(IdZona idZona, Ciudad ciudad) {
        super(idZona);
        this.ciudad = ciudad;
    }

    public Ciudad ciudad() {
        return ciudad;
    }
}