package co.com.sofka.domain.repartidor.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.repartidor.values.IdVehiculo;
import co.com.sofka.domain.repartidor.values.Velocidad;
import co.com.sofka.domain.values.Nombre;

public class AgregarVehiculo extends Command {
    private final IdRepartidor idRepartidor;
    private final IdVehiculo idVehiculo;
    private final Nombre nombre;
    private final Velocidad velocidadMedia;

    public AgregarVehiculo(IdRepartidor idRepartidor, IdVehiculo idVehiculo, Nombre nombre, Velocidad velocidadMedia) {
        this.idRepartidor = idRepartidor;
        this.idVehiculo = idVehiculo;
        this.nombre = nombre;
        this.velocidadMedia = velocidadMedia;
    }

    public IdRepartidor getIdRepartidor() {
        return idRepartidor;
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
