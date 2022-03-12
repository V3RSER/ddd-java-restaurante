package co.com.sofka.domain.restaurante.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.repartidor.values.IdVehiculo;
import co.com.sofka.domain.restaurante.repartidor.values.Velocidad;

public class Vehiculo extends Entity<IdVehiculo> {
    private Velocidad velocidadMedia;

    public Vehiculo(IdVehiculo idVehiculo, Velocidad velocidadMedia) {
        super(idVehiculo);
        this.velocidadMedia = velocidadMedia;
    }

    public Velocidad velocidadMedia() {
        return velocidadMedia;
    }
}
