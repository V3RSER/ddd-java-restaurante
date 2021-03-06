package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.repartidor.values.IdVehiculo;
import co.com.sofka.domain.repartidor.values.Velocidad;
import co.com.sofka.domain.values.Nombre;

public class VehiculoAgregado extends DomainEvent {
    private final IdVehiculo idVehiculo;
    private final Nombre nombre;
    private final Velocidad velocidadMedia;

    public VehiculoAgregado(IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        super("domain.repartidor.vehiculoagregado");
        this.idVehiculo = idVehiculo;
        this.nombre = nombre;
        this.velocidadMedia = velocidadMedia;
    }

    public IdVehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Velocidad getVelocidadMedia() {
        return velocidadMedia;
    }
}
