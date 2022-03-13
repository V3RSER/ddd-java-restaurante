package co.com.sofka.domain.repartidor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.repartidor.values.IdVehiculo;
import co.com.sofka.domain.repartidor.values.Velocidad;
import co.com.sofka.domain.values.Nombre;

import java.util.Objects;


public class Vehiculo extends Entity<IdVehiculo> {
    private Nombre nombre;
    private Velocidad velocidadMedia;

    public Vehiculo(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        super(idVehiculo);
        this.nombre = nombre;
        this.velocidadMedia = velocidadMedia;
    }

    public void modificarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
        ;
    }

    public void modificarVelocidadMedia(Velocidad velocidadMedia) {
        this.velocidadMedia = Objects.requireNonNull(velocidadMedia, "La velocidad media no debe ser nula");
        ;
    }

    public Velocidad velocidadMedia() {
        return velocidadMedia;
    }
}
